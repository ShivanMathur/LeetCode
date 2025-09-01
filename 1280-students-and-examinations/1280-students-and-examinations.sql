-- Write your PostgreSQL query statement below

-- SELECT st.student_id, st.student_name, sub.subject_name, 
-- (SELECT COUNT(*) from students st1 join examinations ex1 on st1.student_id = ex1.student_id) AS attended_exams
-- FROM students st, subjects sub, examinations ex

-- group by st.student_id, st.student_name, sub.subject_name
-- order by 1, 3;

SELECT st.student_id, st.student_name, sub.subject_name, COUNT(ex.student_id) AS attended_exams
FROM students st
CROSS JOIN subjects sub
LEFT JOIN examinations AS ex ON st.student_id = ex.student_id AND sub.subject_name = ex.subject_name
group by st.student_id, st.student_name, sub.subject_name
order by 1, 3;