CREATE OR REPLACE FUNCTION atualiza_nota() RETURNS TRIGGER AS 
$body$
DECLARE
	id_alterar integer;
	media float;
BEGIN
	
	-- Se for delete tem que atualizar o filme com id antigo,
	--se for insert ou update (alteração de id será tratada depois) deve atualizar o novo id 
	IF (TG_OP = 'DELETE') THEN
		id_alterar = OLD.id_filme;
	ELSE
		id_alterar = NEW.id_filme;
	END IF;
	
	SELECT AVG(nota) INTO media
	FROM imdb.critica c
	WHERE c.id_filme = id_alterar
	GROUP BY c.id_filme;	

	-- Atualiza nota de acordo com operação
	UPDATE imdb.filme f
	SET nota = media  	
	WHERE f.id_assunto = id_alterar;

	-- Se for Update e mudar o id de algum filme deve atualizar a nota do antigo também 
	IF (TG_OP = 'UPDATE' AND old.id_filme <> new.id_filme) THEN 
		
		SELECT AVG(nota) INTO media
		FROM imdb.critica c
		WHERE c.id_filme = old.id_filme 
		GROUP BY (c.id_filme);
		
		UPDATE imdb.filme f
		SET nota = media
		WHERE f.id_assunto = old.id_filme;

		
	END IF	;
	RETURN NEW;

END;
$body$ LANGUAGE plpgsql;

CREATE TRIGGER atualiza_notatrig AFTER INSERT OR UPDATE OR DELETE ON imdb.critica 
	FOR EACH ROW EXECUTE PROCEDURE atualiza_nota();

	
	 


	