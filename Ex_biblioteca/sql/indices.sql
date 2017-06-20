begin
  dbms_auto_task_admin.enable(client_name => 'auto optimizer stats collection',
  OPERATION => null, WINDOW_NAME => null);
end;
begin
  dbms_auto_task_admin.disable(client_name => ‘auto optimizer stats collection’,
  OPERATION => null, WINDOW_NAME => null);
end;
select CLIENT_NAME,STATUS,CONSUMER_GROUP,MEAN_JOB_DURATION from DBA_AUTOTASK_CLIENT;



CREATE TABLE "AULA_INDICES"."ALUNO" 
   (	"MATRICULA" NUMBER(10,0) NOT NULL ENABLE, 
	"NOME" VARCHAR2(255 BYTE) NOT NULL ENABLE, 
	"ENDERECO" VARCHAR2(25 BYTE), 
	 CONSTRAINT "ALUNO_PK" PRIMARY KEY ("MATRICULA"));
   

CREATE TABLE "AULA_INDICES"."DISCIPLINA" 
   (	"CODIGO" NUMBER(10,0) NOT NULL ENABLE, 
	"NOME" VARCHAR2(255 BYTE), 
	"CARGA" NUMBER(10,0) NOT NULL ENABLE, 
	 constraint "DISCIPLINA_PK" primary key ("CODIGO"));
   

CREATE TABLE "AULA_INDICES"."TURMA" 
   (	"CODIGO" NUMBER(10,0) NOT NULL ENABLE, 
	"ALUNO" NUMBER(10,0) NOT NULL ENABLE, 
	"DISCIPLINA" NUMBER(10,0) NOT NULL ENABLE, 
	 CONSTRAINT "TURMA_PK" PRIMARY KEY ("CODIGO"));


===================================================================
Slide S1 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable, 
	"NOME" varchar2(255 byte) not null enable,
	"ENDERECO" varchar2(25 byte)); 
select AL.NOME from AULA_INDICES.ALUNO AL where AL.MATRICULA=6;

SLIDE S2 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" NUMBER(10,0) NOT NULL ENABLE, 
	"NOME" varchar2(20 byte),
  "ENDERECO" varchar2(25 byte),
	 CONSTRAINT "ALUNO_PK" PRIMARY KEY ("MATRICULA") ENABLE
) organization index ;
select AL.NOME from AULA_INDICES.ALUNO AL where AL.MATRICULA=6;

SLIDE S3 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" NUMBER(10,0) NOT NULL ENABLE, 
	"NOME" varchar2(20 byte),
  "ENDERECO" varchar2(25 byte),
	 constraint "ALUNO_PK" primary key ("MATRICULA") enable
);
--alter table "AULA_INDICES"."ALUNO"
--add constraint "ALUNO_PK" primary key ("MATRICULA");
select AL.NOME from AULA_INDICES.ALUNO AL where AL.MATRICULA=6;

SLIDE S4 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
drop cluster "AULA_INDICES"."ALUNO_Mat_CT"; 
create cluster "AULA_INDICES"."ALUNO_Mat_CT" (MATRICULA number(10,0)) 
hashkeys 100 hash is MATRICULA size 256; 
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable
	,"NOME" varchar2(20 byte)
  ,"ENDERECO" varchar2(25 byte)
  ,constraint "ALUNO_PK" primary key ("MATRICULA") enable) 
cluster "AULA_INDICES"."ALUNO_Mat_CT" (MATRICULA)
;
select * from AULA_INDICES.ALUNO AL where AL.MATRICULA=6;

alter table "AULA_INDICES"."ALUNO"
add constraint "ALUNO_PK" primary key;

select AL.NOME from AULA_INDICES.ALUNO AL where AL.MATRICULA>1000;

SLIDE S5 -----------------------------------------------------------
-- Não implementado em Oracle

