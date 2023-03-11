## 1주차

### 1) git-flow 란 무엇인지 정리

+ https://velog.io/@byulcode/Git-Git-Flow-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4

</br>

### 2) git 대표 명령어

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
</br>

### 3) MySQL에서 DB 설계시 주요 요소 정리
+  반드시 기본키를 갖는다.
+ 외래키 외에 불필요하게 중복되는 필드들을 포함하지 않는다. 
+  의미적으로 관련 있는 속성들끼리 테이블 구성한다. 여러 관심사가 한 테이블에 존재하는 경우 데이터 중복, 삽입 이상(Insertion Anomaly) 등이 발생할 수 있다. 
+  중복 데이터를 최대한 허용하지 않도록 설계해야 한다.
+  join 수행시 가짜 데이터가 생기지 않도록 설계해야 한다. 
+ null값을 처리할 때 비용이 발생하므로 null값을 줄일 수 있는 방향으로 설계해야 한다. 

**Reference**</br>
+ https://velog.io/@sontulip/how-to-db-design
+ https://www.youtube.com/watch?v=JwfQ8ouhAzA&ab_channel=%EC%89%AC%EC%9A%B4%EC%BD%94%EB%93%9C

