-- Write your PostgreSQL query statement below
SELECT teacher_id, count(distinct subject_id) as cnt FROM TEACHER
GROUP BY 1
order by 1;