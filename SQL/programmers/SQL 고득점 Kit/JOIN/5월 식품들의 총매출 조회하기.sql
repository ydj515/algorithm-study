-- mysql
select o.product_id, fp.product_name, (sum(o.amount) * fp.price) as total_sales
from food_product fp
inner join food_order o on fp.product_id = o.product_id
where o.produce_date >= '2022-05-01' and o.produce_date <= '2022-05-31'
group by o.product_id
order by total_sales desc, o.product_id;