SELECT ANIMAL_TYPE , COUNT(*) AS '갯수'
FROM ANIMAL_INS

GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;