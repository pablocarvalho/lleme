create or replace 
PROCEDURE ADD_EMPRESTIMO 
(
  P_NUMERO IN NUMBER  
, P_USUARIO IN NUMBER  
, P_DATA IN DATE  
, P_MATERIAL IN NUMBER  
, P_EXEMPLAR IN VARCHAR2  
) AS
  V_ESTOURO number(1,0);
  V_QTD_MAX TIPO.QTD_EMPRESTIMO%type;
  V_INICIO OPERACAO."DATA"%type;
  V_FIM OPERACAO."DATA"%type;
  v_MAX_DATA OPERACAO."DATA"%type;
  type CT_PERIODOS is ref cursor;
  C_PERIODOS CT_PERIODOS;
begin
  DBMS_OUTPUT.enable;
  V_MAX_DATA:=TO_DATE('31-12-9999','dd-mm-yyyy');
  V_ESTOURO:=0;
  V_QTD_MAX:=0;
  V_INICIO:=null;
  V_FIM:=null;
  
  begin
    select T.QTD_EMPRESTIMO
    into V_QTD_MAX
    from USUARIO U
    inner join TIPO T on T.CODIGO= U.TIPO_CODIGO
    where U."ID"=P_USUARIO;
  EXCEPTION
    when OTHERS then
      V_QTD_MAX:=null;
      v_estouro:=1;
  end;
  
  open C_PERIODOS for
    'select
      OE."DATA" INICIO,
      NVL(OD."DATA",TO_DATE(''31-12-9999'',''dd-mm-yyyy'')) FIM
    from EMPRESTIMO E 
    inner join OPERACAO OE on OE.NUMERO=E.OPERACAO_NUMERO
    left join DEVOLUCAO D on D.EMPRESTIMO_NUMERO=E.OPERACAO_NUMERO
    left join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
    where OE.USUARIO_ID='||P_USUARIO;
  LOOP
    FETCH C_PERIODOS into V_INICIO,V_FIM;
    EXIT when C_PERIODOS%NOTFOUND or v_estouro=1;
    if (P_DATA between V_INICIO and V_FIM or V_MAX_DATA between V_INICIO and V_FIM) then
      IF (V_INICIO<P_DATA) THEN
        V_INICIO:=P_DATA;
      end if;
      if (V_FIM>V_MAX_DATA) then
        V_FIM:=V_MAX_DATA;
      end if;
      if (CONTA_EMPRESTIMOS(P_USUARIO,V_INICIO)>=V_QTD_MAX 
        or CONTA_EMPRESTIMOS(P_USUARIO,V_FIM)>=V_QTD_MAX) then
        V_ESTOURO:=1;
      end if;
    end if;
  end LOOP;
  
  
  if (v_estouro=0) then
    begin  
      insert into OPERACAO(NUMERO,"DATA",USUARIO_ID) values (P_NUMERO,P_DATA,P_USUARIO);
      insert into EMPRESTIMO(OPERACAO_NUMERO,MATERIAL_CODIGO,EXEMPLAR_NUM) values (P_NUMERO,P_MATERIAL,P_EXEMPLAR);
      commit;
    EXCEPTION
      when OTHERS then
        DBMS_OUTPUT.PUT_LINE('*** ERRO ***');
    end;
  else
    DBMS_OUTPUT.PUT_LINE('*** ERRO ***');
  end if;
END ADD_EMPRESTIMO;

create or replace 
FUNCTION CONTA_EMPRESTIMOS 
(
  P_USUARIO IN NUMBER  
, P_DATA IN DATE  
) return number as 
  V_QTD NUMBER;
begin
  begin
    select
      COUNT(*) as QTD
    into V_QTD
    from EMPRESTIMO E 
    inner join OPERACAO OE on OE.NUMERO=E.OPERACAO_NUMERO
    left join DEVOLUCAO D on D.EMPRESTIMO_NUMERO=E.OPERACAO_NUMERO
    left join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
    where OE.USUARIO_ID=p_USUARIO
    and OE."DATA"<=P_DATA and (OD."DATA">=P_DATA or OD."DATA" is null);
  EXCEPTION
    when OTHERS then
      V_QTD:=0;
  end;
  return V_QTD;
end CONTA_EMPRESTIMOS;


create or replace 
procedure LISTA_USUARIO (P_RESULT in OUT SYS_REFCURSOR) as
begin
  open P_RESULT for 'SELECT * FROM USUARIO';
end LISTA_USUARIO;


with
  t1 as (select OE."DATA" INICIO, nvl(OD."DATA",to_date('31/12/9999','dd/mm/yyyy')) FIM
        from OPERACAO OE
        inner join EMPRESTIMO E on OE.NUMERO=E.OPERACAO_NUMERO
        left join DEVOLUCAO D on D.EMPRESTIMO_NUMERO=E.OPERACAO_NUMERO
        left join OPERACAO OD on OD.NUMERO=D.OPERACAO_NUMERO
        where OE.USUARIO_ID=100),
  T2 as (select INICIO, fim from T1
        where not (FIM<TO_DATE('18/10/2013','dd/mm/yyyy')) 
        and not (INICIO>TO_DATE('19/10/2013','dd/mm/yyyy'))),
  T3 as (select INICIO from T2   
        union select TO_DATE('18/10/2013','dd/mm/yyyy') from DUAL
        union select TO_DATE('19/10/2013','dd/mm/yyyy') from DUAL),
  T4 as (select t3.inicio dt,count(*) qtd
        from T3 inner join T2 on T3.INICIO>=T2.INICIO 
        and T3.INICIO<=T2.FIM
        group by T3.INICIO
        having count(*)>=2)
select * from T4;
