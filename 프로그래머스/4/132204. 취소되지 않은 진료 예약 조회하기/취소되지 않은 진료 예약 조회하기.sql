-- 코드를 입력하세요
SELECT a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, a.apnt_ymd
from appointment a
join patient p on p.pt_no = a.pt_no
join doctor d on d.dr_id = a.mddr_id
where a.apnt_cncl_yn = 'N'
    and Year(a.apnt_ymd) = '2022'
    and Month(a.apnt_ymd) = '04'
    and Day(a.apnt_ymd) = '13'
order by a.apnt_ymd