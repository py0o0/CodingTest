SELECT b.ANIMAL_ID, b.ANIMAL_TYPE, b.NAME
from ANIMAL_INS as a right join
ANIMAL_OUTS as b on a.ANIMAL_ID = b.ANIMAL_ID
where a.SEX_UPON_INTAKE like 'Intact%' and b.SEX_UPON_OUTCOME not like 'Intact%'
order by 1

#보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.