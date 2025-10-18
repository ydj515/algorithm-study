-- mysql
select year, (m - size_of_colony) as year_dev, id
from ecoli_data as a 
join (select year(differentiation_date) as year, max(size_of_colony) as m
     from ecoli_data
     group by year(differentiation_date)) as t
on year(a.differentiation_date) = t.year
order by year, year_dev