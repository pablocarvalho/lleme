drop function if exists inscricao();
create or replace function inscricao() 
returns table(c1 integer, c2 integer, c3 integer) as $$
declare
    v_a1 integer[3][3];
    v_a2 integer[3][3];
    x integer[];
    y integer;
    r integer[3][3];
    i integer = 1;
    j integer = 1;
begin
    select '{{1,2,3},{1,4,2},{7,8,2}}' into v_a1;
    select '{{3,1,4},{3,4,1},{2,8,2}}' into v_a2;
    select '{{0,0,0},{0,0,0},{0,0,0}}' into r;
    foreach x slice 1 in array v_a1 loop
        raise notice 'i=%',i;
        raise notice 'x=%',x;
        j = 1;
        foreach y in array x loop
            raise notice 'j=%',j;
            raise notice 'y=%',y;
            r[i][j] = v_a1[i][j] + v_a2[i][j];
            j = j + 1;
        end loop;
        return query select r[i][1], r[i][2], r[i][3];
        i = i + 1;
    end loop;    
end;$$ language plpgsql;

select * from inscricao();



select t1.f1[1][1:2] from (SELECT '{{1,2,3},{4,5,6}}'::int[] AS f1) t1

create table tabela(
c1 integer,
c2 integer,
c3 integer
);

insert into tabela values (1,1,1);
insert into tabela values (2,2,2);
insert into tabela values (3,3,3);
insert into tabela values (4,4,4);

select array_agg (array(select c1 union all select c2 union all select c3))
from tabela;

CREATE TABLE tictactoe (
    squares   integer[3][3]
);

pay_by_quarter  integer ARRAY[4],

pay_by_quarter  integer ARRAY,

pay_by_quarter = '{{1,2,3},{4,5,6},{7,8,9}}'

INSERT INTO sal_emp
    VALUES ('Bill',
    '{10000, 10000, 10000, 10000}',
    '{{"meeting", "lunch"}, {"training", "presentation"}}');

INSERT INTO sal_emp
    VALUES ('Carol',
    '{20000, 25000, 25000, 25000}',
    '{{"breakfast", "consulting"}, {"meeting", "lunch"}}');



