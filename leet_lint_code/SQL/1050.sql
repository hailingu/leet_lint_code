/* Copyright © 2018 Hailin Gu. All rights reserved.
   License(GPL)
   Author: Hailin Gu
   This is a answer of leet code problem 1050.
   Date: 2019.7.4
*/
SELECT actor_id, director_id FROM ActorDirector GROUP BY actor_id, director_id HAVING COUNT(actor_id) > 2;