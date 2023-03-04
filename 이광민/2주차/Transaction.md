### Transaction
#### 동작 원리
- 
#### 사용 이유
- ALL-OR-Nothing방식으로 DML명령어들을 처리한다.
- 
#### Layor 계층에 따른 범위
#### 
### Rollback
- 작업 중 문제가 발생했을 때 트랜젝션의 처리 과정에서 발생한 사항을 취소하며 commit 시점 까지 복구 한다.
![image](https://user-images.githubusercontent.com/43610417/222895984-238b3519-0df7-4a25-b57b-11ff71cc0262.png)
- 데이터 무결성이 보장된다.
- 정상 종료시 자동으로 commit이 되지만 비정상 종료시 자동으로 Rollback한다.
### Proxy

### Reflection
- 힙 영역에 로드된 Class타입의 객체(JVM의 클래스 로더에서 클래스 파일에 대한 로딩을 완료한 후 해당 클래스의 정보를 담은 Class타입의 객체)를 통해 
