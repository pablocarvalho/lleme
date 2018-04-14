create or replace function determinante(matriz float[][]) 
returns float as $$
declare
    determinante float;
    linha float[];
    linhas int;
    colunas int;
    i int;
begin
    linhas = array_length(matriz,1);
    colunas = array_length(matriz,2);
    if (linhas <> colunas or linhas = 0) then
        raise exception 'Erro: matriz invalida!';
    end if;
    determinante = 0;
    if (linhas = 1) then
        return matriz[1][1];
    else
        i = 1;
        for j in 1..colunas loop
            determinante = determinante + matriz[i][j] * (-1)^(i+j) * determinante(cofatora(matriz,i,j));
        end loop;
    end if;
    return determinante;
end;$$ language plpgsql;

select determinante('{{1,2,3},{4,8,6},{7,8,9}}');

