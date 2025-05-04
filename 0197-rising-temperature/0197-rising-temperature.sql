-- Write your PostgreSQL query statement below
-- APPROACH 1: Using CTE and LAG Function

WITH previous_weather_data AS
(
    SELECT 
        id,
        recordDate,
        temperature,
        LAG(temperature) OVER (ORDER BY recordDate) AS previous_temperature,
        LAG(recordDate) OVER (ORDER BY recordDate) AS previous_recordDate
    FROM weather
)

SELECT id
FROM previous_weather_data
WHERE
temperature > previous_temperature
AND recordDate = previous_recordDate + interval '1 day';