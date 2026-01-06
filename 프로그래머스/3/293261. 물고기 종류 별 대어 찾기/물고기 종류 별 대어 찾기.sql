-- 코드를 작성해주세요
select ID,
    FISH_NAME,
    LENGTH
from FISH_INFO a
    join FISH_NAME_INFO b
    on a.FISH_TYPE = b.FISH_TYPE
where (LENGTH, a.FISH_TYPE) in (
    select max(LENGTH) as LENGTH, FISH_TYPE
    from FISH_INFO
    group by FISH_TYPE
)
order by 1