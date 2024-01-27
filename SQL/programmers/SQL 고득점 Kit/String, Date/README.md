# SQL
## String & Date
### <a href="https://programmers.co.kr/learn/courses/30/parts/17047">문제</a>

#### 1. 루시와 엘라 찾기
```SQL
SELECT DISTINCT ANIMAL_ID,NAME,SEX_UPON_INTAKE 
FROM ANIMAL_INS 
WHERE NAME='Lucy' or NAME='Ella' or NAME='Pickle' or NAME='Rogan' or NAME='Sabrina' or NAME='Mitty'
ORDER BY ANIMAL_ID;
```

#### 2. 이름에 el이 들어가는 동물 찾기
```SQL
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE="Dog" and UPPER(NAME) like UPPER("%el%")
ORDER BY NAME ASC
```

#### 3. 중성화 여부 파악하기
```SQL
-- 형식 : if ( 조건문, 참일때 값, 거짓일때 값)
SELECT ANIMAL_ID, NAME, IF(SEX_UPON_INTAKE like '%Neutered%' OR SEX_UPON_INTAKE like '%Spayed%', 'O', 'X') AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```

#### 4. 오랜 기간 보호한 동물(2)
```SQL
SELECT A.ANIMAL_ID, B.NAME
FROM ANIMAL_INS A
JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
ORDER BY A.DATETIME - B.DATETIME
LIMIT 2
```

#### 5. DATETIME에서 DATE로 형 변환
```SQL
-- %Y-%m-%d의 대소문자 유의. 결과가 다르게 나옴
SELECT ANIMAL_ID, NAME, DATE_FORMAT(DATETIME, '%Y-%m-%d')
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
```
