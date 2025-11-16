-- mysql
select b.book_id, a.author_name, DATE_FORMAT(b.published_date,'%Y-%m-%d') AS 'published_date'
from book b inner join author a on a.author_id = b.author_id
where b.category = '경제'
order by published_date