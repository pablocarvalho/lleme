CREATE OR REPLACE FUNCTION atualiza_usu() RETURNS TRIGGER AS 
$$
BEGIN
	IF (TG_OP = 'INSERT' OR (tg_op = 'UPDATE' AND OLD.id_usuario <> NEW.id_usuario)) THEN
		UPDATE imdb.usuario u
		SET contribuicoes = contribuicoes + 1
		WHERE id = NEW.id_usuario;
	END IF;
	
	IF (tg_op = 'DELETE' OR (tg_op = 'UPDATE' AND OLD.id_usuario <> NEW.id_usuario)) THEN
		UPDATE imdb.usuario u
		SET contribuicoes = contribuicoes - 1
		WHERE id = OLD.id_usuario;
	END IF;
	RETURN NEW;

END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER atualiza_usuCritTrig AFTER INSERT OR UPDATE OR DELETE ON imdb.critica
	FOR EACH ROW EXECUTE PROCEDURE atualiza_usu();

CREATE TRIGGER atualiza_usuNotTrig AFTER INSERT OR UPDATE OR DELETE ON imdb.noticia
	FOR EACH ROW EXECUTE PROCEDURE atualiza_usu();


	
