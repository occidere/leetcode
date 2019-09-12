-- OracleSQL
/* Write your PL/SQL query statement below */
SELECT *
FROM Department
PIVOT (
  SUM(revenue)
  FOR month IN (
    'Jan' "Jan_Revenue",
    'Feb' "Feb_Revenue",
    'Mar' "Mar_Revenue",
    'Apr' "Apr_Revenue",
    'May' "May_Revenue",
    'Jun' "Jun_Revenue",
    'Jul' "Jul_Revenue",
    'Aug' "Aug_Revenue",
    'Sep' "Sep_Revenue",
    'Oct' "Oct_Revenue",
    'Nov' "Nov_Revenue",
    'Dec' "Dec_Revenue"
  )
)
;
