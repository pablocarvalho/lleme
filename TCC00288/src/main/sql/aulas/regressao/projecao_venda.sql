drop table if exists venda cascade ;
create table venda(
    ano_mes int not null,
    unidade int,
    vendedor int,
    produto int,
    valor double precision
);

insert into venda values(201701,1,1,10,100.0);
insert into venda values(201701,1,2,10,200.0);
insert into venda values(201701,1,3,10,300.0);
insert into venda values(201702,1,1,10,200.0);
insert into venda values(201702,1,2,10,300.0);
insert into venda values(201702,1,3,10,500.0);
insert into venda values(201703,1,1,10,800.0);
insert into venda values(201703,1,2,10,200.0);
insert into venda values(201703,1,3,10,500.0);
insert into venda values(201704,1,1,10,200.0);
insert into venda values(201704,1,2,10,100.0);
insert into venda values(201704,1,3,10,500.0);
insert into venda values(201705,1,1,10,500.0);
insert into venda values(201705,1,2,10,300.0);
insert into venda values(201705,1,3,10,700.0);
insert into venda values(201706,1,1,10,200.0);
insert into venda values(201706,1,2,10,200.0);
insert into venda values(201706,1,3,10,200.0);



drop function if exists transpor(double precision[][]);
create or replace function transpor(matriz double precision[][]) 
returns double precision[][] as $$
declare
    i int;
    j int;
    linha double precision[];
    transposta double precision[][];
begin

	transposta='{}';
    for j in 1..array_length(matriz,2) loop
        linha = '{}';
        for i in 1..array_length(matriz,1) loop
            linha = array_append(linha,matriz[i][j]);
        end loop;
        transposta = array_cat(transposta,array[linha]);
    end loop;

    return transposta;
end;$$ language plpgsql;



drop function if exists multiplicar(double precision[][],double precision[][]);
create or replace function multiplicar(ma double precision[][], mb double precision[][]) 
returns double precision[][] as $$
declare
    i int;
    j int;
    celula double precision;
    linha double precision[];
    produto double precision[][];
begin

    if (array_length(ma,2) <> array_length(mb,1)) then
        raise exception 'matrizes inconpativeis';
    end if;

    produto='{}';
    for i in 1..array_length(ma,1) loop
        linha = '{}';
        for j in 1..array_length(mb,2) loop
            celula = 0.;
            for kk in 1..array_length(ma,2) loop
                celula = celula + ma[i][kk]*mb[kk][j];
            end loop;
            linha = array_append(linha,celula);
        end loop;
        produto = array_cat(produto,array[linha]);
    end loop;

    return produto;
end;$$ language plpgsql;


drop function if exists resolver(double precision[][], double precision[][]);
create or replace function resolver(m1 double precision[][], m2 double precision[][]) 
returns double precision[] as $$
declare
    sol double precision[] = '{0.,0.}';
begin
	raise notice 'm1 = %,  m2 = %', m1, m2;
    sol[1]=(m2[1][1]*m1[2][2]-m1[1][2]*m2[2][1])/(m1[1][1]*m1[2][2]-m1[1][2]*m1[2][1]);
    sol[2]=(m1[1][1]*m2[2][1]-m2[1][1]*m1[2][1])/(m1[1][1]*m1[2][2]-m1[1][2]*m1[2][1]);
	raise notice 'coefs = %', sol;
    return sol;
end;$$ language plpgsql;



drop function if exists projecao(int, int);
create or replace function projecao(p_anomes int, p_produto int) 
returns double precision as $$
declare
    x double precision[][];
    xt double precision[][];
    r double precision[][];
    coef double precision[];
begin
    execute 'with
        t1 as (select ano_mes, sum(valor) as valor 
               from venda 
               where produto=$1
               group by ano_mes)
    select 
        array_agg(array[t1.ano_mes,1.0]),
        transpor(array_agg(array[t1.ano_mes,1.0])),
        transpor(array[array_agg(t1.valor)]) 
    from t1'
	into x,xt,r
	using p_produto;
	raise notice 'x = %, xt = %, r = %', x, xt, r;
        
    coef = resolver(multiplicar(xt,x),multiplicar(xt,r));
    return coef[1] * p_anomes + coef[2];
end;$$ language plpgsql;

select projecao(201707,10);

