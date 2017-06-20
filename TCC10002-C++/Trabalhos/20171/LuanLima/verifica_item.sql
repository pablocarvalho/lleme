drop function if exists soma_matriz();
create or replace function soma_matriz() 
returns table(c1 integer, c2 integer, c3 integer) as $$
declare
    v_a1 integer[3][3];
    v_a2 integer[3][3];
    x integer[];
    y integer;
    r integer[3][3];
    i integer = 1;
    j integer = 1;
begin
    select '{{1,2,3},{1,4,2},{7,8,2}}' into v_a1;
    select '{{3,1,4},{3,4,1},{2,8,2}}' into v_a2;
    select '{{0,0,0},{0,0,0},{0,0,0}}' into r;
    foreach x slice 1 in array v_a1 loop
        j = 1;
        foreach y in array x loop
            r[i][j] = v_a1[i][j] + v_a2[i][j];
            j = j + 1;
        end loop;
        return query select r[i][1], r[i][2], r[i][3];
        i = i + 1;
    end loop;    
end;$$ language plpgsql;

select * from soma_matriz();




select t1.f1[1][1:2] from (SELECT '{{1,2,3},{4,5,6}}'::int[] AS f1) t1

create table tabela(
c1 integer,
c2 integer,
c3 integer
);

insert into tabela values (1,1,1);
insert into tabela values (2,2,2);
insert into tabela values (3,3,3);
insert into tabela values (4,4,4);

select * from tabela;

select array_agg (array(select c1 union all select c2 union all select c3))
from tabela;





CREATE TABLE tictactoe (
    squares   integer[3][3]
);

pay_by_quarter  integer ARRAY[4],

pay_by_quarter  integer ARRAY,

pay_by_quarter = '{{1,2,3},{4,5,6},{7,8,9}}'

INSERT INTO sal_emp
    VALUES ('Bill',
    '{10000, 10000, 10000, 10000}',
    '{{"meeting", "lunch"}, {"training", "presentation"}}');

INSERT INTO sal_emp
    VALUES ('Carol',
    '{20000, 25000, 25000, 25000}',
    '{{"breakfast", "consulting"}, {"meeting", "lunch"}}');








    

create or replace function inscricao(p_matricula int
                                     , p_disciplina int
                                     , p_turma varchar(2)
                                     , p_semestre int) 
returns void as $$
declare
    
begin
    select limite_turma into v_limturma
    from Curso
    where codigo = (select curso from aluno where matricula = p_matricula);
    
    if (select count(*)
        from inscricao 
        where aluno = p_matricula and semestre = p_semestre) >= v_limturma then
        raise exception '';
    end if;

    select limite_alunos into v_limalunos
    from Disciplina
    where codigo = p_disciplina
         
    if (select count(*)
        from inscricao 
        where displina = p_disciplina
              and turma = p_turma
              and semestre = p_semestre) >= v_limturma then
        raise exception '';
    end if;
    
    if exists (with
                    t1 as (select prerequisito from prerequisito where disciplina = p_disciplina),
                    t2 as (select disciplina from inscricao where aluno = p_matricula and nf >= 6)
               select prerequisito
               from t1 
                    left join t2 on prerequisito = disciplina 
                    where disciplina is null)
               ) then
        raise exception '';
    end if

    select d1, hi1, hf1, d2, hi2, hf2
    into v_d1, v_hi1, v_hf1, v_d2, v_hi2, v_hf2
    from turma t1
    where t1.chave = (parametros de entrada)
             
    for r in select 
             from turma_aluno t1 inner join turma t2 on (t1.chave=t2.chave)
             where t1.aluno = p_matricula
                   and t1.nf is null loop

        if (r.d1=v_d1 and (r.hi1 between v_hi1 and v_hf1 or r.hf1 between v_hi1 and v_hf1)
            or r.d2=v_d2 and (r.hi2 between v_hi2 and v_hf2 or r.hf2 between v_hi2 and v_hf2)
            mais duas condicoes)
            erro = true
        end if;
    end loop

    if (erro) then
        raise exception ''
    end if;

    if not exists (select 
                   from turma t1 
                        inner join disciplina t2 on t1.chave=t2.chave
                        inner join curso_aluno t3 on t2.curso=t3.curso
                   where t1.cvave=(parametros de entrada)) then
        raise exception '';
    end if;

    
             
    
    

    
end;$$ language plpgsql;





create or replace function calcula_bonus(p_ano int, p_mat int) 
returns double as $$
declare
    v_bonus double;
begin
    v_bonus = 0;
    with 
        t1(lucro) as (select valor as lucro
                      from lucro 
                      where ano = p_ano);
        t2(salario) as (select valor as salario
                        from salario
                        where matricula = p_matricula)
    select lucro * 0.01 + salario * 0.05 into v_bonus from t1, t2;
    if not found then
        raise notice ''
    end if
    return v_bonus;
