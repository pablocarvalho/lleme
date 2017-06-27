drop function if exists transpor(float[][]);
create or replace function transpor(matriz float[][]) returns float[][] as $$
declare
    i int;
    j int;
    linhas int;
    colunas int;
    linha float[];
    resultado float[][];
begin
    linhas = array_length(matriz,1);
    colunas = array_length(matriz,2);

    resultado='{}';
    for j in 1..colunas loop
        linha = '{}';
        for i in 1..linhas loop
            linha = array_append(linha,matriz[i][j]);
        end loop;
        resultado = array_cat(resultado,array[linha]);
    end loop;

    return resultado;
end;$$ language plpgsql;
