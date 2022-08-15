SELECT hour(DATETIME) as hello, count(DATETIME)
from ANIMAL_OUTS
where hour(DATETIME) between 9 and 19
group by hello
order by hello ;