# 관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 
# 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
# 이때 결과는 보호 시작일이 빠른 순으로 조회해야합니다.

# step1
# 결과는  ANIMAL_ID	NAME 를 뽑을거
# animal_ins 테이블과 outs 테이블을 조인시킨후
# where 조건을 걸어줄건데 
# 일단 문제를 풀기위해 필수조건으로 
# ins의 id의 값 == outs id의값이 같아하며
# 그리고 (and)  우리가 찾는건 보호시작일보다 입양일이 더빠른 동물을 찾아야하니까 (아이디,이름)
# ins.datetime   out.datetime 이 있을때   >= 해준다.


select i.animal_id , i.name
from animal_ins as i join animal_outs as o
where i.animal_id = o.animal_id and  i.datetime> o.datetime
order by i.datetime