SLIDE S6 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" NUMBER(10,0) NOT NULL ENABLE, 
	"NOME" varchar2(20 byte),
  "ENDERECO" varchar2(25 byte),
	 constraint "ALUNO_PK" primary key ("MATRICULA") enable
);
drop index "AULA_INDICES"."ALUNO_NOME";
create index "AULA_INDICES"."ALUNO_NOME" 
on "AULA_INDICES"."ALUNO" ("NOME")
compute statistics;
select * from AULA_INDICES.ALUNO AL where AL.NOME='Luiz';
select AL.NOME from AULA_INDICES.ALUNO AL where AL.NOME='Luiz';

SLIDE S7 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable, 
	"NOME" varchar2(20 byte),
  "ENDERECO" VARCHAR2(255),
	 constraint "ALUNO_PK" primary key ("MATRICULA") enable
);
drop index "AULA_INDICES"."ALUNO_NOME";
create index "AULA_INDICES"."ALUNO_NOME" 
on "AULA_INDICES"."ALUNO" ("NOME")
compute statistics;
select * from AULA_INDICES.ALUNO AL 
where AL.NOME='Luiz' and AL.ENDERECO='Rua 1';

SLIDE S8 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable, 
	"NOME" varchar2(20 byte),
  "ENDERECO" VARCHAR2(255),
	 constraint "ALUNO_PK" primary key ("MATRICULA") enable
);
drop index "AULA_INDICES"."ALUNO_NOME";
create index "AULA_INDICES"."ALUNO_NOME" 
on "AULA_INDICES"."ALUNO" ("NOME")
compute statistics;
select * from AULA_INDICES.ALUNO AL 
where AL.NOME='Luiz' and AL.ENDERECO='Rua 1';

SLIDE S9 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable, 
	"NOME" varchar2(20 byte),
  "ENDERECO" varchar2(255),
  "TELEFONE" number(10,0),
  "CPF" number(10,0),
  constraint "ALUNO_PK" primary key ("MATRICULA","TELEFONE") enable
);
drop index "AULA_INDICES"."ALUNO_MAT";
create index "AULA_INDICES"."ALUNO_MAT" 
on "AULA_INDICES"."ALUNO" ("MATRICULA")
compute statistics;
drop index "AULA_INDICES"."ALUNO_TEL";
create index "AULA_INDICES"."ALUNO_TEL" 
on "AULA_INDICES"."ALUNO" ("TELEFONE")
compute statistics;

select AL.NOME 
from AULA_INDICES.ALUNO AL 
where AL.MATRICULA=123 and AL.TELEFONE=1;

SLIDE J1 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable
	,"NOME" varchar2(20 byte)
  --,constraint "ALUNO_PK" primary key ("MATRICULA") enable
);
drop table "AULA_INDICES"."DISCIPLINA" cascade constraints purge;
create table "AULA_INDICES"."DISCIPLINA" (
  "CODIGO" number(10,0) not null enable
	,"NOME" varchar2(255 byte)
	,"CARGA" number(10,0) not null enable
  --,constraint "DISCIPLINA_PK" primary key ("CODIGO")
);
drop table "AULA_INDICES"."TURMA" cascade constraints purge;
create table "AULA_INDICES"."TURMA" (
	"ALUNO" number(10,0) not null enable
	,"DISCIPLINA" number(10,0) not null enable 
  --constraint "TURMA_PK" primary key ("ALUNO","DISCIPLINA")
);

select
--/*+ use_nl(tu al) */ 
* from AULA_INDICES.ALUNO AL inner join AULA_INDICES.TURMA TU on AL.MATRICULA=TU.ALUNO;

SLIDE J2 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable
	,"NOME" varchar2(20 byte)
  ,constraint "ALUNO_PK" primary key ("MATRICULA") enable
);
drop table "AULA_INDICES"."DISCIPLINA" cascade constraints purge;
create table "AULA_INDICES"."DISCIPLINA" (
  "CODIGO" number(10,0) not null enable
	,"NOME" varchar2(255 byte)
	,"CARGA" number(10,0) not null enable
  ,constraint "DISCIPLINA_PK" primary key ("CODIGO")
) ;
drop table "AULA_INDICES"."TURMA" cascade constraints purge;
create table "AULA_INDICES"."TURMA" (
	"ALUNO" number(10,0) not null enable
	,"DISCIPLINA" number(10,0) not null enable 
  ,constraint "TURMA_PK" primary key ("ALUNO","DISCIPLINA")
);

