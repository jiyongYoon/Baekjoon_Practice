SELECT COUNT(*) AS FISH_COUNT, MONTH(FI.TIME) AS MONTH
FROM FISH_INFO FI
GROUP BY MONTH
ORDER BY MONTH