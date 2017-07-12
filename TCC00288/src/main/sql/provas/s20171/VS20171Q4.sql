create or replace function incluirConcerto(p_artista int, p_arena int, p_data date, p_preco float) returns int as $$
declare
begin
    if exists(select arenaname
              from concerto t1
                   inner join arena t2 on t1.arena = t2.id
              where t1."data" = p_data) then
       raise exception 'erro: arena % ocupada', p_arena;
    end if;

    if exists(select arenaname
              from concerto t1
                   inner join artista t2 on t1.artista = t2.id
                   inner join arena t3 on t1.arena = t3.id
              where concertdate = p_data) then
       raise exception 'erro: artista % ocupada', p_artista;
    end if;


    insert into concerts
    (performerid, arena_id, concertdate, ticketprice)
    values (p_performer , p_arena , p_data , p_price );

    return 0;
end;
$$ language plpgsql;
