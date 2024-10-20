select year(SALES_DATE) as YEAR,month(SALES_DATE) as MONTH,GENDER,count(DISTINCT a.USER_ID) as USERS
from USER_INFO a right join
ONLINE_SALE b on b.USER_ID = a.USER_ID
where GENDER is not NULL
group by 1,2,3
order by 1,2,3
        
#USER_INFO 테이블과 ONLINE_SALE 테이블에서 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요. 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.

