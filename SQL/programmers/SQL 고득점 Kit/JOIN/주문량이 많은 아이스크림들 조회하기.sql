-- mysql
select flavor
from (
    select flavor, total_order from first_half
    union all
    select flavor, total_order from july
) as total_orders
group by flavor
order by sum(total_order) desc
limit 3