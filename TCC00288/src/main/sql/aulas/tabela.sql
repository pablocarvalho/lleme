drop table if exists tabela;
create table tabela(
chave char,
x bigint,
y bigint,
valor bigint,
primary key (chave));

insert into tabela values('x',10,20,1000);
select * from tabela;