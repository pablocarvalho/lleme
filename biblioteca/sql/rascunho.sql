alter session set nls_date_format='dd/mm/yyyy';
select date '9999-12-31' from DUAL;
select TO_DATE('13-10-2013','dd-mm-yyyy')+30 from DUAL
select 
case
  when round(date '9999-01-01','CC') is null then TO_DATE('13-10-2013','dd-mm-yyyy')
  when TO_DATE('13-10-2013','dd-mm-yyyy')>=round(date '9999-01-01','CC') then round(date '9999-01-01','CC')
  else TO_DATE('13-10-2013','dd-mm-yyyy')
end
from dual;

set AUTOPRINT on; 
VARIABLE OUTPUT REFCURSOR;
begin
  LISTA_USUARIO(:OUTPUT);
END;


select * from (LISTA_USUARIO());
