create or replace 
trigger REGRA_QTD_EMPRESTIMO
after insert or update on EMPRESTIMO 
referencing old as ANTIGO new as NOVO 
for each row
declare 
  V_ESTOURO number(1,0);
  V_USUARIO USUARIO."ID"%type;
  V_QTD TIPO.QTD_EMPRESTIMO%type;
  V_INICIO OPERACAO."DATA"%type;
  V_FIM OPERACAO."DATA"%type;
  MAX_DATA OPERACAO."DATA"%type;
begin
  DBMS_OUTPUT.enable;
  max_data:=TO_DATE('31-12-9999','dd-mm-yyyy');
  V_ESTOURO:=0;
  V_USUARIO:=null;
  V_QTD:=null;
  V_INICIO:=null;
  V_FIM:=null;
      
  begin
    select U."ID", T.QTD_EMPRESTIMO, OE."DATA"
    into V_USUARIO,V_QTD, V_INICIO
    from OPERACAO OE
    inner join USUARIO U on U."ID"=OE.USUARIO_ID
    inner join TIPO T on T.CODIGO= U.TIPO_CODIGO
    where OE.NUMERO=:NOVO.OPERACAO_NUMERO;
    
    DBMS_OUTPUT.PUT_LINE(:NOVO.OPERACAO_NUMERO||','||V_USUARIO||', '||V_INICIO||', '||V_FIM);
  EXCEPTION
    when OTHERS then
      V_ESTOURO:=1;
      V_USUARIO:=null;
      V_QTD:=null;
      V_INICIO:=null;
  end;
  
  
  begin
    select OD."DATA"
    into V_FIM
    from DEVOLUCAO D
    inner join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
    where D.EMPRESTIMO_NUMERO=:ANTIGO.OPERACAO_NUMERO;
  EXCEPTION
    when OTHERS then
      V_FIM:=MAX_DATA;
  end;
  

  begin
    select 1 
    into V_ESTOURO
    from DUAL
    where exists(
      with 
        PERIODO as (
          select
            OE."DATA" INICIO,
            NVL(OD."DATA",MAX_DATA) FIM
          from EMPRESTIMO E 
          inner join OPERACAO OE on OE.NUMERO=E.OPERACAO_NUMERO
          left join DEVOLUCAO D on D.EMPRESTIMO_NUMERO=E.OPERACAO_NUMERO
          left join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
          where OE.USUARIO_ID=V_USUARIO
          and ((:ANTIGO.OPERACAO_NUMERO is not null and OE.NUMERO != :ANTIGO.OPERACAO_NUMERO) 
              or (:ANTIGO.OPERACAO_NUMERO is null and OE.NUMERO = OE.NUMERO))),
        
        PERIODO2 as (
          select
            case
              when T1.INICIO<=V_INICIO then V_INICIO
              else T1.INICIO
            end INICIO,
            case
              when T1.FIM>=V_FIM then V_FIM
              else T1.FIM
            end FIM
          from PERIODO T1
          where V_INICIO between T1.INICIO and T1.FIM
            or V_FIM BETWEEN T1.INICIO and T1.FIM),
        
        "DATA" as (
          select V_INICIO "DATA" from DUAL
          union select V_FIM from DUAL
          union select PERIODO2.INICIO from PERIODO2
          union select PERIODO2.FIM from PERIODO2),
        
        CONTAGEM as (
          select "DATA",COUNT(*) CONTAGEM
          from "DATA"
          inner join PERIODO2 on INICIO<="DATA"
          and (FIM >="DATA" or FIM is null) 
          group by "DATA"
          having COUNT(*)>(V_QTD-1))
      select * from CONTAGEM
    );
  EXCEPTION
    when OTHERS then
      V_ESTOURO := 0;
  end;
  
  if (V_ESTOURO > 0) then
    RAISE_APPLICATION_ERROR(-20001,'ERRO: QTD NAO PERMITIDA');
  end if;
END;

create or replace 
trigger REGRA_DISPONIBILIDADE_EXEMPLAR
before insert or update on EMPRESTIMO 
referencing old as ANTIGO new as NOVO 
for each row
declare
  V_EMPRESTADO NUMBER(1,0);
  V_DATA OPERACAO."DATA"%type;
begin
  V_EMPRESTADO := 0;
  V_DATA := null;
  
  begin
    select o."DATA"
    into V_DATA
    from OPERACAO O 
    where O.NUMERO = :NOVO.OPERACAO_NUMERO;
  EXCEPTION
    when OTHERS then
      V_DATA := null;
  end;
  
  begin
    select 1 
    into V_EMPRESTADO
    from dual
    where exists(
      select * 
      from EMPRESTIMO E
      inner join OPERACAO OE on OE.NUMERO=E.OPERACAO_NUMERO
      left join DEVOLUCAO D on D.EMPRESTIMO_NUMERO=E.OPERACAO_NUMERO
      left join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
      where E.MATERIAL_CODIGO=:NOVO.MATERIAL_CODIGO
      and E.EXEMPLAR_NUM=:NOVO.EXEMPLAR_NUM
      and OE."DATA"<=V_DATA
      and (OD."DATA" is null or OD."DATA" >= V_DATA)
      );
  EXCEPTION
    when OTHERS then
      V_EMPRESTADO := 0;
  end;
  
  if (V_EMPRESTADO=1) then
    RAISE_APPLICATION_ERROR(-20002,'ERRO: Exemplar emprestado');
  end if;
      
