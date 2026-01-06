-- 코드를 작성해주세요
select year(DIFFERENTIATION_DATE) as YEAR,
    MAX_SIZE - SIZE_OF_COLONY as YEAR_DEV,
    ID
from ECOLI_DATA a
    join (
        select max(SIZE_OF_COLONY) as MAX_SIZE,
            year(DIFFERENTIATION_DATE) as YEAR
        from ECOLI_DATA
        group by YEAR
    ) b
    on year(DIFFERENTIATION_DATE) = b.YEAR
order by 1, 2