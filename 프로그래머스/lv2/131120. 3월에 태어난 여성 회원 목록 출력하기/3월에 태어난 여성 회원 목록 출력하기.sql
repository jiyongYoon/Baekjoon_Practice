-- 코드를 입력하세요
SELECT member_id, member_name, gender, DATE_FORMAT(date_of_Birth, '%Y-%m-%d')
from member_profile
where  month(date_of_birth) = '3' 
    and gender in ('W')
    and tlno is not null
order by member_id