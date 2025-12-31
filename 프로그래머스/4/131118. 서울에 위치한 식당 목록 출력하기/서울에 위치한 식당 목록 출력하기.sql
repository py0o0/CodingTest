-- 코드를 입력하세요
select a.REST_ID,
    REST_NAME,
    FOOD_TYPE,
    FAVORITES,
    ADDRESS,
    round(avg(REVIEW_SCORE), 2) as SCORE
from REST_INFO a
    inner join REST_REVIEW b
    on a.REST_ID = b.REST_ID
where ADDRESS like "서울%"
group by a.REST_ID
order by SCORE desc, FAVORITES desc