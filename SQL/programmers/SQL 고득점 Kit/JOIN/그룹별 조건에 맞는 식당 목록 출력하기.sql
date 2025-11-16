-- mysql
select p.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d') as review_date
from rest_review r
inner join member_profile p on r.member_id = p.member_id
where r.member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(review_score) desc
    limit 1
)
order by review_date , review_text