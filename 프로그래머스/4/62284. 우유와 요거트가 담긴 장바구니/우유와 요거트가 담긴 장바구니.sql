select cart_id
from (select cart_id, name
     from cart_products
     where name in ('Yogurt', 'Milk')
     group by cart_id,name)
     a
group by cart_id
having count(cart_id)>=2
order by cart_id;