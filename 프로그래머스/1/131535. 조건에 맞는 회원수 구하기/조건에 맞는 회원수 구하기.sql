select count(*) as USERS
from USER_INFO
where YEAR(JOINED) = 2021
    and AGE >= 20
    and AGE < 30