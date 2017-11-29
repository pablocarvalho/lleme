CREATE OR REPLACE FUNCTION checa_data() RETURNS TRIGGER AS 
$$
DECLARE
	lancamento timestamp;
BEGIN
	-- Verifica se o usuário cuja critica foi inserida ou sofreu alteração não é usuário padrão
	IF EXISTS (SELECT *
		   FROM imdb.usuario u INNER JOIN imdb.tipo_usuario t ON u.tipo = t.id
	           WHERE u.id = NEW.id AND t.nome <> 'Padrão') THEN
	RETURN NEW;

	-- Caso seja padrão, é necessário checar a data da crítica em relação a estreia do filme
	ELSE	
		SELECT (f.dataEstreia) INTO lancamento
		FROM imdb.filme f
		WHERE f.id_assunto = NEW.id_Filme;
		
		-- Se a crítica é de antes da estreia do filme e usuário é padrão, não pode alterar
		IF (now() < lancamento) THEN
			RAISE EXCEPTION 'Usuário padrão só pode possuir crítica dom data após estréia do filme';
		ELSE 
			RETURN NEW;
		END IF;
	END IF;
END;
$$ LANGUAGE plpgsql;
				

CREATE TRIGGER checa_dataTrig BEFORE INSERT OR UPDATE ON imdb.critica 
	FOR EACH ROW EXECUTE PROCEDURE checa_data();