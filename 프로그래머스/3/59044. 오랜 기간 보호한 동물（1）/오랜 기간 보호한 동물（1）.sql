select NAME, DATETIME
from ANIMAL_INS
where  ANIMAL_ID not in (select ANIMAL_ID
                        from ANIMAL_OUTS
                        )
order by 2 limit 3

#아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회하는 SQL문을 작성해주세요. 이때 결과는 보호 시작일 순으로 조회해야 합니다.

