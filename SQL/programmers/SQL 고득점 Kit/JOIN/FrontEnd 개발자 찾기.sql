-- mysql
-- on절에 &가 핵심
select distinct d.id, d.email, d.first_name, d.last_name
from developers d inner join skillcodes s on (s.code & d.skill_code)>0
where s.category = 'Front End'
order by d.id