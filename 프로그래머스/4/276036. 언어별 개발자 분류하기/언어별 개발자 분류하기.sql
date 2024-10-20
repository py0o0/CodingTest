select
case
    when skill_code & (select sum(code) from SKILLCODES where category like 'Front%') and
    skill_code & (select sum(code) from SKILLCODES where name like 'Python') then 'A'
    when skill_code & (select sum(code) from SKILLCODES where name like 'C#') then 'B'
    when skill_code & (select sum(code) from SKILLCODES where category like 'Front%') then 'C'
    else null
    end as GRADE,ID,EMAIL
from DEVELOPERS
group by 1,2,3
having GRADE is not null
order by 1,2
    
    
