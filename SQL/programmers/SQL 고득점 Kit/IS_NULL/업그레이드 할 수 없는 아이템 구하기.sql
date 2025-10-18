-- mysql
-- 자식이 없는 것들 item_id를 찾아야함.
select info.item_id, info.item_name, info.rarity
from item_info info
inner join item_tree tree on info.item_id = tree.item_id
where info.item_id not in (
    select distinct a.item_id
    from item_tree a join item_tree b on  a.item_id = b.parent_item_id
)
order by info.item_id desc