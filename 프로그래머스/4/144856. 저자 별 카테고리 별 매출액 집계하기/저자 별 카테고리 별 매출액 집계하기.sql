-- 코드를 입력하세요
select b.AUTHOR_ID,
    AUTHOR_NAME,
    CATEGORY,
    sum(SALES * PRICE) as TOTAL_SALES
from BOOK a
    join AUTHOR b
    on a.AUTHOR_ID = b.AUTHOR_ID
    join BOOK_SALES c
    on a.BOOK_ID = c.BOOK_ID
where year(SALES_DATE) = 2022
    and month(SALES_DATE) = 1
group by b.AUTHOR_ID, CATEGORY
order by b.AUTHOR_ID, CATEGORY desc