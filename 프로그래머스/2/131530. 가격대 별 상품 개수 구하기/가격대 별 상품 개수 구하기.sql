-- 코드를 입력하세요
select (PRICE div 10000) * 10000 as PRICE_GROUP,
    count(*) as PRODUCTS
from PRODUCT
group by 1
order by 1