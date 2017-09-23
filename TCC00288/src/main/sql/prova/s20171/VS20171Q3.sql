create or replace function fibonacci(n int) returns setof int as $$
declare
    v_a int := 1;
    v_b int := 1;
    v_c int := 0;
    i int;
begin
    for i in 1..n loop
        if i = 1 then
            return next v_a;
        elsif i = 2 then
            return next v_b;
        else
            v_c := v_a + v_b;
            return next v_c;
            v_a := v_b;
            v_b := v_c;
        end if;
    end loop;
end; $$ language plpgsql;
