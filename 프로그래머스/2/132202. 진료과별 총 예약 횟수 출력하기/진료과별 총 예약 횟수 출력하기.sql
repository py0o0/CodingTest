-- 코드를 입력하세요
select MCDP_CD as 진료과코드,
    count(*) as 5월예약건수
from APPOINTMENT
where month(APNT_YMD) = 5
group by 진료과코드
order by 5월예약건수, 진료과코드