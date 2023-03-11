# Side project Challenge 1_week

### git-flow 란 무엇인가?
<hr>

- Git으로 형상관리를 할 대 브랜치를 효율적으로 관리하기 위해 사용하는 **브랜치 관리 전략**

- feature - develop(dev) - release - hotfix - master 단계로 브랜치를 나눠 코드를 관리하는 전략이며 사용자가 쉽게 접근하고 사용할 수 있도록 확장 기능(명령어)을 제공함

<details>
<summary>깃플로우 예시</summary>
<div markdown="1">
<img src="https://techblog.woowahan.com/wp-content/uploads/img/2017-10-30/git-flow_overall_graph.png" width="500">
</div>
</details>

깃 플로우라고 무조건 좋은건 아니다. 팀의 개발 스타일에 따라 맞게 변형해서 사용하는게 좋다! 
[링크](https://vallista.kr/git-flow;-%ED%99%98%EC%83%81%EA%B3%BC-%ED%98%84%EC%8B%A4-%EA%B7%B8-%EC%82%AC%EC%9D%B4%EC%97%90-%EC%84%9C%EB%B9%84%EC%8A%A4/)

### git 대표 명령어들
개발하는데 주로 썼던 명령어를 적어보겠다



현재 위치에서 지역 저장소를 생성한다
> git init

<br>

원격 저장소를 저장소를 clone 해서 가져올 수 있다.

> git clone [url]

<br>

현재 git의 상태를 확인한다.

> git status

<br>

새로운 브랜치를 생성한다.

> git branch [branch name]

<br>

해당 하는 브랜치로 이동한다

> git checkout [branch name]

<br>

수정한 전체 파일을 스테이지에 올린다
> git add .

<br>

커밋 메시지와 함께 커밋

> git commit -m "커밋 메시지"

<br>

지역 저장소의 커밋을 원격 저장소에 올린다
> git push 

<br>

원격 저장소의 커밋을 지역 저장소로 가져옴
> git pull



### MySQL 에서 DB 테이블 설계시 중요 요소 정리
#### 1. 반드시 Primary Key를 정의하고 최대한 작은 데이터 타입을 선정한다.
> 로그 성 테이블에도기본적으로 PK 생성을 원칙으로 함
InnoDB에서 PK는인덱스와 밀접한 관계를 가지므로 최대한 작은 데이터 타입을 가지도록 유지



#### 2. 테이블 Primary Key는 auto_increment를 사용한다.

> InnoDB에서는 기본키 순서로 데이터가 저장되므로, Random PK 저장 시 불필요한 DISK I/O가 발생 가능
InnoDB의 PK는절대 갱신되지 않도록 유지
(갱신 시 갱신된 행이후 데이터를 하나씩 새 위치로 옮겨야 함)



#### 3. 데이터 타입은 최대한 작게 설계한다.

> 시간정보는MySQL데이터 타입 date/datetime/timestamp 활용
IP는INET_ATON(‘IP’), INET_NTOA(int) 함수를 활용
정수 타입으로 저장가능한 문자열 패턴은 최대한 정수 타입으로 저장



#### 4. 테이블 내 모든 필드에 NOT NULL 속성을 추가한다.

> NULL을 유지를 위한추가 비용 발생
(NULL 허용 칼럼을인덱싱 할 때 항목마다 한 바이트 씩 더 소요)



#### 5. Partitioning을 적절하게 고려하여 데이터를 물리적으로 구분한다.

> 데이터 및 인덱스파일이 커질수록 성능이 저하되므로Partitioning 유도
PK 존재 시 PK내부에 반드시 Partitioning 조건이 포함되어야 함


#### Reference
- https://mikyung.net/1267
- https://gorokke.tistory.com/22
- https://onlyfor-me-blog.tistory.com/433
- https://vallista.kr/git-flow;-%ED%99%98%EC%83%81%EA%B3%BC-%ED%98%84%EC%8B%A4-%EA%B7%B8-%EC%82%AC%EC%9D%B4%EC%97%90-%EC%84%9C%EB%B9%84%EC%8A%A4/