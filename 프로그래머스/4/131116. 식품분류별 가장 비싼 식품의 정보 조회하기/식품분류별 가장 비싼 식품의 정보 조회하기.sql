# -- 코드를 입력하세요
# select ff.category, ff.MAX_PRICE, ff.product_name from (
#     SELECT f.category, max(f.price) as MAX_PRICE, f.product_name, f.product_id
#     from food_product f
#     group by f.category having f.category in ('식용유', '국', '과자', '김치')
#                                                        ) as ff
# join food_product f on f.product_id = ff.product_id
# group by f.category
# order by MAX_PRICE desc

SELECT CATEGORY, PRICE, PRODUCT_NAME
FROM FOOD_PRODUCT
WHERE CATEGORY IN ('과자', '국', '김치', '식용유') AND PRICE IN (
SELECT MAX(PRICE)
FROM FOOD_PRODUCT
GROUP BY CATEGORY
)
GROUP BY CATEGORY
ORDER BY MAX(PRICE) DESC;