/* Write your PL/SQL query statement below */
SELECT
    category "Category",
    SUM(mon) "Monday",
    SUM(tue) "Tuesday",
    SUM(wed) "Wednesday",
    SUM(thu) "Thursday",
    SUM(fri) "Friday",
    SUM(sat) "Saturday",
    SUM(sun) "Sunday"
FROM (
    SELECT
        category,
        CASE day WHEN 'Monday'      THEN quantity ELSE 0 END mon,
        CASE day WHEN 'Tuesday'     THEN quantity ELSE 0 END tue,
        CASE day WHEN 'Wednesday'   THEN quantity ELSE 0 END wed,
        CASE day WHEN 'Thursday'    THEN quantity ELSE 0 END thu,
        CASE day WHEN 'Friday'      THEN quantity ELSE 0 END fri,
        CASE day WHEN 'Saturday'    THEN quantity ELSE 0 END sat,
        CASE day WHEN 'Sunday'      THEN quantity ELSE 0 END sun
    FROM (
        SELECT
            a.item_category category,
            a.day,
            SUM(a.quantity) quantity
        FROM (
            SELECT
                a.item_category,
                TRIM(TO_CHAR(b.order_date, 'Day')) day,
                b.quantity
            FROM items a
                LEFT JOIN orders b ON a.item_id = b.item_id
        ) a
        GROUP BY a.item_category, a.day
    ) a
)
GROUP BY category
ORDER BY category
;
