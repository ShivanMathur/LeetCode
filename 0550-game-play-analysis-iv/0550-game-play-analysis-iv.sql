-- Write your PostgreSQL query statement below

SELECT
    ROUND( COUNT(player_id) / (SELECT COUNT(DISTINCT player_id) FROM activity)::numeric, 2) AS fraction
FROM activity
WHERE (player_id, event_date) IN (
    SELECT player_id, MIN(event_date) + 1
    FROM activity
    GROUP BY player_id
);
