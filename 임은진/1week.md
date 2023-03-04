##  리눅스의 종류

종류는 다양하지만 **CentOS와 Ubuntu**를 가장 대중적으로 사용한다.<br>

**centOS : 레드헷 계열**<br>레드헷(페도라) 리눅스의 무료 배포판<br>커뮤니티를 통해 지원이 되어 패치가 느림<br>업데이트가 빈도가 적은만큼 더 안정적인 버전으로 출시<br>그만큼 보안이 강함. 실제 상용서비스를 하는 서버에 적합<br>패키지 : yum<br><br>**ubuntu : 데비안 계열**<br>업데이트가 빠르고 배포주기가 짧음<br>업데이트 된 패키지들이 안정화 되기까지 조금의 시간이 걸릴수있음<br>쉬운 설치나 사용방법으로 개인용 데스크톱 사용자에게 적합<br>패키지 : apt-get, aptitude<br>

##  쉘

OS상에서 사용자가 입력하는 명령을 해석하여 실행해주는 프로그램. OS의 커널과 유저 사이를 이어주는 역할이다. 쉘은 bash, sh, csh, ksh, tcsh 등 다양한 종류가 있다<br>

##  쉘 스크립트

유닉스 명령어들을 조합해서 만든 batch 파일.<br>쉘 스크립트를 활용해서 묶은 명령어 조합을 수행하거나, 반복적인 명령어를 하나의 명령으로 편하게 사용할 수 있다.<br>

## Windows에 WSL2로  Ubuntu 설치
이전 가상머신을 통해 centOS를 설치할 때 보다 훨씬 쉬웠다.<br>전체적인 설치는 https://gaesae.com/161 블로그의 도움을 받아 어렵지않게 할 수 있었지만,<br>설치하는 과정에 몇번의 반복이나 오류를 겪은 적이 있어서 그런 내용들만 따로 기재하려한다.<br>

1. wsl --set-default-version 2 를 입력해 버전을 바꿀때, wsl를 찾지 못하는 문제가 있는 경우
- 삭제 후 재설치를 하는 과정에 버전과 관련없이 wsl자체가 삭제되어서 발생하는 문제. 
- **wsl --install** 로 재설치

<br>

2. 업데이트 패키지 설치 시 바로 finish 단계로 이동하면서 "this update only applies to machines with the windows subsystem for linux" 팝업이 뜰 때<br>
- 윈도우 기본메뉴인 'Windows 기능 켜기/끄기' 로 진입하
- 'Windows subsystem for Linux(Linux용 Windows 하위 시스템)'과 'Virtual Machine Platform(가상 머신 플랫폼)' 체크박스를 해제 후 재부팅, 재부팅 되면 다시 체크하고 재부팅

두가지 과정을 거치고 정상적으로 설치 진행했다
