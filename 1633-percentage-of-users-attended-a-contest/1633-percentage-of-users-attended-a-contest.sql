/* Write your PL/SQL query statement below */
/* APPROACH 1
SELECT r.contest_id, ROUND((COUNT(r.contest_id)/(SELECT COUNT(*) FROM USERS))*100, 2) as percentage
from users u
right join register r 
on r.user_id = u.user_id
group by r.contest_id
ORDER BY 2 DESC, 1 ASC; */

/* APPROACH 2: LEETCODE Solution */
SELECT contest_id, ROUND(COUNT(DISTINCT user_id) * 100 / (SELECT COUNT(user_id) FROM Users), 2) AS percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage DESC, contest_id;