select  *
from C T1
inner join (select * from R1 where R1.W between 'a' and 'z') T2 on T1.V=T2.V

select * 
from "LLEME"."PARTICIPATED" T1
inner join "LLEME"."PERSON" T2 on T2."driver-id" = T1."driver-id"
WHERE T2."name">'DD'

create or replace
TRIGGER VALIDA_ORDEM_SERVICO 
BEFORE INSERT OR UPDATE ON "ORDEM_SERVICO"
REFERENCING OLD AS ANTIGO NEW AS NOVO
for each row
DECLARE 
  INICIO NUMBER(4,3);
  FIM NUMBER(4,3);
BEGIN
  -- Verifica se o valor da multa é permitido
  WITH
    T1 AS (SELECT MAX("DATA") AS "VIGENCIA" FROM MULTA TAB WHERE TAB."DATA"<=:NOVO.ABERTURA)
  SELECT INICIO_FAIXA,FIM_FAIXA INTO INICIO,FIM FROM "MULTA" WHERE "DATA"=(SELECT "VIGENCIA" FROM T1);
  if (not(:NOVO.MULTA between INICIO and FIM)) then
    RAISE_APPLICATION_ERROR(-20001,'ERRO');
  END IF;
END;



create table VENDEDOR(
"matricula" number(12,0),
"name" nvarchar2(200) not null enable,
"endereco" nvarchar2(200) not null enable,
"cpf" number(11,0) not null enable,
primary key ("matricula"));
commit;

drop table TELEFONE;
commit;
create table TELEFONE(
"numero" number(8,0),
"matricula" number(12,0),
"cliente" number(12,0),
primary key ("numero"),
CONSTRAINT "TELEFONE_CHK1" CHECK ("matricula" IS NULL OR "cliente" IS NULL) ENABLE);
commit;

create table CLIENTE(
"numero" number(8,0),
"nome" varchar2(200),
"cliente" number(12,0),
primary key ("numero"));
commit;


drop table person;
create table PERSON(
"driver-id" number(24,0),
"name" nvarchar2(200) not null enable,
"address" nvarchar2(200),
primary key ("driver-id"));
commit;

create table CAR(
"license" number(24,0),
"model" nvarchar2(100) not null enable,
"year" number(4,0) not null enable,
primary key ("license"),
CONSTRAINT "CAR_CHK1" CHECK ("year" BETWEEN 2000 AND 2025) ENABLE);
commit;

drop table accident;
create table ACCIDENT(
"report-number" number(5,0),
"date" date,
"location" nvarchar2(100),
primary key ("report-number"));
commit;

drop table owns;
create table OWNS (
"driver-id" number(24,0),
"license" number(24,0),
primary key ("driver-id","license"),
constraint "OWNS_CAR_FK1" foreign key ("license")
	  references "LLEME"."CAR" ("license") enable,
constraint "OWNS_PERSON_FK1" foreign key ("driver-id")
	  REFERENCES "LLEME"."PERSON" ("driver-id") ENABLE
);
commit;

drop table participated;
create table PARTICIPATED(
"driver-id" number(24,0),
"car" number(24,0),
"report-number" number(5,0),
"damage-amount" nvarchar2(200),
constraint "PK_PARTICIPATED" primary key ("driver-id","car","report-number"),
constraint "PARTICIPATED_CAR_FK1" foreign key ("car")
	  references "LLEME"."CAR" ("license") enable,
constraint "PARTICIPATED_PERSON_FK1" foreign key ("driver-id")
	  references "LLEME"."PERSON" ("driver-id") enable,
constraint "PARTICIPATED_ACCIDENT_FK1" foreign key ("report-number")
	  references "LLEME"."ACCIDENT" ("report-number") enable);
commit;

insert into PERSON("driver-id","name","address")
values (123456, 'Motoriasta 1', 'Rua 1, bairro são domingos');
commit;

insert into CAR("license", "model", "year") values (1111,'gol',2010);
commit;

insert into ACCIDENT("report-number","date","location")
values (33333, TO_DATE('12-01-2012', 'mm-dd-YYYY'),'praia');
commit;

insert into PARTICIPATED values(123456,1111,33333, 'muito amassado');
commit;

insert into OWNS values (123456,1111);
commit;

select extract(year from sysdate) from dual;


with
  R1 as (select * from ACCIDENT where extract(year from "date")=2012),
  R3 as (select "car" from R1 T1 inner join PARTICIPATED T2 on T1."report-number"=T2."report-number"),
  R4 as (select distinct "driver-id" from R3 inner join OWNS on OWNS."license"=R3."car")
select count("driver-id") from r4;
--------------------------------------------------

1) ATRIBUIÇÃO
create materialized view VIEW_ACCIDENT as (select "report-number", "location" from ACCIDENT);
select * from view_accident;

2) rename
select t1."report-number" as col1 from accident t1

3) PROJEÇÃO
select COL1, COL2, ..
from RELACAO

4) SELEÇÃO
select
from (select "date" from accident)
where (expressao logica)

5) JUNÇÃO (natural, EXTERNA, left, right, full)
select 
from RELACAO1 natural join RELACAO2 
OU
from RELACAO1 inner join RELACAO2 on (LICENSE > CAR)
OU
from RELACAO1 left join RELACAO2 on (EXPRESSAO LOGICA)
OU 
from RELACAO1 right join RELACAO2 on (EXPRESSAO LOGICA)
OU
from relacao1 full join relacao2 on (expressao)

6) AGREGAÇÃO
select COL1, COL2, col4, col5, AGGREG(COL3)
from RELACAO
where (expressao)
group by COL1, COL2, COL4, COL5 
having aggreg(col3)>10

7) DIVISÃO

8) PRODUTO
select *
from RELACAO1, RELACAO2
where

9) UNIÃO
RELACAO1 union RELACAO2
RELACAO1 union all RELACAO2

10) INTERSEÇÃO
(select date from accident) intersect (select sysdate from dual)

11) EXCLUSÃO
delete from "C" where w like '';

12) ALTERAÇÃO
update relacao set atributo=valor, atributo2=valor where (expressao)

select *
from TABELA
where 
ATRIBUTO in (select COL from TABELA)
ATRIBUTO <= (select COL from TABELA where CONDICAO)
ATRIBUTO like 'hoje vamos almmocar'
'' = ''
null = ''
nvl(atributo,valor)
ATRIBUTO is null
select * from accident where nvl("location",'') <> 'praia';


