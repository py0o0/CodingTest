-- 코드를 입력하세요
select concat("/home/grep/src/", a.BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT)
    as FILE_PATH
from USED_GOODS_FILE a
where a.BOARD_ID =
    (
        select b.BOARD_ID
        from USED_GOODS_BOARD b
        order by b.VIEWS desc
        limit 1
    )
order by FILE_ID desc