-- 코드를 입력하세요
select HISTORY_ID,
    case
        when datediff(END_DATE, START_DATE) + 1 < 7
            then round(DAILY_FEE * (datediff(END_DATE, START_DATE) + 1), 0)
        when datediff(END_DATE, START_DATE) + 1 < 30
            then round(DAILY_FEE * (datediff(END_DATE, START_DATE) + 1) * (
                select ((100 - DISCOUNT_RATE) / 100)
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                where CAR_TYPE like "트럭"
                    and DURATION_TYPE like "7일 이상"
            ), 0)
        when datediff(END_DATE, START_DATE) + 1 < 90
            then round(DAILY_FEE * (datediff(END_DATE, START_DATE) + 1) * (
                select ((100 - DISCOUNT_RATE) / 100)
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                where CAR_TYPE like "트럭"
                    and DURATION_TYPE like "30일 이상"
            ), 0)
        else round(DAILY_FEE * (datediff(END_DATE, START_DATE) + 1) * (
                select ((100 - DISCOUNT_RATE) / 100)
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                where CAR_TYPE like "트럭"
                    and DURATION_TYPE like "90일 이상"
            ), 0)
    end as FEE
from CAR_RENTAL_COMPANY_CAR a
    join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
    on a.CAR_ID = b.CAR_ID
where CAR_TYPE like "트럭"
order by FEE desc, HISTORY_ID desc