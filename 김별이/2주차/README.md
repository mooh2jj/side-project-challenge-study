## 2주차 과제

### git-flow 란 무엇인지 정리

+ https://velog.io/@byulcode/Git-Git-Flow-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4

### git 대표 명령어

> 초기 설정
```
# 사용자 이름 설정
git config --global user.name [user_name]

# 사용자 email 설정
git config --global user.email [email]
```

> 내가 자주 쓰는 명령어
```
# 새로운 git 저장소를 생성
git init

# 기존에 사용 중인 저장소를 clone해서 가져오기
git clone [URL]

# 현재 디렉토리의 모든 파일을 Staging Area로 이동
git add .

# 현재 git의 상태 보기
git status

# Staging 상태의 파일들 커밋 메시지와 함께 커밋하기
git commit -m "message"

# 커밋 히스토리를 시간의 역순으로 보여줌
git log

# 원격 저장소에 커밋 반영하기
git push

# 원격 저장소에서 커밋 가져오기
git pull
```
> branch와 merge
```
# 새로운 브랜치 생성
git branch [branch_name]

# 해당 브랜치로 이동
git checkout [branch_name]

# 현재 checkout된 브랜치에 특정 브랜치의 수정사항 병합
git merge [branch_name]
```