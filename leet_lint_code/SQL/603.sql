/* Copyright © 2018 Hailin Gu. All rights reserved.
   License(GPL)
   Author: Hailin Gu
   This is a answer of leet code problem 603.
   Date: 2019.7.15
*/

SELECT DISTINCT c1.seat_id AS seat_id 
FROM cinema c1 LEFT JOIN cinema c2
ON c1.seat_id - 1 = c2.seat_id OR c1.seat_id + 1 = c2.seat_id
WHERE c1.free = 1 AND c2.free = 1
ORDER BY seat_id;