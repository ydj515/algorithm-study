# SQL
## IS NULL
### <a href="https://programmers.co.kr/learn/courses/30/parts/17045">문제</a>

#### 1. 이름이 없는 동물의 아이디
```SQL
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME is NULL
```

#### 2. 이름이 있는 동물의 아이디
```SQL
SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME is NOT NULL
ORDER BY ANIMAL_ID
```

#### 3. NULL 처리하기
```SQL
SELECT ANIMAL_TYPE, IFNULL(NAME,'No name') null_check, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```
