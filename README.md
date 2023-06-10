# side-project-challenge-study
사이드 프로젝트 챌린지 스터디입니다.


# 📢 스터디 규칙
1. 매주 스터디는 2시간을 기본으로 합니다. 스터디원 N명이 발표 진행 1시간, 스터디장 기술소개시간 1시간을 합니다, 스터디원 발표 내용은 이 [side-project-challenge-study](https://github.com/mooh2jj/side-project-challenge-study)를 `fork`한 후 본인 Repository에서 각 `본인이름의 디렉토리`에 `PR(Pull Request)`하여 정리해주면 됩니다.
  * fork&PR 영상 참고 -> https://www.youtube.com/watch?v=yr6IzOGoMsQ

2. 발표시 CodeReview인 점을 감안하여 `Code 내용을 중심으로 발표`를 권장합니다. (자유발표도 가능, 발표는 하고싶은 분을 1순위, 없다면 당일날 랜덤으로 정해집니다)
3. 나머지 스터디원들도 매주 해당 내용 숙지를 위해 스터디한 내용 학습, 학습한 내용을 `해당 본인이름의 디렉토리`에 `PR`하여 정리합니다. 
4. 스터디 룸 비용은 `1.3만원이며 과제(퀄리티, 완성도는 무관) 80%, 출석 3번 이상`이면 환급이 가능합니다!


<br>

# 📅 스터디 일정

<details>
<summary>1week(2023/05/06)</summary>
<div markdown="1">

  * 자기소개 시간
  * 스터디 취지, 방향, 구성 방식 설명
  * 실습 - REST API 문자열 반환 테스트
  * 과제
  ```
  1) 해당 레포지토리 fork & PR 해보기
  
  2) Centos vs Ubuntu 차이 
  3) Shell script란?
  4) MySQL5.7 vs MySQL8.0 차이
  5) git-flow 란 무엇인지 정리
  6) git 대표적 명령어 정리
  7) MySQL에서 DB 테이블 설계시 중요 요소 각 정리
  ```
 * 환경셋팅 - [https://www.notion.so/bb4d80cb1a094696b8ff27f4cd52bb00](https://www.notion.so/bb4d80cb1a094696b8ff27f4cd52bb00)

 * 노션정리 - https://www.notion.so/1week-c05cb87044784e7a847c3680b568c99e

</div>
</details>

<details>
<summary>2week(2023/05/13)</summary>
<div markdown="1">

  * 1:1 개인 면담 - 스터디원 needs 체크
  * git 명령어 + mysql 정리 + linux 실습
  * 실습 - REST API 문자열 반환 get api -> gradle build -> jar (로컬) + aws ec2 서버 deploy
  * 과제
  ```
  1) 실습 rest api 프로젝트 git 연동 -> aws ec2 서버 deploy (jar 실행)
  2) shell script 로 aws ec2 서버 deploy (jar 실행) 자동배포 
  3) mysql 명령어 연습 - 프로그래머스 SQL 코딩테스트 기출문제 Lv1~Lv4 20문제 풀기 (join, groupBy는 꼭 연습!)
  4) 책 최소 3권 정하기 -> 다음 주 1권 채택 블로그 정리 발표 준비!
  ```
 * 노션정리 - https://www.notion.so/2week-9fd123cd225f4755a70019061d210a05

</div>
</details>

<details>
<summary>3week(2023/05/20)</summary>
<div markdown="1">

  * 책 - <객.사.오> 리뷰
  * 실습 - SOLID 원칙에 기반한 프로그래밍 리팩토링 - orderDish
  * 실습 - tag, board 사이에 중간매핑테이블을 활용하여 tag 리스트가 있는 board 상세 조회 api
  * 미션
  ```
  1) 책 블로그 발표 준비
  2) JPA Entity 연관관계 매핑 연습
  2) 실습한 프로젝트 내용에 exceptionHandler 로 exception 처리 적용
  ```
 * 노션정리 - https://rain-tank-b79.notion.site/3week-9a782c2a3f7b48a584077d0f89d5c558

</div>
</details>

 <details>
<summary>4week(2023/05/27)</summary>
<div markdown="1">

  * 책 - <클린코드> 리뷰
  * exceptionHandler 로 exception 처리 적용 설명
  * 본격 사이드 프로젝트 진행 방식 및 구조 설명
  * 실습 - 사이드 프로젝트 레벨 테스트 - coupon 도메인 crud api 실습 + 리스트 조회 api 내 status 필터링 
  * 미션
  ```
  1) 팀원이 정해진 후 사이드 프로젝트 주제선정
  2) 실습 내용 , enum filter api + 페이징(paging) 적용해보기!
  3) 실습한 프로젝트 내용에 exceptionHandler 로 exception 처리 적용
  ```
 * 노션정리 - https://rain-tank-b79.notion.site/4week-d7439507b5b147fc927e5c144bf46bfc

</div>
</details>

<details>
<summary>5week(2023/06/03)</summary>
<div markdown="1">

  * 사이드 프로젝트 환경설정/컨벤션 그리고 추가 프로젝트 진단표 설명
  * 팀 내 MVP, ERD 리뷰
  * JPA 정리 (5가지로 정리) 
  * 미션
  ```
  1) MVP 다시 설정 > ERD 설계 (비-식별관계, JPA ddl-auto 없이 설정, 중간매핑테이블 직접 만들기 생각할 것!)
  2) Querydsl 2.6 이상 환결세팅 동적쿼리
  3) filter 조건에 따라 동적쿼리 & 조회 api 구현
     * url /api/coupon?page=1?&size=10?type=DISCOUNT?startAt=2020-08-10&endAt=2022-08-10 
     * startAt, endAt은 쿠폰 사용가능시작일, 사용가능마지막일임
  4) paging도 추가 -> paging info를 커스텀 Dto에 매핑해서 response 하기 
  ```
 * 노션정리 - https://www.notion.so/6week-4f751a5f855242a0b33a3350aff765cc?pvs=4

</div>
</details>
  
<details>
<summary>6week(2023/06/10)</summary>
<div markdown="1">

  * security + jwt 내용(5가지 포인트!) 기술발표
  * 카테고리 리스트 중간매핑 테이블를 통해 리스트 조회하기 실습 
  * 미션
  ```
  1) security config 설정(+jwt) 방식 각 개인 프로젝트에 적용하기
  2) 카테고리 실습 마저 하기
  3) JUnit 5 테스트코드 Service Test vs Entity Test 차이점 알아오 
  ```
 * 노션정리 - https://www.notion.so/7week-31742d1b28f84f05a62f3a6a6e840533?pvs=4

</div>
</details>

<br>

# 🎃 주의사항

1. 발표 내용에 대한 리뷰, 질문이 너무 날카로워 해당 발표자에 대한 강한 감정적인 언행은 주의해주세요 😫!
2. 질문을 받은 발표자도 Code 또는 발표내용 등을 자신과 동일시하여 지적한 것에 대해 너무 불쾌히 여기지 말으셨으면 좋겠습니다 😂!
3. 리뷰, 피드백의 핵심은 `문제점들을 찾고 발전하는 것`이라는 걸 잊지 말아주세요!
