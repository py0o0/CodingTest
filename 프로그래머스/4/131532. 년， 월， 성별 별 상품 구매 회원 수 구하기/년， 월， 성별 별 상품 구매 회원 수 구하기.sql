-- 코드를 입력하세요
select year(SALES_DATE) as YEAR,
    month(SALES_DATE) as MONTH,
    GENDER,
    count(distinct a.USER_ID) as USERS
from USER_INFO a
    join ONLINE_SALE b
    on a.USER_ID = b.USER_ID
    and a.GENDER is not null
group by 1, 2, 3
order by 1, 2, 3