-- OracleSQL
SELECT DISTINCT a.id, TO_CHAR(a.visit_date, 'YYYY-MM-DD') visit_date, a.people
FROM stadium a, stadium b, stadium c
WHERE (
  (a.people > 99 AND b.people > 99 AND c.people > 99) AND
  (  
    (a.id + 1 = b.id AND a.id + 2 = c.id) OR
    (a.id - 1 = b.id AND a.id + 1 = c.id) OR
    (a.id - 2 = b.id AND a.id - 1 = c.id)
  )
)
ORDER BY a.id
;
