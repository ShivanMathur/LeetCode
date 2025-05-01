-- Write your PostgreSQL query statement below

-- APPROACH 1: Using NOT IN
-- SELECT customer_id, COUNT(visit_id) AS count_no_trans
-- FROM visits 
-- WHERE visit_id NOT IN (SELECT visit_id FROM transactions)
-- GROUP BY 1;

-- APPROACH 2: Using LEFT JOIN
SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM visits v
LEFT JOIN transactions t 
ON v.visit_id = t.visit_id
WHERE t.visit_id IS NULL
GROUP BY 1;