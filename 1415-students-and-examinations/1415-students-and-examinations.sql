# Write your MySQL query statement below
SELECT  s.student_id, s.student_name, sb.subject_name, Count(e.subject_name) as attended_exams
From Students s Join Subjects sb LEFT JOIN Examinations e
on s.student_id = e.student_id AND sb.subject_name = e.subject_name
Group by s.student_id, sb.subject_name
Order By s.student_id, sb.subject_name;