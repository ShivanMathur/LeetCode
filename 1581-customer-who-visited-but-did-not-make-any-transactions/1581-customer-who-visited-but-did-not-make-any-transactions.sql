/* Write your PL/SQL query statement below */

/* Approach 1: Removing records using NOT IN/EXISTS*/
SELECT v.customer_id, COUNT(*) AS count_no_trans
FROM visits v
WHERE v.visit_id NOT IN (SELECT t.visit_id FROM transactions t)
GROUP BY v.customer_id; 

/* Approach 2: Removing records using LEFT JOIN and IS NULL
SELECT v.customer_id, count(*) as count_no_trans
from visits v
left outer join transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by v.customer_id;
*/