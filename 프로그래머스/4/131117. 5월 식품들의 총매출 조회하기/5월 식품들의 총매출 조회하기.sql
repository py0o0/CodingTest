-- 코드를 입력하세요
select a.PRODUCT_ID,
    PRODUCT_NAME,
    sum(AMOUNT) * PRICE as TOTAL_SALES
from FOOD_PRODUCT a
    join FOOD_ORDER b
    on a.PRODUCT_ID = b.PRODUCT_ID
where year(PRODUCE_DATE) = 2022
    and month(PRODUCE_DATE) = 5
group by a.PRODUCT_ID
order by TOTAL_SALES desc, a.PRODUCT_ID