-- ORACLE PL/SQL
SELECT
  a.pay_month "pay_month",
  b.department_id "department_id",
  CASE
    WHEN a.avg_amt < b.avg_amt THEN 'higher'
    WHEN a.avg_amt = b.avg_amt THEN 'same'
    ELSE 'lower'
  END "comparison"
FROM (
    SELECT TO_CHAR(pay_date, 'YYYY-MM') pay_month, AVG(amount) avg_amt
    FROM salary
    GROUP BY TO_CHAR(pay_date, 'YYYY-MM')
) a JOIN (
  SELECT pay_month, department_id, AVG(amount) avg_amt
  FROM (
    SELECT department_id, amount, TO_CHAR(pay_date, 'YYYY-MM') pay_month
    FROM employee a
      JOIN salary b
      ON a.employee_id = b.employee_id
  ) a
  GROUP BY pay_month, department_id
) b
ON a.pay_month = b.pay_month
ORDER BY a.pay_month DESC, b.department_id
;
