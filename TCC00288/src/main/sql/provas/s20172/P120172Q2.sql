drop function if exists fibonacci(int);
create or replace function fibonacci(n int)
returns table(i int, numero bigint) as $$
declare
    f1 bigint = 0;
    f2 bigint = 1;
    fn bigint;
    i int;
begin
    for i in 1..n loop
        fn = f1 + f2;
        return query select i,fn;
        f2 = f1;
        f1 = fn;
    end loop;
end;$$ language plpgsql;

select * from fibonacci(4);