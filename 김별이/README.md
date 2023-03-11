
## 챌린지
<details>
<summary>OT</summary>
<div>

### 1) 사용 툴 설치 및 이해하기

- [x]  IntelliJ(얼티메이트 버전 추천-플러그인 사용 가능)
- [x]  MySQL, DB 접속 HediSQL or Dbeaver
- [x]  e2e 테스트용 postman
- [x]  git/github bash, zsh 설치
- [x]  putty or **MobaXterm** 설치

### 2) 해당 레포지토리 fork & PR 해보기

- [x]  https://github.com/byulcode/side-project-challenge-study

### 3) Linux Setting 환경

- [x]  ws12 설치 (windows)

<hr>

### 챌린지)
### 1) Centos vs Ubuntu 차이

#### Centos

- RHEL 기반의 리눅스 배포판이다.
- 업데이트가 느리지만  안정적이다.
- 엔터프라이즈 수준 애플리케이션에 중점을 두고 설계되었다.
- Ubuntu와 달리 Centos는 [cPanel/WHM](https://www.hostwinds.com/tutorials/cpanel-whm-overview)을 지원하기 때문에 기업에서 주로 사용한다.

#### Ubuntu

- 데비안 기반의 리눅스 배포판이다.
- 자주 업데이트 되므로 웹 위협에 취약하다.
- 사용자 경험에 중점을 두고 사용자 친화적으로 설계되었다.
- 온라인 커뮤니티, 튜토리얼, 문서 등을 통해 쉽게 정보를 얻을 수 있어 초심자가 사용하기에 적합하다.<br/><br/>


### 2) 쉘 스크립트란?
- 운영체제의 쉘에서 사용할 수 있는 명령어들의 조합을 모은 배치 파일로서, 명령어들을 한 줄씩 순차적으로 읽어 실행되도록 하는 인터프리터(Interpreter) 방식의 프로그램이다.
- 주로 반복되는 작업을 자동화하기 위해 사용된다.<br/><br/>

### 3) MySQL 5.7 vs MySQL 8.0 차이

#### MySQL 5.7

- 기본 Character Set이 latin1(2바이트) 이다.
- GRANT 명령으로 권한의 부여와 동시에 계정 생성이 가능하다.
- Descending Index 를 생성할 수는 있지만 실제로는 Ascending index로 생성된다. 이를 Backward로 읽는 방식으로 동작하기 때문에 성능 저하가 발생할 수 있다.

#### MySQL 8.0

- 기본 Character Set이 utf8mb4(가변4바이트)다. 그래서 이모지(4바이트) 같은 데이터도 손실 없이 저장 가능하다.
- 유저 생성은 CREATE USER 명령으로, 권한 부여는 GRANT 명령으로 구분해서 실행해야 한다.
- MySQL 8.0 부터 Descending Index 를 지원해 성능 저하 없이 생성할 수 있다.

</div>
</details>

<details>
<summary>1주차</summary>
<div>

### 챌린지) </br>학교 전공자로 지금까지 개발관련 배운 과목 커리큘럼을 가지고 마인드맵 만들어서 압축적으로 설명하기
<img src="https://user-images.githubusercontent.com/77001047/224380241-58d0f664-c3d9-4f40-8476-86952f8e0b65.png" width="700"/>
</div>
</details>

