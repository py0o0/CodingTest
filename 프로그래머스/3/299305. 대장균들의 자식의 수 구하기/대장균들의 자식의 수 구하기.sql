select ID, (select count(*)
           from ECOLI_DATA b
           where a.ID = b.PARENT_ID) AS CHILD_COUNT
from ECOLI_DATA a
order by 1

#대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요. 자식이 없다면 자식의 수는 0으로 출력해주세요. 이때 결과는 개체의 ID 에 대해 오름차순 정렬해주세요.