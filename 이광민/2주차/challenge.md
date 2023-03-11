## git-flow 란 무엇인지 정리
### git-flow란 5종류의 브랜치가 존재한다.
- master : 제품으로 출시될 수 있는 브랜치
- develop : 다음 출시 버전을 개발하는 브랜치
- feature : 기능을 개발하는 브랜치
- release : 이번 출시 버전을 준비하는 브랜치
- hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치

![image](https://user-images.githubusercontent.com/43610417/224452355-ac4f7101-8d09-4f64-a748-251fac0acea0.png)

기본적으로 master와 develop 브랜치가 존재하며 develop 브랜치는 master에서 시작된 브랜치이다.

develop브래치에서는 상시로 버그를 수정한 커밋들이 추가되며 기능 추가가 있는 경우 develop브랜치에서 feature 브랜치를 생성한다.

그렇기 때문에 feature 브랜치는 언제나 develop 브랜치에서부터 시작한다.

모든 기능이 완성된다면 QA를 하기 위해 develop에서 release브랜치를 생성하며 QA를 진행하며 발생된 버그는 release브랜치에 수정된다.

## git 대표적 명령어 정리

## MySQL에서 DB 테이블 설계시 중요 요소 각 정리
### 무결성 - 데이터베이스 내에 모든 값은 언제나 정확한 값을 유지해야 한다.
### 유연성 - 데이터베이스 구조는 요구사항 변화에 대해 수정이 쉬워야 한다.
### 확장성 - 데이터베이스 구조는 기능 확장에 대해서 수정이 쉬워야 한다.
1. 각 이름은 의미 있는 단어를 쓰며 단어들을 구분시에는 _ 을 사용한다.
2. 프로젝트의 이름을 축약한 이름으로 한다.
  - Base Multi Web : bmw
3. 테이블의 시작은 t_ 를 사용하며 뷰는 v_ 로 시작한다.
  -  t_board - 테이블, v_board - 뷰
4. 컬럼의 이름은 f_ 로 시작하며 추가적인 접미사는 일관된 이름을 사용한다.
  - xx명 : f_xxxx_nm
  - xx번호 : f_xxxx_no 