end;$$ language plpgsql;



create or replace function consulta_aliquota(p_codigo int) 
returns int as $$
declare
    c_produto cursor (key integer) for select * from produto where cod_prod=key;
    c_aliquota cursor (key integer) for select * from aliquota where cod_cat=key;
    r1 record;
    r2 record;
    v_aliquota double;
begin
    for r1 in c_produto(p_codigo) loop;
        for r2 in c_aliquota(r1.cod_cat) loop;
            select (r2.ipi/100) * r1.valor into v_aliquota;
        end loop;
    end loop;
    return v_aliquota;
end;$$ language plpgsql;


create or replace function conculta_cliente(p_codigo int) 
returns void as $$
declare
    v_nome varchar;
    v_email varchar;
begin
    select nome, email into v_nome, v_email from cliente where codigo=p_codigo;
    if not found then
        RAISE NOTICE 'Erro';
    else
        RAISE NOTICE 'Nome: %, email: %', v_nome, v_email;
    end if;
end;$$ language plpgsql;


create or replace function fibonacci(n int) 
returns table(termo int) as $$
declare
    v1 int;
    v2 int;
    v3 int;
    i int;
begin
    v1=1;
    return query select v1;
    v2=1;
    return query select v2;
    for i in 3..n loop
        v3 = v1 + v2;
        return query select v3;
        v1=v2;
        v2=v3;
    end loop;
end;$$ language plpgsql;

select * from fibonacci(20);

create or replace function reajuste() 
returns void as $$
declare
    c_produto cursor fror select * from produto;
    v_produto record;
begin
    for v_produto in c_produto loop
        if v_produto.categoria = 'A' then
            update produto set preco = 1.05 * preco where CURRENT OF c_produto;
        elsif v_produto.categoria = 'B' then
            update produto set preco = 1.1 * preco where CURRENT OF c_produto;
        elsif v_produto.categoria = 'C' then
            update produto set preco = 1.15 * preco where CURRENT OF c_produto;
        end if;
    end loop;
end;$$ language plpgsql;



create or replace function bissexto(a1 int, a2 int) 
returns table (ano int) as $$
declare
    a int;
begin
    for a in a1..a2 loop
        if ( mod(a,4) = 0 and mod(a,100) <> 0 or mod(a,400) = 0) then
            return query select a;
        end if;
    end loop;
end;$$ language plpgsql;

select * from bissexto(2000,2100);











create or replace function tabuada(n1 int) returns table (n1 int, n2 int, resultado int) as $$
declare
    i int;
    j int;
begin
for i in 1..9 loop
        for j in 1..9 loop
            return 
            query 
            select i,j,i*j;
        end loop;
    end loop;
end;$$ language plpgsql;

select * from tabuada();

select 1 as c1,2 as c2,3 as c3;

















create or replace function tabuada() returns table (n1 int, n2 int, resultado int) as $$
declare
    v_v1 int;
    v_n2 int;
begin
    for v_n1 in 1..9 loop
        for v_n2 in 1..9 loop
            return query select v_n1, v_n2, v_n1*v_n2;
        end loop;
    end loop;
    return;
end;$$ language plpgsql;

select * from tabuada();

CREATE OR REPLACE FUNCTION spInsertConcert() varchar as $$
declare
    c_concerts for select performerID 
                   from concerts 
                   order by performerID
                   for share;
    r1 record;
    v_performer_ant int;
    v_cont int;
    max_cont int;
    max_performer int;
begin
    max_cont := 0;
    v_performer_ant := 0;
    for r1 in c_concerts loop
        if (r1.performerID <> v_performer_ant) then
            if (v_cont > max_cont) then
                max_cont := v_cont;
                max_performer := v_performer_ant;
            end if;
            v_cont := 0;
        end if;
        v_cont := v_cont + 1;
        v_performer_ant := r1.performerID;
    end loop;

    return select performerName from performers where parformerID = max_performer;
end;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION spInsertConcert(p_performer int, 
                                           p_arena int, 
                                           p_data date, 
                                           p_price double) int as $$
declare
    v_nome=null varchar;
begin
    select performersName
    into v_nome
    from concerts
         natural join performers
    where performer_id = p_performer
          and ConcertDate = p_data
    if found then
       raise exception $$Mensagem: performer % busy$$, p_performer;
    end if; 

    select arenaName
    into v_arena
    from concerts
         natural join arena
    where arena_id = p_arena
          and ConcertDate = p_data

    if found then
       raise exception $$Mensagem: arena % busy$$, p_arena;
    end if; 

    insert into concerts
    (performerID, arena_id, concertDate, ticketPrice)
    value (p_performer , p_arena , p_data , p_price );
    
    return 0;
end;
$$ LANGUAGE plpgsql;




