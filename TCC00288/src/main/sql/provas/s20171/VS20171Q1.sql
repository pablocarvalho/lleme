create or replace function reajuste() returns void as $$
declare
    cursor c_produto is select * from produto;
    v_produto produto%rowtype;
begin
    for v_produto in c_produto loop
        if v_produto.categoria = 'a' then
            update produto set valor = valor * 1.05 where codigo = v_produto.codigo;
        elsif v_produto.categoria = 'b' then
            update produto set valor = valor * 1.10 where codigo = v_produto.codigo;
        else
            update produto set valor = valor * 1.15 where codigo = v_produto.codigo;
        end if;
    end loop;
end;
$$ language plpgsql;
