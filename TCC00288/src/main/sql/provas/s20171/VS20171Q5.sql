CREATE OR REPLACE FUNCTION verificarArtista() returns trigger as $$
declare

begin
    if exists (select count(t2.id)
               from atividade t1 left join artista t2 on t1.id = t2.id
               group by t1.id
               having count(t2.id)=0) then
        RAISE EXCEPTION 'Erro';
    end if;
end;
$$ LANGUAGE plpgsql;

CREATE TRIGGER triggerVerificarArtista after delete
ON artista FOR EACH statement EXECUTE PROCEDURE verificarArtista();
