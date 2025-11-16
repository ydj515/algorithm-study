-- mysql
select a.product_code as product_code, sum(a.price * b.sales_amount) as sales
from product a
inner join offline_sale b on a.product_id = b.product_id
group by product_code
order by sales desc, product_code