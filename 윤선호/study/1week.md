### 1) git-flow 란 무엇인지 정리
- Git을 이용한 프로젝트 관리를 위한 브랜치 관리 전략 중 하나
 > - master(main) branch: 제품으로 출시될 수 있는 브랜치로, 언제든지 배포할 수 있는 상태를 유지합니다.
 > - develop branch: 다음 출시 버전을 개발하는 브랜치입니다. 기능 개발이 완료되면 develop 브랜치에 merge됩니다.
 > - feature branch: 새로운 기능 개발을 위한 브랜치입니다. develop 브랜치에서 분기하여 기능 개발이 완료되면 develop 브랜치에 merge됩니다.
 > - release branch: 출시 버전을 준비하는 브랜치입니다. develop 브랜치에서 분기하여 배포 준비를 위한 마무리 작업을 진행합니다.
 > - hotfix branch: 출시한 제품에서 발생한 버그를 수정하기 위한 브랜치입니다. master 브랜치에서 분기하여 수정한 후, master(main)와 develop 브랜치에 merge합니다.
 > > 이러한 git-flow 전략을 이용해서 충돌이나 오류를 최소화 시킨다.

***
### 2) git 대표적 명령어 정리

```
# 깃 저장소 초기화
git init

# 스테이징 영역에 디렉토리 옮기기.
git add [디렉토리명]

# 스테이징 영역에 추가된 변경 사항들을 커밋함.
git commit -m "[커밋 메시지]"

# 원격 저장소에 commit 내용 반영하기
git push

# 원격 저장소 변경내역 로컬에 가져오기.
git pull

# 원격 저장소를 로컬에 복사하기
git clone [url]

# 브랜치 생성하기
git branch [브랜치명]

# 브랜치 변경하기
git checkout [브랜치명]

# 브랜치 병합하기
git merge

# 로컬 저장소와 연결된 원격 저장소 확인하기
git remote

# 변경된 내용 확인하기
git diff

# 커밋 이력 확인하기
git log
```

