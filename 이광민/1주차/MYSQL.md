### SELECT
- TABLE을 불러 올 때 사용
```
SELECT 열1, 열2 FROM TABLE;
```
### WHERE
- 조건식에 사용
```
SELECT 열1, 열2 FROM TABLE WHERE 조건식;
```
### ORDER BY
- 조건식을 정렬시 사용하며 제일 마지막에 위치하 기본 값은 ASC 오름 차순이다.
- DESC INDEX를 기준으로 1부터 큰수 -> 작은 수 출력 내림차순
- ASC INDEX를 기준으로 1부터 작은 수 -> 큰 수 출력 오름차순
```
SELECT * FROM TableName ORDER BY age;

SELECT * FROM TableName ORDER BY a ASC, b DESC; A를 기준으로 오른 차순 정리 후 중복된 값이 있을 시 B를 기준으로 내림차순을 정리한다.
```
### LIMIT
- ORDER BY 뒤에 위치한다
```
SELECT * FROM TableName ORDER BY age DESC LIMIT 3 3개를 출력

SELECT * FROM TableName ORDER BY age DESC LIMIT 3 , 10;(4번째 줄부터 10 출력)
```
### COUNT
- 합계
```
SELECT COUNT(*) FROM TableName;

중복제거 : SELECT DISTINCT name FROM TableName;
```
### GROUP BY
- 데이터를 정렬하고 조건에 맞는 그룹끼리 모아준다.
```

```
### IFNULL
- COLUMN의 값이 NULL일 경우 ''안의 값으로 대체하여 출력한다.
```
IFNULL(TLNO,'NONE') AS TLNO 
```
### DATA_FORMAT
- 해당 DATA를 원하는 출력 값에 맞게 출력 가능하다.
```
date_format(HIRE_YMD, '%Y-%m-%d')

FORMAT	변환 결과
%M	월(Janeary, December, ...)
%m	월(01,02, ..., 12)
%D	월(1st, 2dn, 3rd, ...)
%c	월(1, 2, ..., 12)
%b	월(Jan, Dec, ...)
%W	요일(Sunday, Monday, ...)
%a	요일(Sun, Tue, ...)
%w	요일(0, 1, 2) 0:일요일
%d	일(00, 01, 02, ...)
%e	일(0, 1, 2, ...)
%j	몇번째 일(120, 365)
%Y	연도(1987, 2000, 2013)
%y	연도(87, 00, 13)
%X	연도(1987, 2000) %V와 같이 쓰임.
%x	연도(1987, 2000) %v와 같이 쓰임.
%V	주(시작:일요일) 시작된 해의 몇번째 주인지 표시 (01-53)
일요일이 주의 첫번째일 %X 와 함께사용
%v	주(시작:월요일) 시작된 해의 몇번째 주인지 표시 (01-53)
월요일이 주의 첫번째일 %x 와 함께사용
%U	주(시작:일요일)
%u	주(시작:월요일)
%H	시(00, 01, 02, 13, 24)
%h	시(01, 02, 12)
%I(대문자 아이)	시(01, 02, 12)
%k	시(0, 1, 2, ... ~ 23)
%l(소문자 엘)	시(1, 2, 12)
%i	분(00, 01, 30)
%r	"hh:mm:ss AM
%T	"hh:mm:ss"
%S	초
%s	초
%f	micro sec(100만분의 1초)
%p	AM, PM
```
### DISTINCT
- 해당 COLUMN을 중복되는 값을 제거한 후 사용한다.
```
SELECT DISTINCT column1 FROM table;
```
