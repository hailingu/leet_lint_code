select min(dist) as shortest from (
    select abs(a.x - b.x) as dist from point a, point b where a.x <> b.x
) p