CREATE OR REPLACE FUNCTION verifyPerformer() trigger as $$
declare
    c_activity CURSOR for select activity_id 
                          from Activity;
    r1 record;
    v_count integer;
begin
    if exists (select count(t2.performer_id) 
        from Activity t1 left join Performers t2 on t1.activity_id = t2.activity_id
        group by t1.activity_id
        having count(t2.performer_id)=0) then
        RAISE EXCEPTION $$Erro: ???$$;
    end if;

    for r1 in c_activity loop
        if (select coun(*) 
            from performer 
            where activity_id = r1.activity_id) = 0 then
            raise exception $$ $$
        end if;
    end loop;

end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER deletePerformer  after delete 
ON Performers FOR EACH statement EXECUTE PROCEDURE verifyPerformer();





CREATE TABLE emp_audit (
  operacao,
  usuario,
  data_,
  nome_antigo,
  salario_antigo,
  nome_novo,
  salario_novo,
  );
  
CREATE OR REPLACE FUNCTION empregado_audit() trigger as $$
declare

begin
    if (tg_op = 'insert') then
        insert 
end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigg_emp_audit after INSERT OR UPDATE or delete 
ON empregado FOR EACH ROW EXECUTE PROCEDURE empregado_audit();


CREATE OR REPLACE FUNCTION computeMedianArea(p_country varchar) returns real as $$
declare
  c_province CURSOR (p_key varchar) for 
             select area from province where country = p_key
             order by area;
  v_r1 RECORD;
  v_count int;
  v_metadade int;
  v_i int;
  v_median real;
begin
    select count(*) into v_count from province where country = p_country;
    v_metade = round(v_count::numeric/2.0);
    OPEN c_province(p_country)
    v_i=0;
    v_median = 0;
    LOOP FETCH c_province INTO v_r1;
        if (v_i = v_metade) then
            v_median = v_median + v_r1.area;
        end if;
        if (v_i = v_metade -1 and c_count%2=0) then
            v_median = v_median + v_r1.area;
        end if;
        
        v_i = v_i + 1;
        
        EXIT WHEN NOT FOUND;
        exit when (v_i = v_metade);
        
    END LOOP;
    CLOSE curs;
    if (v_count%2=0) then
        v_median=v_median/2;
    end if;
    return v_median;
end;
$$ LANGUAGE plpgsql;






====================================================================================================================================================================
-- Qestao 5 P220171
DROP table if exists projeto cascade;
CREATE TABLE projeto (
  codigo integer NOT NULL,
  nome character varying NOT NULL,
  CONSTRAINT projeto_pk PRIMARY KEY (codigo));

DROP table if exists grupo_atividade cascade;
CREATE TABLE grupo_atividade (
  numero integer NOT NULL,
  grupo integer,
  projeto integer NOT NULL,
  descricao character varying NOT NULL,
  CONSTRAINT grupo_atividade_pk PRIMARY KEY (numero),
  CONSTRAINT grupo_atividade_fk FOREIGN KEY (grupo) REFERENCES grupo_atividade (numero),
  CONSTRAINT projeto_fk FOREIGN KEY (projeto) REFERENCES projeto (codigo));

DROP table if exists atividade cascade;
CREATE TABLE atividade (
  numero integer NOT NULL,
  grupo integer not null,
  descricao character varying NOT NULL,
  inicio date NOT NULL default current_date,
  fim date NOT NULL default current_date,
  CONSTRAINT atividade_pk PRIMARY KEY (numero),
  CONSTRAINT grupo_atividade_fk FOREIGN KEY (grupo) REFERENCES grupo_atividade (numero));

