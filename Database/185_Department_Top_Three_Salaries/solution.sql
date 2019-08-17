-- OracleSQL
SELECT
    Department,
    Employee,
    Salary
FROM (
    SELECT
        d.Name Department,
        e.Name Employee,
        e.Salary Salary,
        DENSE_RANK() OVER (PARTITION BY d.Id ORDER BY e.Salary DESC) row_num
    FROM Employee e
    JOIN Department d
    ON d.Id = e.DepartmentId
) a
WHERE row_num < 4
;
