-- 코드를 작성해주세요
select count(ID) as COUNT
from ECOLI_DATA
where (SUBSTRING(LPAD(RIGHT(BIN(GENOTYPE), 4), 4, '0'), 3, 1) = '0' 
        or BIN(GENOTYPE) = '1'
      )
    and (SUBSTRING(LPAD(RIGHT(BIN(GENOTYPE), 4), 4, '0'), 4, 1) = '1' 
         or SUBSTRING(LPAD(RIGHT(BIN(GENOTYPE), 4), 4, '0'), 2, 1) = '1'
        )