-- 코드를 입력하세요
select distinct CART_ID
from CART_PRODUCTS
where CART_ID in (
    select CART_ID
    from CART_PRODUCTS
    where NAME = "Yogurt" 
        and CART_ID in (
            select CART_ID
            from CART_PRODUCTS
            where NAME = "Milk"
        )
)
order by CART_ID