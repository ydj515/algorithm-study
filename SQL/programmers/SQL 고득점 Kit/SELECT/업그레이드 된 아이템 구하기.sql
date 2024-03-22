-- mysql
SELECT child.item_id, child.item_name, child.rarity
FROM item_info AS parent
JOIN item_tree AS it ON it.parent_item_id = parent.item_id
JOIN item_info AS child ON it.item_id = child.item_id
WHERE parent.rarity = 'RARE'
ORDER BY child.item_id DESC