##  리눅스의 종류

종류는 다양하지만 **CentOS와 Ubuntu**를 가장 대중적으로 사용한다.<br>

**centOS : 레드헷 계열**<br>레드헷(페도라) 리눅스의 무료 배포판<br>커뮤니티를 통해 지원이 되어 패치가 느림<br>업데이트가 빈도가 적은만큼 더 안정적인 버전으로 출시<br>그만큼 보안이 강함. 실제 상용서비스를 하는 서버에 적합<br>패키지 : yum<br><br>**ubuntu : 데비안 계열**<br>업데이트가 빠르고 배포주기가 짧음<br>업데이트 된 패키지들이 안정화 되기까지 조금의 시간이 걸릴수있음<br>쉬운 설치나 사용방법으로 개인용 데스크톱 사용자에게 적합<br>패키지 : apt-get, aptitude<br>

##  쉘

OS상에서 사용자가 입력하는 명령을 해석하여 실행해주는 프로그램. OS의 커널과 유저 사이를 이어주는 역할이다. 쉘은 bash, sh, csh, ksh, tcsh 등 다양한 종류가 있다<br>

##  쉘 스크립트

유닉스 명령어들을 조합해서 만든 batch 파일.<br>쉘 스크립트를 활용해서 묶은 명령어 조합을 수행하거나, 반복적인 명령어를 하나의 명령으로 편하게 사용할 수 있다.<br>

## Windows에 WSL2로  Ubuntu 설치
이전 가상머신을 통해 centOS를 설치할 때 보다 훨씬 쉬웠다.<br>전체적인 설치는 https://gaesae.com/161 블로그의 도움을 받아 어렵지않게 할 수 있었지만,<br>설치하는 과정에 몇번의 반복이나 오류를 겪은 적이 있어서 그런 내용들만 따로 기재하려한다.<br>

1. wsl --set-default-version 2 를 입력해 버전을 바꿀때, wsl를 찾지 못하는 문제가 있는 경우<br>
- 삭제 후 재설치를 하는 과정에 버전과 관련없이 wsl자체가 삭제되어서 발생하는 문제. <br>
- **wsl --install** 로 재설치<br>

<br>

2. 업데이트 패키지 설치 시 바로 finish 단계로 이동하면서 "this update only applies to machines with the windows subsystem for linux" 팝업이 뜰 때<br>
- 윈도우 기본메뉴인 'Windows 기능 켜기/끄기' 로 진입함<br>
- 'Windows subsystem for Linux(Linux용 Windows 하위 시스템)'과 'Virtual Machine Platform(가상 머신 플랫폼)' 체크박스를 해제 후 재부팅, 재부팅 되면 다시 체크하고 재부팅<br>

두가지 과정을 거치고 정상적으로 설치 진행했다<br><br>

## MySQL 5.7 vs 8.0
1. MySQL 8.0부터 내림차순 인덱스 지원<br>
- 5.7. 버전에서도 문법은 지원하였으나 실행이 되지 않았음. 읽기 성능이 대폭 향상<br><br>

2. Invisible 인덱스<br>
인덱스의 존재 유무를 알려줄지 말지 결정하기 위한 기능.<br>
INVISIBLE 한 상태라고 하더라도 삭제된 것은 아니기 때문에 VISIBLE 인덱스와 완전히 동일하게 데이터 변경에 따른 유지 관리가 이루어짐<br><br>

3. InnoDB 재설계.
버퍼 작업이 최적화 되어서InnoDB 행 작업시 스레드 수가 증가하면 8.0버전이 성능이 좋음

* 참고페이지 설명구문<br>
InnoDB 테이블에 AUTO_INCREMENT 속성의 필드를 추가하면,  InnoDB 테이블 정보 저장 공간에 AUTO_INCREMENT 카운터를 보관합니다.<br>
MySQL 8.0 이전 버전까지 이 카운터는 디스크가 아닌 메모리 상에만 보관되었기 때문에 MySQL 서버가 재시작되면 이 카운터를 초기화해야 했습니다.<br>
따라서 MySQL 서버가 재시작된 이후 첫 번째 insert 구문이 실행되는 시점에 InnoDB는 위와 같은 구문을 먼저 실행해 얻은 결과에 <br>
1 증가시킨 값으로 카운터를 메모리에 로드했습니다. (auto_increment_increment이 설정된 경우 해당 값만큼 증가)<br>
이러한 Auto_Increment의 초기화 방식은 MySQL 8.0에서 변경되었는데요, <br>
자동 증가 값이 변경될 때마다 redo log에 매번 기록하고, 각 체크포인트를 관리하는 스토리지 엔진의 시스템 테이블에 해당 내용을 저장하게 되었습니다.<br>
따라서 정상적인 종료 후 서버를 다시 시작하면<br>
Data Dictionary 시스템 테이블에 저장된 가장 큰 자동 증가 값을 사용해 메모리의 Auto_Increment 카운터를 초기화합니다.<br>

| 참고url : https://medium.com/naver-cloud-platform/%EC%9D%B4%EB%A0%87%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EC%84%B8%EC%9A%94-mysql-8-0-%EA%B0%9C%EB%B0%9C%EC%9E%90%EB%A5%BC-%EC%9C%84%ED%95%9C-%EC%8B%A0%EA%B7%9C-%EA%B8%B0%EB%8A%A5-%EC%82%B4%ED%8E%B4%EB%B3%B4%EA%B8%B0-1-innodb-d638a3e4fde9

<br><br>
따라서 부하가 많은 서비스 일수록 8.0이 유리함
