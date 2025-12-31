-- 코드를 입력하세요
SELECT CAR_ID,
    a.CAR_TYPE,
    round(DAILY_FEE * 30 * ((100 - DISCOUNT_RATE) / 100), 0) as FEE
from CAR_RENTAL_COMPANY_CAR a
    join CAR_RENTAL_COMPANY_DISCOUNT_PLAN b
    on a.CAR_TYPE = b.CAR_TYPE
where (a.CAR_TYPE like "세단" or a.CAR_TYPE like "SUV")
    and DURATION_TYPE like "30일 이상"
    and CAR_ID not in(
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= "2022-11-30" and END_DATE >= "2022-11-01"
    )
    and round(DAILY_FEE * 30 * ((100 - DISCOUNT_RATE) / 100), 0) >= 500000
    and round(DAILY_FEE * 30 * ((100 - DISCOUNT_RATE) / 100), 0) < 2000000
order by FEE desc, a.CAR_TYPE, CAR_ID desc
    