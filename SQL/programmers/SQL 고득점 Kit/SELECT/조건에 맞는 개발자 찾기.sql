--mysql
SELECT
    DISTINCT(d.id), d.email, d.first_name, d.last_name
FROM
    developers d, skillcodes s
WHERE
    (d.skill_code & (SELECT code FROM skillcodes WHERE name = 'Python'))
    OR (d.skill_code & (SELECT code FROM skillcodes WHERE name = 'C#'))
ORDER BY d.id