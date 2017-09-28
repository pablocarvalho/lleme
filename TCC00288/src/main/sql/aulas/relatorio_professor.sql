DROP FUNCTION IF EXISTS relatorio_professor(p_profid integer) CASCADE;
CREATE OR REPLACE FUNCTION relatorio_professor(p_profid integer)
RETURNS TABLE(
	nome character varying,
	horario character varying
  )
 AS '
DECLARE
BEGIN
    RETURN QUERY SELECT nome, horario FROM disciplina WHERE registro = p_profid;

    RETURN;
END' LANGUAGE plpgsql;