select tu.* 
from AULA_INDICES.ALUNO AL inner join AULA_INDICES.TURMA TU on AL.MATRICULA=TU.ALUNO;

SLIDE J3 -----------------------------------------------------------
drop table "AULA_INDICES"."ALUNO" cascade constraints purge;
create table "AULA_INDICES"."ALUNO" (	
  "MATRICULA" number(10,0) not null enable
	,"NOME" varchar2(20 byte)
  ,"ENDERECO" varchar2(255)
  ,"TELEFONE" number(10,0)
  ,constraint "ALUNO_PK" primary key ("MATRICULA") enable
) organization index;
drop table "AULA_INDICES"."DISCIPLINA" cascade constraints purge;
create table "AULA_INDICES"."DISCIPLINA" (
  "CODIGO" number(10,0) not null enable
	,"NOME" varchar2(255 byte)
	,"CARGA" number(10,0) not null enable
  ,constraint "DISCIPLINA_PK" primary key ("CODIGO")
) organization index;
drop table "AULA_INDICES"."TURMA" cascade constraints purge;
create table "AULA_INDICES"."TURMA" (
	"ALUNO" number(10,0) not null enable
	,"DISCIPLINA" number(10,0) not null enable 
  ,constraint "TURMA_PK" primary key ("ALUNO")
) organization index;

select /*+ use_merge(al tu) */ 
* from AULA_INDICES.ALUNO AL inner join AULA_INDICES.TURMA TU on AL.MATRICULA=TU.ALUNO;

with 
  T1 as (select * from AULA_INDICES.ALUNO order by 1),
  T2 as (select * from AULA_INDICES.TURMA order by 1)
select * from T1 inner join T2 on T1.MATRICULA=T2.ALUNO;




====================================================================
delete * from AULA_INDICES.ALUNO;
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (123,'Luiz','Rua 1',1);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,TELEFONE) values (456,'Luiz',2);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (1,'Luiz','Rua 1',11);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (22,'Luiz','Rua 1',3);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (777,'Luiz','Rua 1',4);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (888,'Luiz','Rua 1',5);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (33,'Luiz','Rua 1',7);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (2,'Luiz','Rua 1',8);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (3,'Luiz','Rua 1',9);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (11,'Luiz','Rua 1',12);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (4,'Luiz','Rua 1',13);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (5,'Luiz','Rua 1',14);
insert into AULA_INDICES.ALUNO(MATRICULA,NOME,ENDERECO,TELEFONE) values (6,'Luiz','Rua 1',15);

insert into AULA_INDICES.DISCIPLINA(CODIGO,NOME,CARGA) values (1,'TCC00177',48);
insert into AULA_INDICES.DISCIPLINA(CODIGO,NOME,CARGA) values (2,'TCC00173',48);
insert into AULA_INDICES.TURMA(ALUNO,DISCIPLINA) values (123,1);
insert into AULA_INDICES.TURMA(ALUNO,DISCIPLINA) values (456,1);
insert into AULA_INDICES.TURMA(ALUNO,DISCIPLINA) values (1,1);
insert into AULA_INDICES.TURMA(ALUNO,DISCIPLINA) values (22,1);
insert into AULA_INDICES.TURMA(ALUNO,DISCIPLINA) values (3,1);

insert into AULA_INDICES.ALUNO(MATRICULA,NOME) values (123,'Luiz');
select AL.NOME from AULA_INDICES.ALUNO2 AL where AL.MATRICULA=123;
select AL.NOME from AULA_INDICES.ALUNO AL where AL.MATRICULA=6;
select * from AULA_INDICES.ALUNO AL order by AL.NOME;