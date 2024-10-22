select distinct a.ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS as a join SKILLCODES as b
where (SKILL_CODE & CODE) and CATEGORY like 'Front end'
order by 1
#DEVELOPERS 테이블에서 Front End 스킬을 가진 개발자의 정보를 조회하려 합니다. 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.

#결과는 ID를 기준으로 오름차순 정렬해 주세요.