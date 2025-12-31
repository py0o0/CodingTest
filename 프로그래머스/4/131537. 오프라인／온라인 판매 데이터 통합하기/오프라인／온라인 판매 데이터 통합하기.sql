-- 코드를 입력하세요
select date_format(SALES_DATE, "%Y-%m-%d"),
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
from (
    select USER_ID,
        PRODUCT_ID,
        SALES_AMOUNT,
        SALES_DATE
    from ONLINE_SALE
    where SALES_DATE between "2022-03-01" and "2022-03-31"
    
    union
    
    select null as USER_ID,
        PRODUCT_ID,
        SALES_AMOUNT,
        SALES_DATE
    from OFFLINE_SALE
    where SALES_DATE between "2022-03-01" and "2022-03-31"
) a
order by SALES_DATE, PRODUCT_ID, USER_ID