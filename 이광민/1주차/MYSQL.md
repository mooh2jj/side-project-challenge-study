### SELECT
- TABLE을 불러 올 때 사용
```
SELECT 열1, 열2 FROM TABLE;
```
### LIKE
- 특정 문자가 포함 된 경우 찾기 LIKE 앞에 not을 붙혀주면 반대의 의미가 된다.
```
특정 문자로 시작하는 데이터 검색

SELECT [필드명] FROM [테이블명] WHERE [필드명] LIKE '특정 문자열%';

특정 문자로 끝나는 데이터 검색

SELECT [필드명] FROM [테이블명] WHERE [필드명] LIKE '%특정 문자열';

특정 문자를 포함하는  데이터  검색

SELECT [필드명] FROM [테이블명] WHERE [필드명] LIKE '%특정 문자열%';

복수개의 특정 문자를 포함하는 데이터를 검색하기 위해서 OR연산자를 사용해야한다.

SELECT [필드명] FROM [테이블명] WHERE [필드명] LIKE '%특정 문자열%' OR [필드명] LIKE '%특정 문자열2%';
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
- 예시 TABLE : hero_collection

|IDX|TYPE|NAME|
|------|---|---|
|1|1|안중근|
|2|1|윤봉길|
|3|2|김유신|
|4|2|이순신|
|5|3|이성계|
|6|3|왕건|
|7|4|반갑수|

```
type 그룹화하여 name 갯수 조회 (컬럼 그룹화)

SELECT type, COUNT(name) AS cnt FROM hero_collection GROUP BY type;
```

|TYPE|CNT|
|------|---|
|1|2|
|2|2|
|3|2|
|4|1|

```
type 1 초과인, type 그룹화하여 name 갯수 조회 (조건 처리 후 컬럼 그룹화)

SELECT type, COUNT(name) AS cnt FROM hero_collection WHERE type > 1 GROUP BY type;
```
|TYPE|CNT|
|------|---|
|2|2|
|3|2|
|4|1|

```
type 그룹화하여 name 갯수를 가져온 후, 그 중에 갯수가 2개 이상인 데이터 조회 (조건 처리 후에 컬럼 그룹화 후에 조건 처리)

SELECT type, COUNT(name) AS cnt FROM hero_collection GROUP BY type HAVING cnt >= 2;
```

|TYPE|CNT|
|------|---|
|1|2|
|2|2|
|3|2|

```
type 1 초과인, type 그룹화하여 name 갯수를 가져온 후, 그 중에 갯수가 2개 이상인 데이터를 type 내림차순 정렬로 조회 (내림차순 정렬)

SELECT type, COUNT(name) AS cnt FROM hero_collection
WHERE type > 1 GROUP BY type HAVING cnt >= 2 ORDER BY type DESC;
```

|TYPE|CNT|
|------|---|
|3|2|
|2|2|

### IF
```
IF(expr1, expr2, expr3) : expr1이 TRUE 이면 expr2를 리턴하고, 그렇지 않은 경우 expr3를 리턴한다.
```
### IFNULL
- COLUMN의 값이 NULL일 경우 ''안의 값으로 대체하여 출력한다.
```
IFNULL(TLNO,'NONE') AS TLNO : TLNO의 값이 NULL인 COLUMNS들을 NONE으로 대체하여 출력하고 COLUMNS이름을 TLNO로 만든다.

IF(expr1, expr2, expr3) : expr1이 TRUE 이면 expr2를 리턴하고, 그렇지 않은 경우 expr3를 리턴한다.

IFNULL(expr1, expr2) : expr1이 NULL이면 expr2를 리턴하고, NULL이 아니면 expr1을 리턴한다.
```
### DATA_FORMAT
- 해당 DATA를 원하는 출력 값에 맞게 출력 가능하다.
```
date_format(HIRE_YMD, '%Y-%m-%d')

YEAR('2011-00-09 07:18:59')
2011 출력

MONTH('2011-00-09 07:18:59')
00 출력

DATE('2011-10-09 07:18:59')
2011-10-09 출

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
## JOIN

![image](https://user-images.githubusercontent.com/43610417/222868517-c9349de2-bf5b-4fa5-976d-c278278abbec.png)

### LEFT JOIN

![image](https://user-images.githubusercontent.com/43610417/222868694-e4aa0e23-9b7c-4d90-8119-8b81f9b7d49c.png)

- A TABLE

![image](https://user-images.githubusercontent.com/43610417/222868555-d66592af-dce2-48ac-943f-4ab98e5965e7.png)

- B TABLE

![image](https://user-images.githubusercontent.com/43610417/222868558-4babb1e6-bec4-4e0d-8e4a-623b30523009.png)

- 결과

![image](https://user-images.githubusercontent.com/43610417/222868580-9e273fbf-0c99-4bff-bce8-36deeac54ea2.png)

```
select a.id, a.name, a.age, b.school, b.explanation from a
left join b on a.id = b.id
order by a.id asc;
```

### INNER JOIN

![image](https://user-images.githubusercontent.com/43610417/222868674-b8062911-0541-47c0-ae14-59fc62a325ad.png)

### OUTER JOIN

![image](https://user-images.githubusercontent.com/43610417/222868700-15ffa359-5f5d-4e19-bc3a-f79436c145d1.png)

사진 출처 : https://futurists.tistory.com/17, https://yoo-hyeok.tistory.com/98
