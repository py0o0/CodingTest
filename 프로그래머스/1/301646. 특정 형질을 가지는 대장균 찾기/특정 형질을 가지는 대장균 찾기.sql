select count(*) as COUNT
from ECOLI_DATA
where (GENOTYPE & 2) = 0
    AND 
        ((GENOTYPE & 1) != 0
        OR (GENOTYPE & 4) != 0)