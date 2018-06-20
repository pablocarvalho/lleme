--------- Procedure 1 --------
CREATE OR REPLACE FUNCTION altera_agendamento() RETURNS trigger AS $$
	BEGIN
		IF OLD.hora_fim IS NULL THEN
			UPDATE agendamento SET status = 0 WHERE OLD.cpf_cliente = cpf_cliente
			   AND OLD.cpf_funcionario = cpf_funcionario
			   AND OLD.data_agendada = data_agendada
			   AND OLD.hora_inicio = hora_inicio
			   AND OLD.id_negocio = id_negocio;
			RETURN NULL;
		ELSE
			RAISE EXCEPTION 'Agendamento ja foi concluido, logo nao e possivel apaga-lo';
		END IF;

	END;
$$ LANGUAGE plpgsql;

	-- Trigger 1 --
-- Em caso de cancelar agendamento
-- Mudar entrada na tabela para Status 0
CREATE TRIGGER altera_agendamento_tgr BEFORE DELETE ON agendamento
	FOR EACH ROW EXECUTE PROCEDURE altera_agendamento();


