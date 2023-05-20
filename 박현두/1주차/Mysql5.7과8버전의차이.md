## Mysql5.7과 8버전의 차이점

### 데이터 사전 변경
* 데이터 사전이란? 
  * 데이터베이스 개체에 대한 모든 정보를 저장하는 테이블이다. 
* 사전 데이터가 메타데이터 파일과 비트랜잭션 시스템 테이블에 저장되었던 5.7버전과 달리 8.0버전은 데이터 사전을 통합하여 데이터베이스 개체에 대한 정보를 포함한다.

### 기본 인증 플러그인이 caching_sha2_password으로 변경
* mysql_native_password에서 caching_sha2_password로 변경되었다.
* caching_sha2_password을 사용하려면
  * SSL 보안연결을 사용거나
  * RSA 보안을 적용한 비암호 연결을 사용해야 한다.

### 구성 변경
* 기본 인코딩이 latin1에서 utf8mb4로 변경되었다.
  * latin1은 ASCII와 일부 확장된 라틴문자만 지원
  * utf8mb4는 모든 유니코드 문자를 지원
  * latin1은 1바이트로 저장되고 utf8mb4는 1~4바이트로 저장된다.
  * latin1은 이모지와 일부 특수문자를 지원하지 않으나 utf8mb4는 이모지와 대부분 특수문자를 지원한다.
* 서버 초기화 후 재기동 시 lower_case_table_names 설정을 변경하여 재기동하는 것을 금지한다.

### 서버 변경
* 사용자 권한 및 시스템 변수 수정 함수 일부가 제거되었다. ex) 사용자 계정의 비권한 특성, NO_AUTO_CREATE_USERSQL 모드, PASSWORD()함수
* mysql dump 사용할 때 sqlmode 옵션을 사용할 수 없게 되었다.

### InnoDB 변경 사항

* InnoDB 데이터 사전 명 변경

| 원래 테이블명           | 변경된 테이블명           |
|------------------------|---------------------------|
| INNODB_SYS_COLUMNS     | INNODB_COLUMNS            |
| INNODB_SYS_DATAFILES   | INNODB_DATAFILES          |
| INNODB_SYS_FIELDS      | INNODB_FIELDS             |
| INNODB_SYS_FOREIGN     | INNODB_FOREIGN            |
| INNODB_SYS_FOREIGN_COLS| INNODB_FOREIGN_COLS       |
| INNODB_SYS_INDEXES     | INNODB_INDEXES            |
| INNODB_SYS_TABLES      | INNODB_TABLES             |
| INNODB_SYS_TABLESPACES | INNODB_TABLESPACES        |
| INNODB_SYS_TABLESTATS  | INNODB_TABLESTATS         |
| INNODB_SYS_VIRTUAL     | INNODB_VIRTUAL            |


### SQL 변경
* 8버전에서 group by 절에서 정렬기능이 제거되었다.
* 외래키에 대한 제약조건 정의 동작방식이 변경되었다.


### 변경된 서버 기본값
* 출처 페이지 참고

출처
https://dev.mysql.com/doc/refman/8.0/en/upgrading-from-previous-series.html


