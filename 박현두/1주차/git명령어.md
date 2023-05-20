## git 대표 명령어 정리

### git init
- git 저장소를 초기화한다.

### git clone
- git 저장소를 복제한다.

### git add
- git 저장소에 파일을 추가한다.

### git commit
- git 저장소에 버전을 생성한다. 

### git push
- remote 저장소에 버전을 업로드한다.

### git pull
- remote 저장소에서 변경사항으 가져온다.

### git branch
- 현재 브랜치를 확인한다.

### git checkout -b [브랜치명]
- 새로운 브랜치를 생성하고 이동한다.

### git checkout [브랜치명]
- 브랜치를 전환한다.

### git merge [브랜치명]
- 현재 브랜치에서 다른 브랜치를 병합한다.
- 옵션 정리
  - --ff
    - 현 브랜치와 병합할 브랜치의 관계가 fast forward일 경우 새로운 commit을 생성하지 않고 참조만 변경한다.
    - 아닐 경우 merge-commit을 생성한다.
  - --no-ff
    - 현 브랜치와 병합할 브랜치의 관계가 fast forward 관계가 아니더라도 merge-commit을 생성한다.
  - --squash
    - 어떤 한 이력도 남기지 않고 병합할 상대 브런치에 파일 상태를 변경한다.
- fast forward 관계란?
  - 현 브랜치가 병합할 브랜치의 히스토리를 전부 포함하고 있는 관계
  
### git reset
- 버전을 되돌린다.

### git revert
- git 저장소를 이전 커밋으로 되돌린다.

### git rebase
- 두개의 공통 출처의 브랜치를 하나로 병합하고 히스토리를 남기지 않는다.

### git log
- 커밋 히스토리를 확인한다.

### git remote add [alias] [url]
- remote 저장소를 확인한다.

### git fetch
- remote 저장소에서 변경사항을 가져온다.
