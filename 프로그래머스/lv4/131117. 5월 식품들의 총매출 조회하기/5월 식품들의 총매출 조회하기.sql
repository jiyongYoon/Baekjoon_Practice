-- 코드를 입력하세요
SELECT o.product_id, p.product_name, sum(p.price * o.amount) as total_sales
from food_order o
join food_product p
where o.product_id = p.product_id
    and year(produce_date) = 2022 and month(produce_date) = 05
group by p.product_name
order by sum(p.price * o.amount) desc, o.product_id
