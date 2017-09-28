create or replace function fatorial(x numeric) returns numeric as $$
declare
    
begin
    if (x = 0) then
    	return 1;
    else
    	return x * fatorial(x-1);
    end if;
end;$$ language plpgsql;

select fatorial(80::numeric(300));