INSERT INTO projeto (codigo,nome) VALUES (1,'Projeto 1');
INSERT INTO projeto (codigo,nome) VALUES (2,'Projeto 2');
select * from projeto;
INSERT INTO grupo_atividade (numero,grupo,projeto,descricao) VALUES (0,null,1,'grupo 0 projeto 1');
INSERT INTO grupo_atividade (numero,grupo,projeto,descricao) VALUES (1,0,1,'grupo 1 projeto 1');
INSERT INTO grupo_atividade (numero,grupo,projeto,descricao) VALUES (2,0,1,'grupo 2 projeto 1');
INSERT INTO grupo_atividade (numero,grupo,projeto,descricao) VALUES (3,null,2,'grupo 0 projeto 2');
INSERT INTO grupo_atividade (numero,grupo,projeto,descricao) VALUES (4,3,2,'grupo 1 projeto 2');
INSERT INTO grupo_atividade (numero,grupo,projeto,descricao) VALUES (5,3,2,'grupo 2 projeto 2');
select * from grupo_atividade;
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(1,1,'atividade 1','12/4/2017','25/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(2,1,'atividade 2','27/4/2017','30/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(3,2,'atividade 3','13/4/2017','20/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(4,2,'atividade 4','12/4/2017','18/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(5,4,'atividade 5','25/4/2017','25/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(6,4,'atividade 6','27/4/2017','30/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(7,5,'atividade 7','13/4/2017','20/4/2017');
INSERT INTO atividade (numero,grupo,descricao,inicio,fim) values(8,5,'atividade 8','12/4/2017','18/4/2017');
select * from atividade;


DROP FUNCTION IF EXISTS cronograma(p_projeto integer) CASCADE;
CREATE OR REPLACE FUNCTION cronograma(p_projeto integer) RETURNS TABLE(
    grupo integer,
    tipo integer,
	descricao character varying,
	inicio date,
	fim date 
  ) AS $$
DECLARE
BEGIN
    return 
    query
    with
        recursive t1 (grupo,inicio,fim) as (
            select t11.grupo,t11.inicio,t11.fim 
            from atividade t11 inner join grupo_atividade t12 on t11.grupo=t12.numero
            where t12.projeto = p_projeto
            union all 
            select  t13.grupo,t14.inicio,t14.fim
            from grupo_atividade t13 inner join t1 t14 on t13.numero=t14.grupo),
        t2 (grupo,inicio,fim) as (
            select t21.grupo, min(t21.inicio) inicio, max(t21.fim) fim 
            from t1 t21
            group by t21.grupo)
    select t3.numero,1 tipo, t3.descricao, t2.inicio, t2.fim
    from t2 inner join grupo_atividade t3 on t3.numero=t2.grupo
    union all
    select t3.grupo,2 tipo,t3.descricao, t3.inicio, t3.fim
    from atividade t3 inner join grupo_atividade t4 on t3.grupo=t4.numero
    where t4.projeto = p_projeto
    order by 1,2;
END;$$ LANGUAGE plpgsql;

select * from cronograma(1);
====================================================================================================================================================================
-- Qestao 4 P220171
DROP table if exists cliente cascade;
CREATE TABLE cliente (
  cpf integer NOT NULL,
  nome character varying NOT NULL,
  CONSTRAINT cliente_pk PRIMARY KEY (cpf));

DROP table if exists conta cascade;
CREATE TABLE conta (
  agencia integer NOT NULL,
  numero integer NOT NULL,
  cliente integer NOT NULL,
  saldo real NOT NULL default 0,
  CONSTRAINT conta_pk PRIMARY KEY (agencia,numero),
  CONSTRAINT cliente_fk FOREIGN KEY (cliente) REFERENCES cliente (cpf));

DROP table if exists movimentacao cascade;
CREATE TABLE movimentacao (
  agencia integer NOT NULL,
  conta integer NOT NULL,
  data_hora timestamp NOT NULL default current_timestamp,
  valor real NOT NULL,
  descricao character varying NOT NULL,
  CONSTRAINT mov_pk PRIMARY KEY (conta,agencia,data_hora),
  CONSTRAINT conta_fk FOREIGN KEY (agencia,conta) REFERENCES conta (agencia,numero));


DROP FUNCTION IF EXISTS calcular_saldo() CASCADE;
CREATE OR REPLACE FUNCTION calcular_saldo() RETURNS void AS $$
DECLARE
    c_conta CURSOR FOR SELECT * FROM conta FOR UPDATE OF conta;
    c_mov CURSOR (ag integer, cc integer) FOR SELECT * FROM movimentacao WHERE agencia=ag AND conta=cc FOR SHARE OF movimentacao;
    v_saldo real = 0;
    r1 conta%rowtype;
    r2 movimentacao%rowtype;
BEGIN
    FOR r1 IN c_conta LOOP
        v_saldo := 0;
        FOR r2 IN c_mov(r1.agencia,r1.numero) LOOP
            v_saldo := v_saldo + r2.valor;
        END LOOP;
        UPDATE conta SET saldo = v_saldo WHERE CURRENT OF c_conta;
    END LOOP;
END;$$ LANGUAGE plpgsql;

INSERT INTO cliente (cpf,nome) VALUES (123,'Luiz');
select * from cliente;
INSERT INTO conta (agencia,numero,cliente) VALUES (1,2,123);
select * from conta;
INSERT INTO movimentacao (agencia,conta,valor,descricao) values(1,2,10,'desc');
INSERT INTO movimentacao (agencia,conta,valor,descricao) values(1,2,10,'desc');
select * from movimentacao;

DO $$BEGIN PERFORM "calcular_saldo"(); END$$;
select calcular_saldo();
select * from conta;


====================================================================================================================================================================
-- Qestao 4 P220162
drop table if exists emp_audit CASCADE;
CREATE TABLE emp_audit (
  id integer NOT NULL,
  operacao text NOT NULL,
  data_hora timestamp NOT NULL,
  usuario text NOT NULL,
  ssn integer NOT NULL,
  superssn integer NOT NULL,
  pnome text NOT NULL,
  unome text NOT NULL,
  endereco text NOT NULL,
  CONSTRAINT emp_audit_pk PRIMARY KEY (id));

ALTER TABLE emp_audit ENABLE ROW LEVEL SECURITY;

drop policy if exists emp_audit_policy1 on emp_audit;
drop policy if exists emp_audit_policy3 on emp_audit;
drop policy if exists emp_audit_policy4 on emp_audit;
drop policy if exists emp_audit_policy5 on emp_audit;

drop role if exists lapaesleme;
drop role if exists auditores;
CREATE ROLE lapaesleme password 'fluminense' LOGIN INHERIT;
CREATE ROLE auditores;
grant auditores to lapaesleme;
GRANT all ON public.emp_audit TO lapaesleme;


CREATE POLICY emp_audit_policy1 ON emp_audit FOR select
    USING (true);
    
drop policy if exists emp_audit_policy2 on emp_audit;
CREATE POLICY emp_audit_policy2 ON emp_audit FOR insert
    WITH CHECK (false);

CREATE POLICY emp_audit_policy3 ON emp_audit FOR update
    USING (FALSE)
    WITH CHECK (false);

CREATE POLICY emp_audit_policy4 ON emp_audit FOR delete
    USING (FALSE);
        
CREATE POLICY emp_audit_policy5 ON emp_audit TO auditores
    USING (true)
    WITH CHECK (true);

====================================================================================================================================================================
-- Qestao 4 P220162

drop table if exists restaurante CASCADE;
CREATE TABLE restaurante (
  cnpj integer NOT NULL,
  endereco character varying NOT NULL,
  CONSTRAINT rest_pk PRIMARY KEY (cnpj));

drop table if exists prato cascade;
CREATE TABLE prato (
  prato_id integer NOT NULL,
  nome character varying NOT NULL,
  CONSTRAINT prato_pk PRIMARY KEY 
  (prato_id));

drop table if exists menu cascade;
CREATE TABLE menu (
  cnpj integer NOT NULL,
  prato_id integer NOT NULL,
  preco real NOT NULL,
  CONSTRAINT menu_pk PRIMARY KEY 
  (cnpj,prato_id),
  CONSTRAINT menu_rest_fk FOREIGN KEY 
  (cnpj) REFERENCES restaurante (cnpj),
  CONSTRAINT menu_prato_fk FOREIGN KEY 
  (prato_id) REFERENCES prato (prato_id));

drop table if exists pedido cascade;
CREATE TABLE pedido (
  pedido_id integer NOT NULL,
  cnpj integer NOT NULL,
  CONSTRAINT pedido_pk PRIMARY KEY 
  (pedido_id),
  CONSTRAINT pedido_rest_fk FOREIGN KEY 
  (cnpj) REFERENCES restaurante (cnpj));


drop table if exists item_pedido cascade;
CREATE TABLE item_pedido (
  pedido_id integer NOT NULL,
  item integer NOT NULL,
  cnpj integer NOT NULL,
  prato_id integer NOT NULL,
  qtd integer NOT NULL,
  CONSTRAINT item_pk PRIMARY KEY 
  (pedido_id,item),
  CONSTRAINT item_pedido_fk FOREIGN KEY 
  (pedido_id) REFERENCES pedido 
  (pedido_id),
  CONSTRAINT item_menu_fk FOREIGN KEY 
  (cnpj,prato_id) REFERENCES menu 
  (cnpj,prato_id));


DROP FUNCTION IF EXISTS verifica_item() CASCADE;
CREATE OR REPLACE FUNCTION verifica_item() RETURNS trigger AS '
    BEGIN
        IF ((SELECT cnpj FROM pedido WHERE NEW.pedido_id) <> NEW.CPJ) THEN                       
            RAISE EXCEPTION $$Erro: prato % nao oferecido pelo restaurante!$$, NEW.prato_id;
        END IF;

        RETURN NEW;
    END;' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS verifica_item_tgr ON item_pedido;
CREATE TRIGGER verifica_item_tgr BEFORE INSERT OR UPDATE ON item_pedido
    FOR EACH ROW EXECUTE PROCEDURE verifica_item();

DROP FUNCTION IF EXISTS verifica_pedido() CASCADE;
CREATE OR REPLACE FUNCTION verifica_pedido() RETURNS trigger AS '
    BEGIN
        IF (NEW.cnpj <> OLD.cnpj 
            AND EXISTS (SELECT 1 FROM item_pedido WHERE pedido_id = OLD.pedido_id)) THEN
            RAISE EXCEPTION $$Erro: pedido ja possui itens de outro restaurante!$$;
        END IF;

        RETURN NEW;
    END;' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS verifica_pedido_tgr ON pedido cascade;
CREATE TRIGGER verifica_pedido_tgr BEFORE UPDATE ON pedido
    FOR EACH ROW EXECUTE PROCEDURE verifica_pedido();


    
====================================================================================================================================================================
-- Qestao 5 P220162


DROP table if exists movimentacao cascade;
CREATE TABLE movimentacao (
  conta integer NOT NULL,
  agencia integer NOT NULL,
  data_hora timestamp NOT NULL default now(),
  valor real NOT NULL,
  descricao character varying NOT NULL,
  CONSTRAINT movimentacao_pk PRIMARY KEY (conta,agencia,data_hora));


DROP FUNCTION IF EXISTS altera_conta() CASCADE;
CREATE OR REPLACE FUNCTION altera_conta() RETURNS trigger AS '
    BEGIN
        IF (TG_OP = $$DELETE$$) THEN
            INSERT INTO movimentacao (conta,agencia,data_hora,valor,descricao) VALUES (OLD.conta,OLD.agencia,now(),-OLD.valor,OLD.descricao);
            RETURN null;
        ELSIF (TG_OP = $$UPDATE$$) THEN
            IF (NEW.conta <> OLD.conta
                OR NEW.agencia <> OLD.agencia
                OR NEW.data_hora <> OLD.data_hora
                OR NEW.valor <> OLD.valor
                OR NEW.descricao <> OLD.descricao) THEN
              INSERT INTO movimentacao (conta,agencia,data_hora,valor,descricao) VALUES (OLD.conta,OLD.agencia,clock_timestamp(),-OLD.valor,OLD.descricao);
              INSERT INTO movimentacao (conta,agencia,data_hora,valor,descricao) VALUES (NEW.conta,NEW.agencia,clock_timestamp(),NEW.valor,NEW.descricao);
            END IF;
            RETURN null;
        END IF;
    END;' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS altera_conta_tgr ON movimentacao cascade;
CREATE TRIGGER altera_conta_tgr before DELETE OR UPDATE ON movimentacao
    FOR EACH ROW EXECUTE PROCEDURE altera_conta();

====================================================================================================================================================================
-- Qestao 4 VR20162


drop table if exists hotel cascade;
CREATE TABLE hotel (
  numero integer NOT NULL,
  nome TEXT NOT NULL,
  CONSTRAINT hotel_pk PRIMARY KEY 
  (numero));

drop table if exists reserva cascade;
CREATE TABLE reserva (
  numero integer NOT NULL,
  hotel integer NOT NULL,
  cpf_cnpj integer NOT NULL,
  inicio timestamp not null,
  fim timestamp not null,
  CONSTRAINT reserva_pk PRIMARY KEY 
  (numero),
  CONSTRAINT reserva_hotel_fk FOREIGN KEY 
  (hotel) REFERENCES hotel (numero));

drop table if exists estadia cascade;
CREATE TABLE estadia (
  numero integer NOT NULL,
  quarto text not null,
  inicio timestamp not null,
  fim timestamp,
  CONSTRAINT estadia_pk PRIMARY KEY 
  (numero),
  CONSTRAINT estadia_reserva_fk FOREIGN KEY 
  (numero) REFERENCES reserva (numero)
  on delete restrict on update cascade);



DROP FUNCTION IF EXISTS verifica_estadia() CASCADE;
CREATE OR REPLACE FUNCTION verifica_estadia() RETURNS trigger AS '
DECLARE
    v_inicio timestamp;
    v_fim timestamp;
BEGIN
    SELECT inicio, fim INTO v_inicio,v_fim FROM reserva WHERE numero = NEW.numero;
    
    IF (NOT (NEW.inicio BETWEEN v_inicio AND (v_inicio + $$1 day$$::INTERVAL)
             AND (NEW.fim BETWEEN v_inicio AND v_fim OR NEW.fim IS NULL)
             AND NEW.inicio < NEW.fim)) THEN                       
        RAISE EXCEPTION $$Erro: periodo de estadia invalido!$$;
    END IF;

    RETURN NEW;
END;' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS verifica_estadia_tgr ON estadia cascade;
CREATE TRIGGER verifica_estadia_tgr BEFORE INSERT OR UPDATE ON estadia
    FOR EACH ROW EXECUTE PROCEDURE verifica_estadia();

    

DROP FUNCTION IF EXISTS verifica_reserva() CASCADE;
CREATE OR REPLACE FUNCTION verifica_reserva() RETURNS trigger AS '
DECLARE
    v_inicio timestamp;
    v_fim timestamp;
BEGIN
    SELECT inicio, fim INTO v_inicio,v_fim FROM estadia WHERE numero = OLD.numero;
    
    IF (NOT (FOUND
             AND (v_inicio BETWEEN NEW.inicio AND (NEW.inicio + $$1 day$$::INTERVAL))
             AND (v_fim BETWEEN NEW.inicio AND NEW.fim OR v_fim IS NULL)
             AND NEW.inicio < NEW.fim)) THEN
        RAISE EXCEPTION $$Erro: periodo de estadia incompativel com reserva!$$;
    END IF;

    RETURN NEW;
END;' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS verifica_reserva_tgr ON reserva cascade;
CREATE TRIGGER verifica_reserva_tgr BEFORE UPDATE ON reserva
    FOR EACH ROW EXECUTE PROCEDURE verifica_reserva();
====================================================================================================================================================================
-- Qestao 5 VR20162


drop table if exists campeonato cascade;
CREATE TABLE campeonato (
  codigo text NOT NULL,
  nome TEXT NOT NULL,
  ano integer not null,
  CONSTRAINT campeonato_pk PRIMARY KEY 
  (codigo));

drop table if exists time_ cascade;
CREATE TABLE time_ (
  sigla text NOT NULL,
  nome TEXT NOT NULL,
  CONSTRAINT time_pk PRIMARY KEY 
  (sigla));
  
drop table if exists jogo cascade;
CREATE TABLE jogo (
  campeonato text not null,
  numero integer NOT NULL,
  time1 text NOT NULL,
  time2 text NOT NULL,
  gols1 integer not null,
  gols2 integer not null,
  data_ date not null,
  CONSTRAINT jogo_pk PRIMARY KEY 
  (campeonato,numero),
  CONSTRAINT jogo_campeonato_fk FOREIGN KEY 
  (campeonato) REFERENCES campeonato (codigo),
  CONSTRAINT jogo_time_fk1 FOREIGN KEY 
  (time1) REFERENCES time_ (sigla),
  CONSTRAINT jogo_time_fk2 FOREIGN KEY 
  (time2) REFERENCES time_ (sigla));

DROP FUNCTION IF EXISTS pontuacao(text,integer,integer);
CREATE OR REPLACE FUNCTION pontuacao(p_campeonato text, p_pos1 integer, p_pos2 integer)
    RETURNS table (
    campeonato text,
    time_ text,
    pontos smallint,
    vitorias smallint,
    posicao smallint) AS '
DECLARE
BEGIN
    RETURN
    QUERY
    WITH
        pontos(c,j,t,p) as (select campeonato,numero,time1,3 
                            from jogo where gols1 > gols2 AND campeonato = p_campeonato
                            union select campeonato,numero,time2,3 
                            from jogo where gols2 > gols1 AND campeonato = p_campeonato
                            union select campeonato,numero,time1,1 
                            from jogo where gols1 = gols2 AND campeonato = p_campeonato
                            union select campeonato,numero,time2,1 
                            from jogo where gols1 = gols2 AND campeonato = p_campeonato),
        vitorias(c,t,v) as (select campeonato,time1,1 
                            from jogo where gols1 > gols2 AND campeonato = p_campeonato
                            union select campeonato,time2,1 
                            from jogo where gols2 > gols1 AND campeonato = p_campeonato),
        pontuacao(c,t,tp) as (select c,t,sum(p) as pontos 
                              from pontos group by c,t),
        saldo(c,t,tv) as (select c,t,sum(v) as t 
                          from vitorias group by c,t)
    select p.c,t.nome,p.tp,s.tv
    from pontuacao as p 
         natural join saldo as s
         inner join time_ as t on t.sigla = p.t
    order by p.tp desc, s.tv desc
    limit p_pos2 - p_pos2 +1 offset p_pos1;

    return;
END;' LANGUAGE plpgsql



====================================================================================================================================================================
-- Qestao 2 VS20162
drop table if exists empregado cascade;
CREATE TABLE empregado (
    nome    text NOT NULL,
    salario real,
    CONSTRAINT empregado_pk PRIMARY KEY 
    (nome)
);

drop table if exists empregado_audit cascade;
CREATE TABLE empregado_audit(
    operation      char(1) NOT NULL,
    data_hora      timestamp NOT NULL,
    userid         text NOT NULL,
    nome_antigo    text,
    salario_antigo real,
    nome_novo      text,
    salario_novo   real
);

DROP FUNCTION IF EXISTS audit_empregado() CASCADE;
CREATE OR REPLACE FUNCTION audit_empregado() RETURNS TRIGGER AS $$
    BEGIN
        --
        -- Create a row in emp_audit to reflect the operation performed on emp,
        -- make use of the special variable TG_OP to work out the operation.
        --
        IF (TG_OP = 'DELETE') THEN
            INSERT INTO empregado_audit SELECT 'D', now(), user, OLD.*;
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE') THEN
            INSERT INTO empregado_audit SELECT 'U', now(), user, OLD.*, NEW.*;
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            INSERT INTO empregado_audit SELECT 'I', now(), user, null, null, NEW.*;
            RETURN NEW;
        END IF;
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
$$ LANGUAGE plpgsql;


DROP TRIGGER IF EXISTS audit_empregado_tgr ON empregado cascade;
CREATE TRIGGER audit_empregado_tgr BEFORE INSERT OR UPDATE OR DELETE ON empregado
    FOR EACH ROW EXECUTE PROCEDURE audit_empregado();

====================================================================================================================================================================
-- Qestao 1 VS20162
drop table if exists empregado_audit cascade;
CREATE TABLE country(
  code TEXT NOT NULL,
  "name" TEXT NOT NULL, 
  capital TEXT NOT NULL,
  population TEXT NOT NULL,
  CONSTRAINT country_pk PRIMARY KEY 
  (code)
)

drop table if exists empregado_audit cascade;
CREATE TABLE province(
  "name" TEXT NOT NULL,
  country TEXT NOT NULL,
  area REAL NOT NULL,
  population INTEGER NOT NULL,
  capital TEXT NOT NULL,
  CONSTRAINT province_pk PRIMARY KEY 
  ("name"),
  CONSTRAINT province_country_fk FOREIGN 
  KEY (country) REFERENCES country (code)
) 


CREATE OR REPLACE FUNCTION computeMedianArea(p_country VARCHAR) RETURNS NUMERIC AS $$ 
DECLARE
    r1 RECORD;
    r2 RECORD;
    count INT;
    i INT;
    median NUMERIC;
    curs CURSOR FOR SELECT province.area 
                    FROM country JOIN province
                    ON country.code = province.country
                    WHERE country.name = p_country 
                    ORDER BY province.area;
BEGIN
    i := 0;
    median := 0;
    IF p_country IS NOT NULL THEN
        SELECT COUNT(DISTINCT p.name) 
        INTO count
        FROM country c JOIN province p ON c.code = p.country
        WHERE c.name = p_country;
        OPEN curs;
        LOOP FETCH curs INTO r1;
            EXIT WHEN NOT FOUND;
            i := i + 1;
            IF i = ROUND(count::numeric/2) THEN
                IF count%2 = 0 THEN 
                    FETCH curs into r2;
                    median = (r1.area + r2.area)/2;
                ELSE
                    median = r1.area; 
                END IF;
            END IF; 
        END LOOP;
        CLOSE curs;
    END IF;
    RETURN median;
END; $$ LANGUAGE PLPGSQL;

====================================================================================================================================================================
-- TESTES


    WITH
        pontos(c,j,t,p) as (select campeonato,numero,time1,3 
                            from jogo where gols1 > gols2 AND campeonato = p_campeonato
                            union select campeonato,numero,time2,3 
                            from jogo where gols2 > gols1 AND campeonato = p_campeonato
                            union select campeonato,numero,time1,1 
                            from jogo where gols1 = gols2 AND campeonato = p_campeonato
                            union select campeonato,numero,time2,1 
                            from jogo where gols1 = gols2 AND campeonato = p_campeonato),
        vitorias(c,t,v) as (select campeonato,time1,1 
                            from jogo where gols1 > gols2 AND campeonato = p_campeonato
                            union select campeonato,time2,1 
                            from jogo where gols2 > gols1 AND campeonato = p_campeonato),
        pontuacao(c,t,tp) as (select c,t,sum(p) as pontos 
                              from pontos group by c,t),
        saldo(c,t,tv) as (select c,t,sum(v) as t 
                          from vitorias group by c,t)
    select p.c,p.t,p.tp,s.tv
    from pontuacao as p natural join saldo as s
    order by p.tp desc, s.tv desc
    limit p_pos2 - p_pos2 +1 offset p_pos1;



do
$$
DECLARE 
    v_numero integer;
BEGIN
    select 1 into v_numero;
    if found then
        raise notice 'ok';
    end if;
END;
$$

select NULL + $$1 day$$::INTERVAL;
select * from reserva;

drop table if exists public.bairro cascade;
CREATE TABLE public.bairro
(
  bairro_id integer NOT NULL,
  nome character varying NOT NULL,
  "user" text,
  CONSTRAINT bairro_pk PRIMARY KEY (bairro_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.bairro
  OWNER TO postgres;

GRANT ALL privileges ON TABLE public.bairro TO PUBLIC;
GRANT ALL privileges ON TABLE public.bairro TO postgres;


CREATE TABLE vendas (
  regiao integer NOT NULL,
  departamento integer NOT NULL,
  valor integer NOT NULL,
  unome character varying NOT NULL,
  endereco character varying NOT NULL,
  CONSTRAINT empregado_pk PRIMARY KEY (ssn),
  CONSTRAINT supervisor_fk FOREIGN KEY (superssn) REFERENCES empregado (ssn));




