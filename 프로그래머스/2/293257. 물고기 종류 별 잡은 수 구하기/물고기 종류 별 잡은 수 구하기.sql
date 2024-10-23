select count(*) as FISH_COUNT, FISH_NAME
from FISH_INFO as a left join
FISH_NAME_INFO as b on  a.FISH_TYPE = b.FISH_TYPE
group by 2
order by 1 desc