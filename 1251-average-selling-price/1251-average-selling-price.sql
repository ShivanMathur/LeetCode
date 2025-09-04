/* Write your PL/SQL query statement below */
SELECT p.product_id, NVL(ROUND((SUM(us.units*p.price)/ SUM(us.units)), 2), 0) as average_price
from prices p
left join unitssold us on p.product_id = us.product_id
AND us.purchase_date BETWEEN p.start_date AND p.end_date
group by p.product_id;