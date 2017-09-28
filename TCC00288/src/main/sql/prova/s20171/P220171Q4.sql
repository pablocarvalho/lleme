drop function if exists multiplicar(float[][],float[][]);
create or replace function multiplicar(ma float[][], mb float[][]) returns float[][] as $$
declare
    i int;
    j int;
    ma_linhas int;
    ma_colunas int;
    mb_linhas int;
    mb_colunas int;
    celula float;
    linha float[];
    resultado float[][];
begin
    ma_linhas = array_length(ma,1);
    ma_colunas = array_length(ma,2);

    mb_linhas = array_length(mb,1);
    mb_colunas = array_length(mb,2);

    if (ma_colunas <> mb_linhas) then
        raise exception 'matrizes inconpativeis';
    end if;

    resultado='{}';
    for i in 1..ma_linhas loop
        linha = '{}';
        for j in 1..mb_colunas loop
            celula = 0;
            for kk in 1..ma_colunas loop
                celula = celula + ma[i][kk]*mb[kk][j];
            end loop;
            linha = array_append(linha,celula);
        end loop;
        resultado = array_cat(resultado,array[linha]);
    end loop;

    return resultado;
end;$$ language plpgsql;


select multiplicar('{{1,2},{3,4},{5,6}}','{{1,2,3},{4,5,6}}');
