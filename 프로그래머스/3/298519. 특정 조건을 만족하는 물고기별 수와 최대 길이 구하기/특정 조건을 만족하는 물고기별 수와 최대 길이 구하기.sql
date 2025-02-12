SELECT INN.FISH_COUNT, INN.MAX_LENGTH, INN.FISH_TYPE
FROM (
    SELECT COUNT(ID) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, (SUM(LENGTH) / COUNT(ID)) AS AVERAGE, FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
) INN
WHERE INN.AVERAGE >= 33
ORDER BY FISH_TYPE