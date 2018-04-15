CREATE OR REPLACE FUNCTION verifica_assunto() RETURNS TRIGGER AS 
$$
DECLARE
	-- Cursor para iterar sobre o profissional que participam da notícia possivelmente retirada
	c1 CURSOR FOR SELECT (p.id_assunto) 
		      FROM imdb.sobre s INNER JOIN imdb.profissional ON p.id_assunto = s.id_assunto
		      WHERE s.id_noticia = OLD.id_noticia;
	r1 RECORD;

BEGIN
	IF (tg_op = 'insert' OR (tg_op = 'update' AND OLD.id_assunto <> NEW.id_assunto)) THEN	

		-- Verifica se informação nova é sobre um profissional
		IF EXISTS (SELECT *
			  FROM imdb.assunto a INNER JOIN imdb.tipo_assunto t ON a.tipo = t.id
			  WHERE t.nome = 'Profissional' AND a.id = NEW.id_assunto) THEN

			-- Verifica se existe pelo menos algum filme que o profissinal participe 
			IF NOT EXISTS (SELECT * 
				      FROM imdb.participa_de p INNER JOIN imdb.sobre s ON p.id_filme = s.id_assunto	
				      WHERE p.id_profissional = NEW.id_assunto AND s.id_noticia = NEW.id_noticia) THEN
			RAISE EXCEPTION 'Profissional adicionado como assunto sem que filme que participe tenha sido';
			END IF;
		END IF;
	END IF;
	
	IF (tg_op = 'delete' OR (tg_op = 'update' AND OLD.id_assunto <> NEW.id_assunto)) THEN
		
		-- Verifica se informação que saiu é de filme 
		IF EXISTS (SELECT *
			  FROM imdb.assunto a INNER JOIN imdb.tipo_assunto t ON a.tipo = t.id
			  WHERE t.nome = 'Filme' AND a.id = OLD.id_assunto) THEN

			-- Itera sobre profissionais que, possivelmente, estão sem filme que participe elencado como assunto
			 FOR r1 IN c1 LOOP
				IF NOT EXISTS ( SELECT *
						FROM imdb.sobre s INNER JOIN imdb.participa_de p ON s.id_assunto = p.id_filme
						WHERE s.id_noticia = OLD.id_noticia AND p.id_profissional = r1.id_profissional
						AND p.id_filme <> OLD.id_assunto) THEN
					RAISE EXCEPTION 'Filme não pode ser retirado de assunto, possui profissinais dependentes';
				END IF;
			END LOOP;
		END IF;
	END IF;
END;
$$ LANGUAGE plpgsql;
					
CREATE TRIGGER verifica_assuntoTrig BEFORE INSERT OR UPDATE OR DELETE ON imdb.sobre 
	FOR EACH ROW EXECUTE PROCEDURE verifica_assunto();				
						 				

				
							  
						
				   	