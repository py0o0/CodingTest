SELECT WRITER_ID, NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD join
USED_GOODS_USER on WRITER_ID = USER_ID
where STATUS like 'DONE' 
group by WRITER_ID	
having TOTAL_SALES >= 700000
order by 3

#USED_GOODS_BOARD와 USED_GOODS_USER 테이블에서 완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회하는 SQL문을 작성해주세요. 결과는 총거래금액을 기준으로 오름차순 정렬해주세요.