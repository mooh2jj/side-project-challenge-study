# Transaction
### Transaction이란
**데이터베이스의 데이터를 조작하는 작업의 단위**로서 은행의 송금을 예시로 보면 보내는 사람의 계좌에서 돈을 빼고 받는 사람의 계좌에 돈을 추가하는 두 가지 행위가 묶인 한 작업을 예로 들 수 있으며 Transaction은 ACID 원칙을 보장해야 한다.
## ACID
### Atomicity
transaction의 작업이 부분적으로 성공하는 일이 없도록 보장하는 성질이다. 송금하는 사람의 계좌에서 돈은 빠져나갔는데 받는 사람의 계좌에 돈이 들어오지 않는 일은 없어야 한다.
### Consistency
transaction이 끝날 때 DB의 여러 제약 조건에 맞는 상태를 보장하는 성질이다. 송금하는 사람의 계좌 잔고가 0보다 작아지면 안 된다.
### Isolation
transaction이 진행되는 중간 상태의 데이터를 다른 transaction이 볼 수 없도록 보장하는 성질이다. 송금하는 사람의 계좌에서 돈은 빠져나갔는데 받는 사람의 계좌에 돈이 아직 들어가지 않은 DB 상황을 다른 transaction이 읽으면 안 된다.
### Durability
transaction이 성공했을 경우 해당 결과가 영구적으로 적용됨을 보장하는 성질이다. 한 번 송금이 성공하면 은행 시스템에 장애가 발생하더라도 송금이 성공한 상태로 복구할 수 있어야 한다.
## ACID 원칙은 완벽히 지켜지지 않는다 - Transaction의 Isolation Level
ACID원칙을 엄격하게 지키려면**동시성**이 떨어지기 때문에 ACID 원칙을 희생하여 동시성을 얻을 수 있는 방법은 Transaction의 Isolation Level이다.
## InnoDB의 Lock
### Row-level lock
테이블의 row마다 걸리는 lock이다.
- Shared lock(S lock)
  - read에 대한 lock으로 SELECT쿼리는 lock을 사용하지 않고 DB를 읽어 오지만 SELECT ... FOR SHARE 같은 일부 SELECT 쿼리는 READ 작업을 수행할 때 row에 S lcok을 건다.
- Exclusive lock(X lock)
  - write에 대한 lock으로 UPDATE, DELETE등의 수정 쿼리를 날릴 때 row에 걸리는 lock이다.
- S lock과 X lock을 거는 규칙
  - 여러 transaction이 동시에 S lock을 걸 수 있다.
  - S lock이 걸린 row에 다른 transaction이 X lock을 걸 수 없다.
  - X lock이 걸려 있는 row는 다른 transaction이 S lock, X lock을 걸 수 없다.
### Record lock
row가 아니라 DB의 index에 걸리는 lock이다.

**Record lock** 예시

c1이라는 columnn을 가진 테이블 t가 있을때 한 transaction에서
```
(Query 1 in transaction A)
SELECT c1 FROM t WHERE c1 = 10 FOR UPDATE;
```
라는 쿼리를 실행시 t.c1의 값이 10인 index에 X lock이 걸린다. 이때 다른 transaction에서
```
(Query 2 in transaction B)
DELETE FROM t WHERE c1 = 10;
```
라는 쿼리를 실행하려고 시도할 때 query 2는 t.c1 = 10인  index에 X lock을 걸려고 시도한다. 하지만 이미 query 1에서 X lock을 걸었기에  query 1이 commit되거나 rollback되기 전까지 해당 row를 삭제할 수 없고 insert, update도 불가능 하다.
### Gap lock
DB index record의 gap에 걸리는 lock이다. 여기서 gap이란 index 중 DB에 실제 record가 없는 부분이다.

예시로 아래의 테이블을 보면 id = 3, 7인 row만 있다.
```
    Index table               Database
-------------------          ---------
| id  | row addr  |          |  id   |
-------------------          ---------
|  3  | addr to 3 |--------->|   3   |
|  7  | addr to 7 |--------->|   7   |
-------------------          ---------
```
그러면 현재 id <= 2, 4 <= id <= 6, 8 <= id에 해당하는 부분에는 index record가 없고 이 부분이 바로 index record의 gap이다.

gap lock은 이런 gap에 걸리는 lock으로 해당 gap에 접근하는 다른 쿼리의 접근을 막는다. record lock의 경우는 이미 존재하는 row가 변경되지 않는 반면 gap lock은 조건에 해당하는 새로운 row가 추가되는 것을 방지한다.

