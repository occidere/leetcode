CREATE FUNCTION getNthHighestSalary(N IN NUMBER)
    RETURN NUMBER
IS
    result NUMBER;
BEGIN
    SELECT (
        SELECT salary
        FROM (
            SELECT salary, ROWNUM rnum
            FROM (
                SELECT salary
                FROM Employee
                GROUP BY salary
                ORDER BY salary DESC
            )
        )
        WHERE rnum = N
    ) INTO result
    FROM dual;
    RETURN result;
END;
