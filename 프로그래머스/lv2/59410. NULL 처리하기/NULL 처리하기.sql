-- 코드를 입력하세요
SELECT ANIMAL_TYPE, ifnull(name, 'No name'), sex_upon_intake
from animal_ins
order by animal_id