-- 코드를 입력하세요
SELECT count(user_id) as USERS
from USER_INFO 
where age >= 20 
    and age < 30 
    and age is not null
    and year(joined) = 2021