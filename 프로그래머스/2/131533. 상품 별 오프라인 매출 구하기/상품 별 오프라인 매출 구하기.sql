SELECT PRODUCT_CODE , sum(SALES_AMOUNT) * price as SALES
from PRODUCT as a right join OFFLINE_SALE as b on a.PRODUCT_ID = b.PRODUCT_ID
group by 1
order by 2 desc, 1

#PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 