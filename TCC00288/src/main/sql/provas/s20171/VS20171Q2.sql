create or replace function calcularAreaMediana (p_country varchar) returns numeric as $$
    declare
        r1 record;
        r2 record;
        count int;
        i int;
        median numeric;
        curs cursor for select province.area
                        from country join province
                        on country.code = province.country
                        where country.name = p_country
                        order by province.area;
    begin
        i := 0;
        median := 0;
        if p_country is not null then
            select count(distinct p.name)
            into count
            from country c join province p on c.code = p.country
            where c.name = p_country;
            open curs;
            loop fetch curs into r1;
                exit when not found;
                i := i + 1;
                if i = round(count::numeric/2) then
                    if count%2 = 0 then
                        fetch curs into r2;
                        median = (r1.area + r2.area)/2;
                    else
                        median = r1.area;
                    end if;
                end if;
            end loop;
            close curs;
        end if;
        return median;
    end; $$ language plpgsql;
