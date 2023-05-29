## Shell script란?

### 1. Shell이란?
- Shell은 사용자와 컴퓨터 하드웨어 또는 운영체제(OS)간의 인터페이스를 제공하는 프로그램이다.
- 사용자가 입력한 명령어를 해석해서 커널 또는 OS에 명령을 요청한다.
- 쉘의 종류는 bash, csh, ksh, zsh 등이 있다.

### 2. Shell script란?
- 쉘, 인터프리트 방식으로 동작하는 컴파일 되지 않은 프로그램이다.

### 3. Shell script의 기본 구조

```bash
#!/bin/bash
echo "Hello World"
```
### 4. 기본 문법
- 주석
```bash
#!/bin/bash
# 주석
```
- 변수
```bash
#!/bin/bash
# 변수 선언
name="박현두"
echo $name
```
- 배열
```bash
#!/bin/bash
# 배열 선언
arr=("박현두" "김현두" "이현두")
# 배열 전체 출력
echo ${arr[@]}
# 배열 반복문 
for i in ${arr[@]}
do
    echo $i
done
# 배열 요소 append
arr+=("최현두")
echo ${arr[@]}
```
- if문
```bash
#!/bin/bash
if [ 1 -eq 1 ]; then
    echo "1과 1은 같다."
fi
```
- 반복문
```bash
#!/bin/bash
for i in 1 2 3 4 5
do
    echo "반복문 ${i}번째"
done
```

- 함수
```bash
#!/bin/bash
# 함수 선언
function hello() {
    echo "Hello World"
}
# 함수 호출
hello
```
