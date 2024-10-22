select a.ITEM_ID, ITEM_NAME
from ITEM_INFO as a left join 
ITEM_TREE as b on a.ITEM_ID = b.ITEM_ID
where PARENT_ITEM_ID is null
order by 1

#ROOT 아이템을 찾아 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME)을 출력하는 SQL문을 작성해 주세요. 이때, 결과는 아이템 ID를 기준으로 오름차순 정렬해 주세요.