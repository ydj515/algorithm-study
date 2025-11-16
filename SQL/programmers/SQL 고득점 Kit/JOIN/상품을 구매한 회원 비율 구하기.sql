-- mysql
select
    date_format(o.sales_date, '%Y') as year,
    date_format(o.sales_date, '%m') as month,
    count(distinct u.user_id) as puchased_users,
    round(count(distinct u.user_id)/(select count(*) from user_info where joined like '2021%'), 1) as puchased_ratio
from online_sale o
inner join user_info u on u.user_id = o.user_id
where joined between '2021-01-01' and '2021-12-31'
group by year, month
order by year, month