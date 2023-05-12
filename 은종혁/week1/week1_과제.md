### 1. 해당 레포지토리 fork & PR 해보기

### 2. CentOS vs Ubuntu

[CentOS vs Ubuntu](https://velog.io/@ejh990521/CentOS-vs-Ubuntu)

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

### 7. MySQL에서 DB 테이블 설계시 중요 요소 각 정리
