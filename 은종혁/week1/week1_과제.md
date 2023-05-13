### 1. 해당 레포지토리 fork & PR 해보기

### 2. CentOS vs Ubuntu

[CentOS vs Ubuntu - velog](https://velog.io/@ejh990521/CentOS-vs-Ubuntu)

### 3. Shell script란?

- shell이란?
  - OS엔 커널이 존재한다. 커널은 하드웨어에게 직접적인 명령을 수행하는, 즉 하드웨어와 직접 소통하는 역할을 한다.
  - 쉘은 이런 커널과 사용자 사이의 인터페이스이다.
- shell script란?
  - 쉘에서 사용하는 스크립트 언어가 shell script이다.
  - shell script를 통해 프로그램을 작성하고 실행시킬 수 있다.
  - 스크립트 언어인 만큼 컴파일 과정이 없고 빠르게 실행시킬 수 있다.
- shell 종류
  - Bourne Shell : 최초의 쉘
  - Bash Shell : 현재 가장 많이 쓰이는 쉘

### 4. MySQL5.7 vs MySQL8.0 차이

[MySQL5.7 vs MySQL8.0 차이 - velog](https://velog.io/@ejh990521/MySQL-8.0%EC%9D%98-%EC%A3%BC%EC%9A%94-%EB%B3%80%ED%99%94-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0feat.-chatGPT-u4ettj31)

### 5. git-flow 란 무엇인지 정리

- git을 통해 협업할때 쓰는 여러가지 전략중 git-flow가 가장 많이 쓰인다
- 5가지의 브랜치로 구성되고 항상 유지되는 브랜치(master, develop), 일정 기간 동안만 유지되는 보조 브랜치들(feature, release, hotfix)로 구성된다.
  > master : 제품으로 출시될 수 있는 브랜치  
  > develop : 다음 출시 버전을 개발하는 브랜치  
  > feature : 기능을 개발하는 브랜치  
  > release : 이번 출시 버전을 준비하는 브랜치  
  > hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치
- 개발 흐름
  > 1. 먼저 master, develop 브랜치가 생성(master에서 생성)
  > 2. 새로운 기능을 추가할때 feature를 생성(develop에서 생성)
  > 3. 기능 구현이 완료되면 develop으로 merge
  > 4. 기능 추가 작업이 완료되면 QA를 위해 release 생성
  > 5. 추가로 발생한 버그는 hotfix를 생성해 수정하고 QA 통과 후 master와 develop으로 merge
  > 6. master에서 버전 태그 관리
- 규모가 있는 프로젝트의 경우 브랜치를 나눠 merge하며 관리하기 보단 fork 후 pull requests를 통해 검수 후 merge하는 방식으로 관리한다.

### 6. git 대표적 명령어 정리

1. 세팅

```
git init : 깃 저장소 생성
git clone <저장소 url> : 저장소 복제
git remote add <원격 저장소> <저장소 url> : 새로운 원격 저장소
```

2. 커밋

```
git add <파일> : 파일 스테이지에 올리기
git commit -m “<메시지>" : 스테이지 파일 커밋

```

3. 브랜치

```
git branch : 브랜치 보기
git checkout <브랜치> : 다른 브랜치로 이동
git checkout -b <새로운 브랜치> : 새로운 브랜치 생성 후 이동
git merge <브랜치> : merge
git branch -d <삭제할 브랜치> : 브랜치 삭제
```

4. 기타

```
git log : 이력 보기
git fetch : origin에서 변경사항 가져오기
git pull : 변경사항 합치기
git push <원격 저장소> <지역 브랜치> : 원격 저장소에 푸쉬
```

### 7. MySQL에서 DB 테이블 설계시 중요 요소 각 정리

**목표** : 중복을 최소화하고 확장에 용이하며 데이터 무결성을 지키는 것

**정규화**

> 목표 : `중복 데이터를 없애고 관계를 단순하게 가져간다!`

- 제1정규화 : 원자성
  모든 속성은 하나의 값만 갖는다.
- 제2정규화 : 완전 함수적 종속(부분 종속 제거)
  모든 속성은 기본키에 종속되어야 한다.
- 제3정규화 : 이행 종속 제거
  기본기가 아닌 모든 속성 간에는 서로 종속될 수 없다.
- BCNF
  모든 결정자는 후보키에 속해야 한다

정규화를 수행하다가 성능 이슈가 생길시 반정규화도 고려한다.

**확장성**

- Primary 값으로 자동 증가하는 정수 값으로 할당

**무결성**

- 적절한 제약조건을 지정해준다.(Primary key, Foreign key...)
- Null이 불가능 하면 NotNull 설정
- 참조 무결성을 위한 FK 설정
