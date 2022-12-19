-- 코드를 입력하세요
SELECT ANIMAL_ID, name
from ANIMAL_INS 
where intake_condition not in ('Aged')
order by animal_id
