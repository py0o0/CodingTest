SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS as a join
ANIMAL_OUTS as b on a.ANIMAL_ID = b.ANIMAL_ID
where b.DATETIME < a.DATETIME
order by a.DATETIME

#관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.
