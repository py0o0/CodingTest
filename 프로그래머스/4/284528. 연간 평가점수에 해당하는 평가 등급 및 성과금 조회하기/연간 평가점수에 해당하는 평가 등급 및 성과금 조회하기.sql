select a.EMP_NO,EMP_NAME,
    case
        when avg(score) >= 96 then 'S'
        when avg(score) >= 90 then 'A'
        when avg(score) >= 80 then 'B'
        else 'C'
        end
    as GRADE,
    case
        when avg(score) >= 96 then sal * 0.2
        when avg(score) >= 90 then sal * 0.15
        when avg(score) >= 80 then sal * 0.1
        else 0
        end
    as BONUS
from HR_EMPLOYEES a right join
HR_GRADE b on a.EMP_NO = b.EMP_NO
group by 1
order by 1
