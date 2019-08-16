-- OracleSQL
SELECT
    b.Name Department,
    a.Name Employee,
    a.Salary
FROM Employee a
JOIN (
    SELECT d.*, (
        SELECT DISTINCT(MAX(e.Salary) OVER (PARTITION BY d.Name ORDER BY e.Salary DESC)) Salary
        FROM Employee e
        WHERE d.Id = e.DepartmentId
    ) Salary
    FROM Department d
) b
ON (
    a.DepartmentId = b.Id AND
    a.Salary = b.Salary
)
ORDER BY a.Salary DESC
;
