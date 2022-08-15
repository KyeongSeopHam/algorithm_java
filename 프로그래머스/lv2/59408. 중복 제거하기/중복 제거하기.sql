select count(a.name)
from (SELECT name
from ANIMAL_INS
group by name) a