**Gap lock** 예시
c1이라는 column하나가 있는 테이블 t에 c1=13, c1=17이라는 row가 있다. 이때 transaction에
```
(Query 1 in transaction A)
`SELECT c1 FROM t WHERE c1 BETWEEN 10 and 20 FOR UPDATE;`
```
라는 쿼리를 실행 시 t.c1의 값이 10과 20사이인 gap에 lock이 걸리며 transaction이 commmit 되거나 rollback 될 때까지 삽입되지 않는다.
### Lock이 해제되는 타이밍
transaction이 진행되는 동안 InnoDB엔진은 수많은 lock을 DB에 걸게 되고 이러한 lock은 모두 transaction이 commit되거나 rollback될 때 함께 unlock된다.
## Isolation Level
### Consistent Read

read(SELECT)가 수행할 때 현재 DB의 값이 아니라 특정 시점의 DB **snapshot을 읽어오는 것이며 snapshot은 commit된 변화만이 적용된 상태를 의미**한다.

 InnoDB 엔진은 각 쿼리를 실행할 때마다 실행한 쿼리의 log를 차곡차곡 저장한다. 그리고 나중에 consistent read를 할 때 이 log를 통해 특정 시점의 DB snapshot을 복구하여 가져온다.

### REPEATABLE READ

트랜잭션이 읽은 로우를 다른 트랜잭션에서 수정되는 것을 막아준다. 하지만 새로운 로우를 추가하는 것은 제한하지 않는다.

REPEATABLE READ는 반복해서 read operation을 수행하더라도 읽어 들이는 값이 변화하지 않는 정도의 isolation을 보장하는 level이다.

REPEATABLE READ transaction은 처음으로 read(SELECT) operation을 수행한 시간을 기록한다. 그리고 그 이후에는 모든 read operation마다 해당 시점을 기준으로 consistent read를 수행한다. 그렇기 때문에 다른 transaction이 commit 되더라도 새로 commit된 데이터는 보이지 않는다. 첫 read시에 snapshot을 보기 때문이다.

### READ COMMITTED : Transaction의 기본 격리수

트랜잭션이 커밋하지 않은 정보는 읽을 수 없다. 하지만 트랜잭션이 읽은 로우를 다른 트랜잭션에서 수정 할 수 있다
그래서 트랜잭션이 같은 로우를 읽었어도 시간에 따라서 다른 내용이 발견될 수 있다.

READ COMMITTED는 commit 된 데이터만 보이는 수준의 isolation을 보장하는 level이다.

REPEATABLE READ transaction이 첫 read operation을 기준으로 consistent read를 수행하는 반면, **READ COMMITTED transaction은 read operation 마다 DB snapshot을 다시 뜬다.** 그렇기 때문에 다른 transaction이 commit 한 다음에 다시 read operation을 수행하면, REPEATABLE READ와는 다르게 READ COMMITTED transaction은 해당 변화를 볼 수 있다.

### REPEATABLE READ vs READ COMMITTED

Phantom read가 일어나는 상황을 자세히 알아보자. c1 column이 있는 table t가 있다. 현재 t에는 t.c1 = 13인 row와 t.c1 = 17인 row가 존재한다. 여기서 READ COMMITTED transaction A와 transaction B가 아래와 같이 쿼리를 실행하려고 한다.
```
(Transaction A - READ COMMITTEED)
(1) SELECT c1 FROM t WHERE c1 BETWEEN 10 and 20 FOR UPDATE;
(2) SELECT c1 FROM t WHERE c1 BETWEEN 10 and 20 FOR UPDATE;
(3) COMMIT;
```
```
(Transaction B - READ COMMITTED)
(1) INSERT INTO t VALUES(15);
(2) COMMIT;
```
두 transaction이 다음과 같은 순서로 실행되었다고 해보자.
```
(A-1) SELECT c1 FROM t WHERE c1 BETWEEN 10 and 20 FOR UPDATE;
(B-1) INSERT INTO t VALUES(15);
(B-2) COMMIT;
(A-2) SELECT c1 FROM t WHERE c1 BETWEEN 10 and 20 FOR UPDATE;
(A-3) COMMIT;
```
A-1 쿼리 실행시 t.c1 = 13, t.c1 = 17인 row에 EAD COMMITTED transaction은 record lock만을 걸기에 record lock이 걸린다.
B-1 쿼리를 실행시에 t.c1 = 15인 row에 gap lock이 걸려 있지 않기에 t.c1인 row를 삽입하고 transaction B는 commit 한다.
A-2 쿼리를 실행시 isolation level이 READ COMMITTED이기 때문에 새롭게 snapshot을 갱신하는데 이 과정에서 B-2 쿼리에서 실행한 t.c1 = 15인 row를 불러 들이기에 phantom row가 발생한다.

