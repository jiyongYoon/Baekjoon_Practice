SELECT m.member_name, r.review_text, DATE_FORMAT(r.review_date, '%Y-%m-%d') as REVIEW_DATE
from rest_review r
join member_profile m on m.member_id = r.member_id
where r.member_id = (select * from 
    (select r.member_id from rest_review r group by r.member_id order by count(r.member_id) desc limit 1) as tmp 
)
order by r.review_date, r.review_text