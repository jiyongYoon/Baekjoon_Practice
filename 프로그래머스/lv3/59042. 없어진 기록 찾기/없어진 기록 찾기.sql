-- 코드를 입력하세요
SELECT O.animal_id, O.name
from ANIMAL_OUTS O
left join animal_ins I
    on O.animal_id = I.animal_id
where I.animal_id is null
order by o.animal_id
