-- postgresql
SELECT
    p.firstName firstname,
    p.lastName lastname,
    a.city,
    a.state
FROM person p 
    LEFT JOIN address a ON a.personId = p.personId
;
