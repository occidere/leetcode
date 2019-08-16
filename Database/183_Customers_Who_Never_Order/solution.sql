-- OracleSQL
SELECT Name Customers
FROM Customers c
    LEFT JOIN Orders o 
    ON c.Id = o.CustomerId
WHERE o.CustomerId IS NULL
ORDER BY c.Id
;
