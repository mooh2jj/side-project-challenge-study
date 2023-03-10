### 1) git-flow 란 무엇인지 정리
- Git을 이용한 프로젝트 관리를 위한 브랜치 관리 전략 중 하나
 > - master(main) branch: 제품으로 출시될 수 있는 브랜치로, 언제든지 배포할 수 있는 상태를 유지합니다.
 > - develop branch: 다음 출시 버전을 개발하는 브랜치입니다. 기능 개발이 완료되면 develop 브랜치에 merge됩니다.
 > - feature branch: 새로운 기능 개발을 위한 브랜치입니다. develop 브랜치에서 분기하여 기능 개발이 완료되면 develop 브랜치에 merge됩니다.
 > - release branch: 출시 버전을 준비하는 브랜치입니다. develop 브랜치에서 분기하여 배포 준비를 위한 마무리 작업을 진행합니다.
 > - hotfix branch: 출시한 제품에서 발생한 버그를 수정하기 위한 브랜치입니다. master 브랜치에서 분기하여 수정한 후, master(main)와 develop 브랜치에 merge합니다.
 > > 이러한 git-flow 전략을 이용해서 충돌이나 오류를 최소화 시킨다.

***
