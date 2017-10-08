drop table if exists tabela;
create table tabela(
chave bigint,
x bigint,
y bigint,
primary key (chave));

insert into tabela values(1,10,20);
select * from tabela;