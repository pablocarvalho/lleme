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

    

    
end;$$ language plpgsql;

