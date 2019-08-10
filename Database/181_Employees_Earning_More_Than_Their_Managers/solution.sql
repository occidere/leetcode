SELECT a.Name Employee
FROM Employee a
    JOIN Employee b 
    ON a.ManagerId = b.Id
WHERE a.Salary > b.Salary
;
