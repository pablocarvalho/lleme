create or replace function cofatora(matriz float[][], i int, j int) 
returns float[][] as $$
declare
    cofatora float[][];
    linha float[];
    linhas int;
    colunas int;
    k int;
    l int;
begin
    linhas = array_length(matriz,1);
    colunas = array_length(matriz,2);
    cofatora = '{}';
    for k in 1..linhas loop
        linha = '{}';
        if (k <> i) then
            for l in 1..colunas loop
                if (l <> j) then
                    linha = array_append(linha,matriz[k][l]);
                end if;
            end loop;
            cofatora = array_cat(cofatora,array[linha]);
        end if;
    end loop;
    return cofatora;
end;$$ language plpgsql;

select cofatora('{{1,2,3},{4,5,6},{7,8,9}}',2,2);
