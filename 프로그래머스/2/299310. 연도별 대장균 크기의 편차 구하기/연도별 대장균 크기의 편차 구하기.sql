-- 코드를 작성해주세요
select year(a.DIFFERENTIATION_DATE) as YEAR,
    b.MAX_SIZE - a.SIZE_OF_COLONY as YEAR_DEV,
    a.ID
from ECOLI_DATA a  
    join (
        select year(DIFFERENTIATION_DATE) as YEAR,
            max(SIZE_OF_COLONY) as MAX_SIZE
        from ECOLI_DATA
        group by YEAR
    ) b
    on year(a.DIFFERENTIATION_DATE) = b.YEAR
order by YEAR, YEAR_DEV
