drop table if exists produto cascade;
create table produto(
    codigo int not null,
    nome varchar not null,
    preco float not null,
    primary key (codigo)
    );
insert into produto(codigo,nome,preco) values(1,'p1',100.0);
    
drop function if exists update_preco();
create or replace function update_preco() returns void as $$
declare
    r produto%rowtype;
begin
    for r in select * from produto loop
        update produto set preco = preco * 1.1 where codigo = r.codigo;
    end loop;
end;$$ language plpgsql;

select update_preco();
select * from produto;