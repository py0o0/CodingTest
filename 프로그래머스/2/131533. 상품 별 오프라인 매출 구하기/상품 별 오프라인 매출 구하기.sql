-- 코드를 입력하세요
select PRODUCT_CODE,
    sum(SALES_AMOUNT) * PRICE as SALES
from PRODUCT a
    join OFFLINE_SALE b
    on a.PRODUCT_ID = b.PRODUCT_ID
group by PRODUCT_CODE
order by SALES desc, PRODUCT_CODE