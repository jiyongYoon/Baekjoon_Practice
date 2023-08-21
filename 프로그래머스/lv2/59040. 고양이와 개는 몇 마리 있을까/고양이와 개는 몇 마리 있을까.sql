-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(*) as count
From animal_ins
group by Animal_type
having animal_type in ('Cat', 'Dog')
order by animal_type