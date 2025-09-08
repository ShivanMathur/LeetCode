-- Write your PostgreSQL query statement below
/* Intuition:
    * Find the first order for each customer:: Subquery - Use GROUP BY customer_id with MIN(order_date) to get the first order date for each customer.
    * Check if the first order was immediate (order_date = customer_pref_delivery_date)
    * Calculate the percentage of such immedidate orders
*/

/* Approach 1: CASE, SUBQUERY, GROUP BY, Aggregation
SELECT 
    ROUND(
        100.0 * SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) / COUNT(*), 2) AS immediate_percentage
FROM delivery
WHERE (customer_id, order_date) IN (
    SELECT customer_id, MIN(order_date) FROM delivery
    GROUP BY customer_id
); */

/* Approach 2: Using CTE */
WITH immediate_customer_orders AS(
    SELECT DISTINCT ON (customer_id) customer_id, order_date, customer_pref_delivery_date,
    CASE WHEN order_date = customer_pref_delivery_date THEN 'immediate' ELSE 'scheduled' END AS order_status
    FROM delivery
    ORDER BY customer_id, order_date
)
SELECT 
    ROUND(
        COUNT(CASE WHEN order_status = 'immediate' THEN 1 ELSE NULL END) * 100.0 / COUNT(order_status), 2
    ) AS immediate_percentage
FROM immediate_customer_orders;