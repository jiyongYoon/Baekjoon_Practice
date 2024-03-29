SELECT R.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO I
JOIN REST_REVIEW R ON R.REST_ID = I.REST_ID
WHERE I.ADDRESS LIKE '서울%'
GROUP BY R.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.ADDRESS, I.FAVORITES
ORDER BY SCORE DESC, FAVORITES DESC