end;

create or replace 
trigger REGRA_PENDENCIAS
before insert or update on EMPRESTIMO 
referencing old as ANTIGO new as NOVO 
for each row
declare
  V_PENDENTES number(1,0);
  V_DATA OPERACAO."DATA"%type;
  V_USUARIO USUARIO."ID"%type;
  V_TEMPO TIPO.TEMPO_EMPRESTIMO%type;
begin
  V_PENDENTES := 0;
  V_DATA := null;
  V_TEMPO := 0;
  
  begin
    select O."DATA",U."ID", T.TEMPO_EMPRESTIMO
    into V_DATA,V_USUARIO,V_TEMPO
    from OPERACAO O
    inner join USUARIO U on U."ID"=O.USUARIO_ID
    inner join TIPO T on T.CODIGO= U.TIPO_CODIGO
    where O.NUMERO=:NOVO.OPERACAO_NUMERO;
  EXCEPTION
    when OTHERS then
      V_DATA := null;
      V_USUARIO:=null;
      V_TEMPO:=null;
  end;
  
  begin
    select 1 
    into V_PENDENTES
    from dual
    where exists(
      select OE.NUMERO
      from EMPRESTIMO E
      inner join OPERACAO OE on OE.NUMERO=E.OPERACAO_NUMERO
      left join DEVOLUCAO D on D.EMPRESTIMO_NUMERO=E.OPERACAO_NUMERO
      left join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
      where OE.USUARIO_ID = V_USUARIO
      and OE."DATA"<=V_DATA
      and (OD."DATA" is null or OD."DATA" >= V_DATA)
      and (V_DATA-OE."DATA") > V_TEMPO
      );
  EXCEPTION
    when OTHERS then
      V_PENDENTES := 0;
  end;
  
  if (V_PENDENTES=1) then
    RAISE_APPLICATION_ERROR(-20003,'ERRO: emprestimos pendentes');
  end if;
      
end;


insert into TIPO(CODIGO,DESCRICAO,QTD_EMPRESTIMO,tempo_emprestimo) values (1,'Aluno graduacao',3,3);
commit;
insert into USUARIO("ID",TIPO_CODIGO,NOME) values (100,1,'Luiz');
commit;
insert into USUARIO("ID",TIPO_CODIGO,NOME) values (200,1,'Andre');
commit;
insert into MATERIAL(CODIGO,TITULO) values (1,'Livro 1');
insert into Livro(material_codigo) values (1);
insert into EXEMPLAR(MATERIAL_CODIGO,NUMERO) values (1,1);
commit;
insert into MATERIAL(CODIGO,TITULO) values (2,'Livro 2');
insert into Livro(material_codigo) values (2);
insert into EXEMPLAR(MATERIAL_CODIGO,NUMERO) values (2,1);
commit;
insert into MATERIAL(CODIGO,TITULO) values (3,'Livro 3');
insert into Livro(material_codigo) values (3);
insert into EXEMPLAR(MATERIAL_CODIGO,NUMERO) values (3,1);
commit;
insert into MATERIAL(CODIGO,TITULO) values (4,'Livro 4');
insert into Livro(material_codigo) values (4);
insert into EXEMPLAR(MATERIAL_CODIGO,NUMERO) values (4,1);
commit;
insert into MATERIAL(CODIGO,TITULO) values (5,'Livro 5');
insert into Livro(material_codigo) values (5);
insert into EXEMPLAR(MATERIAL_CODIGO,NUMERO) values (5,1);
commit;

--delete from EMPRESTIMO where OPERACAO_NUMERO=100;
--delete from OPERACAO where NUMERO=100;
--commit;
insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (100,TO_DATE('14/10/2013','dd/mm/yyyy'),200);
insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (100,5,1);
insert into OPERACAO(NUMERO,"DATA",usuario_id) values (110,TO_DATE('16/10/2013','dd/mm/yyyy'),200);
insert into DEVOLUCAO(OPERACAO_NUMERO,EMPRESTIMO_NUMERO) values (110,100);
commit;

insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (1,TO_DATE('15/10/2013','dd/mm/yyyy'),100);
insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (1,1,1);
commit;
insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (2,TO_DATE('15/10/2013','dd/mm/yyyy'),100);
insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (2,2,1);
commit;
insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (3,TO_DATE('15/10/2013','dd/mm/yyyy'),100);
insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (3,5,1);
commit;
insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (3,TO_DATE('15/10/2013','dd/mm/yyyy'),100);
insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (3,3,1);
insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (4,TO_DATE('17/10/2013','dd/mm/yyyy'),100);
insert into DEVOLUCAO(OPERACAO_NUMERO,EMPRESTIMO_NUMERO) values(4,3)
commit;

---------------------
delete from OPERACAO where NUMERO=5;
commit;
set SERVEROUTPUT on;
execute ADD_EMPRESTIMO(5,100,TO_DATE('14/10/2013','dd/mm/yyyy'),3,1);
insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (5,TO_DATE('14/10/2013','dd/mm/yyyy'),100);
insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (5,3,1);
commit;
