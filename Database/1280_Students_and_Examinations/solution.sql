/* Write your PL/SQL query statement below */
SELECT
  student_id,
  student_name,
  subject_name,
  SUM(cnt) attended_exams
FROM (
  SELECT
    s.student_id,
    s.student_name,
    s.subject_name,
    CASE WHEN e.subject_name IS NULL THEN 0 ELSE 1 END cnt
  FROM (
    SELECT std.*, sbj.*
    FROM subjects sbj, students std
    ORDER BY std.student_id, std.student_name, sbj.subject_name
  ) s LEFT JOIN examinations e
    ON (s.student_id = e.student_id AND s.subject_name = e.subject_name)
) a 
GROUP BY student_id, student_name, subject_name
ORDER BY student_id, subject_name
