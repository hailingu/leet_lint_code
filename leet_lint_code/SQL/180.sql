/* Copyright © 2018 Hailin Gu. All rights reserved.
   License(GPL)
   Author: Hailin Gu
   This is a answer of leet code problem 180.
   Date: 2019.7.15
*/

SELECT DISTINCT l1.Num AS ConsecutiveNums FROM 
((
    Logs l1 LEFT JOIN Logs l2
    ON l1.Id = l2.Id - 1
)
LEFT JOIN Logs l3 
    ON
        l1.Id = l3.Id - 2)
WHERE l1.Num = l2.Num AND l2.Num = l3.Num;
