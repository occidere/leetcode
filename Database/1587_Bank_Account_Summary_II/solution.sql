/* Write your PL/SQL query statement below */
SELECT name, balance
FROM users a
    JOIN (
        SELECT account, SUM(amount) balance
        FROM transactions
        GROUP BY account
    ) b
    ON a.account = b.account
WHERE b.balance > 10000
;
