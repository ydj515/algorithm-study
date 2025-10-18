-- mysql
select info.item_id, info.item_name
from item_info info
inner join item_tree tree on info.item_id = tree.item_id
where tree.parent_item_id is null