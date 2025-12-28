select b.SCORE + c.SCORE as SCORE,
    a.EMP_NO,
    EMP_NAME,
    POSITION,
    EMAIL
from HR_EMPLOYEES a
    join (
        select EMP_NO, SCORE
        from HR_GRADE
        where YEAR = 2022
            and HALF_YEAR = 1
    ) b
    on a.EMP_NO = b.EMP_NO
    join (
        select EMP_NO, SCORE
        from HR_GRADE
        where YEAR = 2022
            and HALF_YEAR = 2
    ) c
    on a.EMP_NO = c.EMP_NO
order by SCORE desc
limit 1