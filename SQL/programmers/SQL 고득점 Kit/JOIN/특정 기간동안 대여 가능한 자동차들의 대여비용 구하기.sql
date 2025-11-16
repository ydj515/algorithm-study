-- mysql
-- with 절을 사용하여 3개의 가상 테이블(cte)을 정의합니다.
-- cte(common table expression)는 복잡한 쿼리를 더 읽기 쉽게 만들어주는 역할을 합니다.

-- 1. 30일 이상 대여 시의 할인 정책만 필터링하여 'discount_plan' cte 생성
with discount_plan as (
    select *
    from car_rental_company_discount_plan
    where duration_type = '30일 이상'
),

-- 2. 대여 가능한 리스트 조회
rented_nov as (
    select distinct car_id -- 중복을 제거하여 차량 id 목록만 가져옴
    from car_rental_company_rental_history
    -- 대여 기간이 11월 1일 ~ 11월 30일과 하루라도 겹치는 모든 경우를 포함
    -- (예: 10/25~11/05, 11/10~11/20, 11/25~12/05, 10/20~12/10 등)
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
),

-- 3. '세단'과 'suv' 차종에 대해 30일 대여 요금을 미리 계산하여 'fee_calc' cte 생성
fee_calc as (
    select
        c.car_id,
        c.car_type,
        -- 최종 요금 계산: floor( (일일 요금 * (1 - 할인율/100)) * 30일 )
        -- floor 함수는 소수점 이하를 버림 처리
        floor((c.daily_fee * (1 - d.discount_rate / 100.0)) * 30) as fee
    from
        car_rental_company_car c
    -- 차량 테이블(c)과 30일 할인 정책 테이블(d)을 차종(car_type) 기준으로 join
    join
        discount_plan d on c.car_type = d.car_type
    where
        c.car_type in ('세단', 'SUV') -- 차종이 '세단' 또는 'suv'인 차량만 필터링
)

-- 최종적으로 위에서 정의한 cte들을 조합하여 결과를 도출
select
    f.car_id,
    f.car_type,
    f.fee
from
    fee_calc f -- 3번에서 계산한 요금 정보(f)를 기준으로 조회
where
    -- 11월에 대여된 기록이 없는 차량만 남김 (즉, 11월 내내 대여 가능한 차량)
    not exists (
        select 1
        from rented_nov r -- 2번에서 만든 11월 대여 차량 목록(r)
        where r.car_id = f.car_id -- 요금 계산된 차량 id가 11월 대여 목록에 없는지 확인
    )
    -- 계산된 요금(fee)이 50만원 이상 200만원 미만인 경우만 필터링
    and f.fee >= 500000 and f.fee < 2000000
order by
    f.fee desc,          -- 1. 요금을 기준으로 내림차순
    f.car_type asc,      -- 2. 차종을 기준으로 오름차순
    f.car_id desc;       -- 3. 자동차 id를 기준으로 내림차순