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
ACID원칙을 strict하게 지키려면**동시성**이 떨어지기 때문에 ACID 원칙을 희생하여 동시성을 얻을 수 있는 방법은 Transaction의 Isolation Level이다.
## InnoDB의 Lock
### Row-level lock
- Shared lock(S lock)
  - read에 대한 lock으로 SELECT쿼리는 lock을 사용하지 않고 DB를 읽어 오지만 SELECT ... FOR SHARE 같은 일부 SELECT 쿼리는 READ 작업을 수행할 때 row에 S lcok을 건다.
- Exclusive lock(X lock)
  - write에 대한 lock으로 UPDATE, DELETE등의 수정 쿼리를 날릴 때 row에 걸리는 lock이다.
### Isolation Level
### 동작 원리

### 사용 이유
ALL-OR-Nothing방식으로 DML명령어들을 처리한다.
### Layor 계층에 따른 범위
### Rollback
작업 중 문제가 발생했을 때 트랜젝션의 처리 과정에서 발생한 사항을 취소하며 commit 시점 까지 복구 한다.
![image](https://user-images.githubusercontent.com/43610417/222895984-238b3519-0df7-4a25-b57b-11ff71cc0262.png)

데이터 무결성이 보장된다. 정상 종료시 자동으로 commit이 되지만 비정상 종료시 자동으로 Rollback한다.
### Proxy

### Reflection
힙 영역에 로드된 Class타입의 객체(JVM의 클래스 로더에서 클래스 파일에 대한 로딩을 완료한 후 해당 클래스의 정보를 담은 Class타입의 객체)를 통해 
