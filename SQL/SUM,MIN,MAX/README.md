# SQL
## SUM, Min, Max
### <a href="https://programmers.co.kr/learn/courses/30/parts/17043">문제</a>

#### 1. 최댓값 구하기
```SQL
SELECT MAX(DATETIME)
FROM ANIMAL_INS
```

#### 2. 최솟값 구하기
```SQL
SELECT MIN(DATETIME)
FROM ANIMAL_INS
```

#### 3. 동물 수 구하기
```SQL
SELECT count(*)
FROM ANIMAL_INS
```

#### 4. 중복 제거하기
```SQL
SELECT count(distinct NAME)
FROM ANIMAL_INS
WHERE NAME is NOT NULL
```
