drop table if exists venda;
create table venda(
    ano_mes int not null,
    unidade int,
    vendedor int,
    produto int,
    valor float
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

drop function if exists projecao(int);
create or replace function projecao(p_ano_mes int) returns table(produto int, previsao float) as $$
declare
    x float[][];
    xl float[][];
    r float[][];
    c1 float[][];
    c2 float[][];
    coef float[];
    prod int;
begin

    for prod in select distinct t1.produto from venda t1 loop
        with
            t1 as (select t1.ano_mes, sum(t1.valor) as valor from venda t1 group by t1.ano_mes, t1.produto)
            select array_agg(array[t1.ano_mes,1]),
                   transpor(array_agg(array[t1.ano_mes,1])),
                   transpor(array[array_agg(t1.valor)]) into x,xl,r from t1 ;
        c1 = multiplicar(xl,x);
        c2 = multiplicar(xl,r);
        coef = resolver(c1,c2);
        return next prod, coef[1] * p_ano_mes + coef[2];
    end loop;

end$$ language plpgsql;

select projecao(201704);

