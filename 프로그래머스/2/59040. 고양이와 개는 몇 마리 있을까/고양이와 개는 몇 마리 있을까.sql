-- 코드를 입력하세요
select ANIMAL_TYPE,
    count(*) as `count`
from ANIMAL_INS
where ANIMAL_TYPE like "Cat"
    or ANIMAL_TYPE like "Dog"
group by ANIMAL_TYPE
order by ANIMAL_TYPE