- 정리

### 1) 사용 툴 설치 및 이해하기

- [x] IntelliJ(얼티메이트 버전 추천-플러그인 사용 가능)
- [x] MySQL, DB 접속 HediSQL or Dbeaver
- [x] e2e 테스트용 postman
- [x] git/github bash, zsh 설치
- [x] putty or MobaXterm 설치 -> iTerm2 설치했습니다.

### 2) 해당 레포지토리 fork & PR 해보기

- 완료

### 3) Linux Setting 환경 -> window 사용자는 wsl2 설치, mac 사용자는 homebrew&iterm2 설치

- 설치 완료

### 4) Linux 명령어 + MySQL SQL 학습

- 꾸준히 학습하고 있습니다.

<br>
<hr>

### 챌린지)

### 1) Centos vs Ubuntu 차이

#### Centos

- RHEL(Red Hat Enterprise Linux) 기반의 유료 버전 리눅스 무료 배포판 <br>
  유료 버전의 무료판인 만큼 사용할 수 내부 기능이 조금 적음 오히려 가벼워서 좋다는 말도 있음
- 기업대상, 유료 버전인 만큼 최신 업데이트나 보안 이런 부분에서 상당히 보수적
- 다음 버전이 나오는 텀이 김, 서포트 사이클도 김 패키지 정기적 업데이트도 없음
- 웹 호스팅 호환성면에서 Centos가 훨씬 유리하다고 함

#### Ubuntu

- 데비안 기반의 리눅스 무료 배포판 <br>
- 개인용, 데스크톱 지향적임
- 매 2년마다 LTS 버전 출시 6개월 마다 최신 업데이트 제공 (패키지, 소프트웨어 등등)
- 문제 발생에 따른 documentation 무료 서포트가 많음

<hr>

### 2) 쉡 스크립트란?

- 리눅스 쉘에서 사용할 수 있는 명령어들의 조합을 모아서 만든 배치 파일 <br>
  명령어들을 매번 직접 쳐서 작업을 수행하기 보단 한 파일안에 모은다음에 그 파일을 실행시켜버리면
  훨씬 더 편하다. 그 파일이 쉘 스크립트!

<hr>

### 3) MySQL5.7 vs MySQL8.0 차이

- I/O 바운드 읽기 전용 <br>
  8.0부터 내림차순 인덱스를 지원함에 따라 읽기 성능에서 크게 개선됨

- 읽기 쓰기<br>
  스레드 수가 증가하면 8.0에서 더 효율성이 좋다고 함

- 이중 쓰기 버퍼, I/O 바인딩 읽기 쓰기<br>
  innoDB행 작업 또한 스레드수 증가하면 8.0이 성능이 좋다고 함

#### Reference

- https://www.fastwebhost.in/blog/centos-vs-ubuntu/
- https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=changfen15&logNo=221414926213
- https://hinweis.tistory.com/65
