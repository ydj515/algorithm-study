-- mysql
-- coalesce
-- 문법 : COALESCE(값1, 값2, 값3, ...)
-- 왼쪽부터 차례로 검사해서, NULL이 아닌 첫 번째 값을 반환
select round(avg(coalesce(length, 10)), 2) as average_length     
from fish_info