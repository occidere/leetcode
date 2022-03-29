/* Write your PL/SQL query statement below */
WITH root_tbl AS (
    SELECT id
    FROM tree
    WHERE p_id IS NULL
),
type_tbl AS (
    SELECT id, 'Root' node_type
    FROM root_tbl
    UNION
    SELECT b.id, 'Inner' node_type
    FROM
        root_tbl a,
        (SELECT DISTINCT p_id id FROM tree) b
    WHERE a.id != b.id
)
SELECT
    a.id id,
    CASE
        WHEN b.node_type IS NULL THEN 'Leaf'
        ELSE b.node_type
    END AS type
FROM tree a
    LEFT JOIN type_tbl b ON a.id = b.id
;
