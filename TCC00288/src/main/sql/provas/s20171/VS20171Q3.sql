drop function if exists fibonacci(integer);
create or replace function fibonacci(n integer) 
returns table(i integer, t integer) as $$
declare
    v_a integer := 1;
    v_b integer := 1;
    v_c integer := 0;
    i integer;
begin
    for i in 1..n loop
        if i = 1 then
            return query select i,v_a;
        elsif i = 2 then
            return query select i,v_b;
        else
            v_c := v_a + v_b;
            return query select i,v_c;
            v_a := v_b;
            v_b := v_c;
        end if;
    end loop;
end; $$ language plpgsql;

select * from fibonacci(4);
