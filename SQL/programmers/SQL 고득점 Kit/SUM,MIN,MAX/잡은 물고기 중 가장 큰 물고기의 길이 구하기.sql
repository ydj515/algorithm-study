-- mysql
select concat(max(length),'cm') as max_length
from fish_info
order by length desc