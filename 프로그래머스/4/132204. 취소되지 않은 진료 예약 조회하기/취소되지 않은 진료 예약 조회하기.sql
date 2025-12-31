-- 코드를 입력하세요
select APNT_NO,
    PT_NAME,
    a.PT_NO,
    a.MCDP_CD,
    DR_NAME,
    APNT_YMD
from APPOINTMENT a
    join PATIENT b
    on a.PT_NO = b.PT_NO
    join DOCTOR c
    on a.MDDR_ID = c.DR_ID
where APNT_YMD like "2022-04-13%"
    and a.MCDP_CD = "CS"
    and APNT_CNCL_YN = "N"
order by APNT_YMD