phantom row를 해결하기 위해서는 transaction A의 isolation level을 REPEATABLE READ로 설정하여 t.c1 = 15에 gap lock을 걸어서 transaction B가 transaction A가 commit될 때 까지 기다리게 하여야 한다.

### phantom read

PHANTOM READ란, SELECT ... FOR UPDATE 쿼리와 같은 쓰기 잠금을 거는 경우 다른 트랜잭션에서 수행한 변경 작업에 의해 레코드가 보였다가 안 보였다가 하는 현상을 말한다.

![image](https://user-images.githubusercontent.com/43610417/224460705-f4998e97-9ec3-457d-bdc5-77c38316b073.png)

사용자 A가 INSERT를 실행하기 전과 후에 B가 조회했을 때 결과는 동일한 결과를 보여줘야 하지만 다른 결과를 보여주고 있다. 이것이 PHANTOM READ이며 이유는 SELECT ... FOR UPDATE 쿼리의 경우 SELECT하는 레코드에 쓰기 잠금을 걸어야 하지만 언두 영역(이전 데이터로 복구할 수 있도록 로깅해놓은 영)에 잠금을 걸 수 없기 때문이다.

### READ UNCOMMITTED

가장 낮은 격리 수준이다.  트랜잭션이 커밋되기 전에 그 변화가 다른 트랜잭션에 그대로 노출된다.
하지만 속도가 빠르기 떄문에 데이터의 일관성이 떨어지더라도, 성능 극대화를 위해 의도적으로 사용하기도 한다.

READ UNCOMMITTED은 SELECT 쿼리를 실행할 때 아직 commit 되지 않은 데이터를 읽어올 수 있다.

1. Transaction A에서 row를 삽입했다.
2. READ UNCOMMITTED transaction B가 해당 row를 읽는다.
3. Transaction A가 rollback 된다.

라고 할 때 transaction B는 commit 되지 않은 데이터를 읽어 들였다 이것을 Dirty read라고 한다.

이것이 가능한 이유는 InnoDB 엔진은 실행된 쿼리의 경우 모두 DB에 적용시키기 때문에 log를 보고 특정 시점의 snapshot을 복구하는 consistent read를 하지 않고 그냥 해당 시점의 DB를 읽으면 dirty read가 된다. 

### SERIALIZABLE

가장 강력한 트랜잭션 격리수준이다. 여러 트랜잭션이 동시에 같은 테이블 로우에 액세스하지 못하게 한다.
가장 안전하지만 가장 성능이 떨어진다.

SERIALIZABLE transaction은 기본적으로 REPEATABLE READ와 동일하다. 대신, SELECT 쿼리가 전부 SELECT ... FOR SHARE로 자동으로 변경되며 굉장히 쉽게 Deadlock에 걸릴 수 있다.

## Dirty Check
### Dirty Checking
상태 변경 검사이며 transaction이 끝나는 시점에 변화가 있는 모든 엔티티 객체를 데이터 베이스에 자동 반영해줍니다.
### 사용 이유
ALL-OR-Nothing방식으로 DML명령어들을 처리한다.
Dirty Check를 활용하여 update 쿼리를 작성하지 않아도 변화가 있는 모든 객체를 DB에 자동 반영해준다.
### Rollback
작업 중 문제가 발생했을 때 트랜젝션의 처리 과정에서 발생한 사항을 취소하며 commit 시점 까지 복구 한다.
![image](https://user-images.githubusercontent.com/43610417/222895984-238b3519-0df7-4a25-b57b-11ff71cc0262.png)

데이터 무결성이 보장된다. 정상 종료시 자동으로 commit이 되지만 비정상 종료시 자동으로 Rollback한다.
### Reflection
힙 영역에 로드된 Class타입의 객체(JVM의 클래스 로더에서 클래스 파일에 대한 로딩을 완료한 후 해당 클래스의 정보를 담은 Class타입의 객체)를 통해 

REDO VS UNDO : https://velog.io/@pk3669/Mysql-Redo-Undo-Log
Phantom read : https://steady-coding.tistory.com/562
Transaction : https://suhwan.dev/2019/06/09/transaction-isolation-level-and-lock/
