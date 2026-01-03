-- 코드를 입력하세요
select date_format(SALES_DATE, "%Y-%m-%d") as SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
from (
    select USER_ID,
        PRODUCT_ID,
        SALES_AMOUNT,
        SALES_DATE
    from ONLINE_SALE
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 3
    
    union
    
    select null as USER_ID,
        PRODUCT_ID,
        SALES_AMOUNT,
        SALES_DATE
    from OFFLINE_SALE
    where year(SALES_DATE) = 2022 and month(SALES_DATE) = 3
) a
order by SALES_DATE, PRODUCT_ID, USER_ID