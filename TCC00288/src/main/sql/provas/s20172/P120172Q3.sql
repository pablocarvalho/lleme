drop table if exists disciplina cascade;
create table disciplina(
    cod int not null,
    nome varchar not null,
    primary key (cod));
insert into disciplina(cod,nome) values(1,'bd');
insert into disciplina(cod,nome) values(2,'prog');

drop table if exists turma cascade;
create table turma(
    disciplina int not null,
    semestre int not null,
    sigla char(2) not null,
    qtd_notas int not null default 2,
    primary key (disciplina,semestre,sigla),
    foreign key (disciplina) references disciplina(cod)
    );
insert into turma(disciplina,semestre,sigla,qtd_notas) values (1,20171,'A1',2);
insert into turma(disciplina,semestre,sigla,qtd_notas) values (1,20171,'B1',2);
insert into turma(disciplina,semestre,sigla,qtd_notas) values (2,20171,'A1',3);
insert into turma(disciplina,semestre,sigla,qtd_notas) values (1,20172,'A1',2);
insert into turma(disciplina,semestre,sigla,qtd_notas) values (1,20172,'B1',2);
insert into turma(disciplina,semestre,sigla,qtd_notas) values (2,20172,'A1',2);

drop table if exists aluno cascade;
create table aluno(
    matricula int not null,
    nome varchar not null,
    primary key (matricula)
    );
insert into aluno(matricula,nome) values(1,'Aluno 1');
insert into aluno(matricula,nome) values(2,'Aluno 2');
insert into aluno(matricula,nome) values(3,'Aluno 3');
insert into aluno(matricula,nome) values(4,'Aluno 4');

drop table if exists inscricao cascade;
create table inscricao(
    disciplina int not null,
    semestre int not null,
    turma char(2) not null,
    aluno int not null,
    primary key(disciplina,semestre,aluno),
    foreign key (disciplina,semestre,turma) references turma(disciplina,semestre,sigla),
    foreign key (aluno) references aluno(matricula)
    );

insert into inscricao(disciplina,semestre,turma,aluno) values (1,20171,'A1',1);
insert into inscricao(disciplina,semestre,turma,aluno) values (1,20171,'A1',2);
insert into inscricao(disciplina,semestre,turma,aluno) values (1,20171,'A1',3);
insert into inscricao(disciplina,semestre,turma,aluno) values (1,20171,'A1',4);

insert into inscricao(disciplina,semestre,turma,aluno) values (2,20171,'A1',1);
insert into inscricao(disciplina,semestre,turma,aluno) values (2,20171,'A1',2);
insert into inscricao(disciplina,semestre,turma,aluno) values (2,20171,'A1',3);
insert into inscricao(disciplina,semestre,turma,aluno) values (2,20171,'A1',4);

insert into inscricao(disciplina,semestre,turma,aluno) values (1,20172,'A1',1);
insert into inscricao(disciplina,semestre,turma,aluno) values (1,20172,'A1',2);
insert into inscricao(disciplina,semestre,turma,aluno) values (1,20172,'A1',3);
insert into inscricao(disciplina,semestre,turma,aluno) values (1,20172,'A1',4);

insert into inscricao(disciplina,semestre,turma,aluno) values (2,20172,'A1',1);
insert into inscricao(disciplina,semestre,turma,aluno) values (2,20172,'A1',2);
insert into inscricao(disciplina,semestre,turma,aluno) values (2,20172,'A1',3);
insert into inscricao(disciplina,semestre,turma,aluno) values (2,20172,'A1',4);


drop table if exists nota cascade;
create table nota(
    disciplina int not null,
    semestre int not null,
    aluno int not null,
    seq int not null,
    nota float not null,
    primary key(disciplina,semestre,aluno,seq),
    foreign key (disciplina,semestre,aluno) references inscricao (disciplina,semestre,aluno),
    foreign key (aluno) references aluno(matricula)
    );
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,1,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,2,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,3,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,4,1,9.5);

insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,1,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,2,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,3,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,4,1,9.5);

insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,1,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,2,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,3,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,4,1,9.5);

insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,1,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,2,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,3,1,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,4,1,9.5);
---------
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,1,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,2,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,3,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20171,4,2,9.5);

insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,1,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,2,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,3,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20171,4,2,9.5);

insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,1,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,2,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,3,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (1,20172,4,2,9.5);

insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,1,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,2,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,3,2,9.5);
insert into nota(disciplina,semestre,aluno,seq,nota) values (2,20172,4,2,9.5);

drop function if exists notas();
create or replace function notas()
returns table(
    disciplina varchar, semestre int, aluno varchar,
    n1 float, n2 float, n3 float, n4 float, media float) as $$
declare
    v_qtd_notas int; v_notas float[]; v_media float; i int;
    r1 record;
    c_inscricao cursor for 
                select 
                    t1.disciplina as cod, t1.aluno as mat,
                    t2.nome as disciplina,t1.semestre,t3.nome as aluno
                from inscricao t1 
                     inner join disciplina t2 on t1.disciplina = t2.cod
                     inner join aluno t3 on t1.aluno = t3.matricula;
begin
    for r1 in c_inscricao loop
        select t1.qtd_notas 
        into v_qtd_notas 
        from turma t1 
        where t1.disciplina=r1.cod and t1.semestre=r1.semestre;
        
        select array_agg(n.nota)
        into v_notas 
        from nota n 
        where n.disciplina = r1.cod 
               and n.semestre = r1.semestre
               and n.aluno = r1.mat;
        v_notas = array_cat(v_notas,'{0,0,0,0}');
        
        v_media = 0;
        for i in 1..v_qtd_notas loop
            v_media = v_media + v_notas[i];
        end loop;
        v_media = v_media / v_qtd_notas;
        
        return query 
        select r1.disciplina, r1.semestre, r1.aluno
                , v_notas[1], v_notas[2], v_notas[3], v_notas[4], v_media;
    end loop;
    return;
end;$$ language plpgsql;

select * from notas();

