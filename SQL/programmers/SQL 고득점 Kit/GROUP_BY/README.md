# SQL
## GROUP BY
### <a href="https://programmers.co.kr/learn/courses/30/parts/17044">문제</a>

#### 1. 고양이와 개는 몇 마리 있을까
```SQL
SELECT ANIMAL_TYPE, count(*)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
```

#### 2. 동명 동물 수 찾기
```SQL
SELECT NAME, count(*)
FROM ANIMAL_INS
WHERE NAME is NOT NULL
GROUP BY NAME
HAVING COUNT(*)>=2
ORDER BY NAME
```

#### 3. 입양 시각 구하기(1)
```SQL
SELECT EXTRACT(HOUR FROM DATETIME) AS 'hour', count(DATETIME)
FROM ANIMAL_OUTS
GROUP BY hour
HAVING hour >= 9 and hour <=19
ORDER BY hour
```

#### 4. 입양 시각 구하기(2)
```SQL

```
