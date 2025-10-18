-- mysql
select id, fish_name, fish_info.length as length
from fish_info join fish_name_info on fish_info.fish_type = fish_name_info.fish_type
where fish_info.fish_type in 
(
    select fish_type
    from fish_info
    group by fish_type
    having length = max(length)
)
order by id