/* Write your PL/SQL query statement below */
SELECT
    SUBSTR(date_id, 0, 10) date_id,
    make_name,
    SUM(unique_leads) unique_leads,
    SUM(unique_partners) unique_partners
FROM (
    SELECT
        date_id,
        make_name,
        COUNT(1) unique_leads,
        0 unique_partners
    FROM (
        SELECT DISTINCT date_id, make_name, lead_id FROM dailysales
    ) a
    GROUP BY date_id, make_name
    UNION
    SELECT
        date_id,
        make_name,
        0 unique_leads,
        COUNT(1) unique_partners
    FROM (
        SELECT DISTINCT date_id, make_name, partner_id FROM dailysales
    ) a
    GROUP BY date_id, make_name
) a
GROUP BY date_id, make_name, 
;
