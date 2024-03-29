SELECT H.CAR_ID, CASE 
    WHEN H.CAR_ID IN (SELECT HH.CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY HH
        WHERE '2022-10-16' BETWEEN HH.START_DATE AND HH.END_DATE)
    THEN '대여중'
    ELSE '대여 가능'
    END AS 'AVAILABILITY'
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
GROUP BY H.CAR_ID
ORDER BY H.CAR_ID DESC