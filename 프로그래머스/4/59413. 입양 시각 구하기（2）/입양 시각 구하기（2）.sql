set @hour = -1;
SELECT @hour := @hour + 1 HOUR, (select count(*) from ANIMAL_OUTS where @hour = HOUR(DATETIME)) as COUNT
from ANIMAL_OUTS
where @hour < 23