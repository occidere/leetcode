/* Write your PL/SQL query statement below */
SELECT
    user_id,
    COUNT(follower_id) followers_count
FROM followers
GROUP BY user_id
ORDER BY user_id
;
