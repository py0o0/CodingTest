select A.FLAVOR
from FIRST_HALF A
    join ICECREAM_INFO  B
    on A.FLAVOR like B.FLAVOR
where TOTAL_ORDER >= 3000
    and INGREDIENT_TYPE like "fruit_based"
order by TOTAL_ORDER desc