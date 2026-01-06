-- 코드를 작성해주세요
select ID,
    EMAIL,
    FIRST_NAME,
    LAST_NAME
from DEVELOPERS
where SKILL_CODE & (
    select sum(code)
    from SKILLCODES
    where CATEGORY like "Front%"
) > 0
order by 1