-- 코드를 입력하세요
select round((PRICE div 10000) * 10000, 0) as PRICE_GROUP,
    count(*) as PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP