-- Write your PostgreSQL query statement below
SELECT 
    p.project_id,
    ROUND((AVG(e.experience_years)::decimal), 2) AS average_years
FROM project p
JOIN employee e
ON p.employee_id = e.employee_id
GROUP BY p.project_id;