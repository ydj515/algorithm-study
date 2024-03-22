-- mysql
SELECT COUNT(*) AS fish_count
FROM fish_info AS a
INNER JOIN fish_name_info AS b ON a.fish_type = b.fish_type
WHERE b.fish_name IN ('BASS', 'SNAPPER');