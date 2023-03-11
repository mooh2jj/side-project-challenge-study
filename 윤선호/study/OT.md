- 정리

1) 사용 툴 설치 및 이해하기
* IntelliJ(얼티메이트 버전 추천-플러그인 사용 가능) (완료)
* MySQL, DB 접속 HediSQL or Dbeaver (완료)
* e2e 테스트용 postman (완료)
* git/github bash, zsh 설치 (완료)
* putty or MobaXterm 설치 (완료)

챌린지)
1) Centos vs Ubuntu 차이 
- 패키지 관리 시스템 : CentOS는 RPM(Red Hat Package Manager)을 사용하고, Ubuntu는 dpkg(Debian Package)을 사용합니다.

- 배포 주기 : CentOS는 상대적으로 더 느리게 업데이트되며, 안정성과 보안성이 우선시됩니다. Ubuntu는 빠른 업데이트 주기를 가지고 있으며, 새로운 기능과 패키지가 빠르게 추가됩니다.

- 커뮤니티 : Ubuntu는 개인 및 소규모 기업을 대상으로 한 비즈니스 모델로 시작되어, 커뮤니티에 친화적입니다. CentOS는 기업 환경에서의 안정성과 보안성을 위해 더 많은 지원 및 서비스를 제공합니다.

- 디렉토리 구조 : CentOS는 /etc/sysconfig, /var/log/messages 등과 같은 Red Hat 계열의 디렉토리 구조를 사용합니다. Ubuntu는 /etc/default, /var/log/syslog 등과 같은 Debian 계열의 디렉토리 구조를 사용합니다.

- 패키지 기본값 : CentOS는 일반적으로 더 적은 패키지가 설치되어 있습니다. Ubuntu는 더 많은 패키지가 설치되어 있습니다.

- 지원되는 아키텍처 : CentOS는 x86, x86_64, IA-64, PowerPC 등 다양한 아키텍처를 지원합니다. Ubuntu는 x86, x86_64, ARM 등을 지원합니다.

- 라이선스 : CentOS는 Red Hat Enterprise Linux(RHEL)의 소스 코드를 무료로 사용 가능한 CentOS Public License를 사용합니다. Ubuntu는 GNU General Public License(GPL)을 사용합니다.
***
2) 쉡 스크립트란?
- Shell 명령어들을 텍스트 파일이 모아서 실행해주는 개념
- 컴파일 없이 리눅스 환경에서 쉘을 인터프리터로 바로 해석해서 실행시켜줌 -> 간단명령 구현에 사용
***
3) MySQL5.7 vs MySQL8.0 차이

* 사용자 인증방식 변경

* MySQL 8.0과의 호환성 체크

* 외래키 이름의 길이 (64bit로 제한)

* 인덱스 힌트

* GROUP BY 에 사용된 정렬 옵션

* 파티션을 위한 공용 테이블 스페이스

[MySQL 8.0 업그레이드 종류]

1. 데이터 딕셔너리 업그레이드 : MySQL 5.7 버전까지는 데이터 딕셔너리 정보가 FRM 확장자를 가진 파일로 별도로 보관됐었는데, MySQL 8.0 버전부터는 데이터 딕셔너리 정보가 트랜잭션이 지원되는 InnoDB 테이블로 저장되도록 개선됐다. 데이터 딕셔너리 업그레이드는 기존의 FRM 파일의 내용을 InnoDB 시스템 테이블로 저장한다. MySQL 8.0 버전부터는 딕셔너리 데이터의 버전 간 호환성 관리를 위해 테이블이 생성될 때 사용된 MySQL 서버의 버전 정보도 함께 기록한다.


2. 서버 업그레이드 : MySQL 서버의 시스템 데이터베이스(performance_schema와 information_schema, 그리고 mysql 데이터베이스)의 테이블 구조를 MySQL 8.0 버전에 맞게 변경한다.