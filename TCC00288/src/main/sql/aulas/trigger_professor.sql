DROP FUNCTION IF EXISTS limpar_professor() CASCADE;
CREATE OR REPLACE FUNCTION limpar_professor() RETURNS trigger AS '
DECLARE
    c_prof CURSOR (prof integer) FOR SELECT *
                                   FROM disciplina
                                   WHERE registro = prof
                                   FOR UPDATE OF disciplina;
BEGIN
    --UPDATE disciplina SET registro = null where registro = OLD.professor_id;
    FOR r IN c_prof(OLD.professor_id) LOOP
        UPDATE disciplina SET registro = null where CURRENT OF c_prof;
    END LOOP;
    RETURN OLD;
END' LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS delete_professor ON professor;
CREATE TRIGGER delete_professor BEFORE DELETE ON professor
FOR EACH ROW EXECUTE PROCEDURE limpar_professor();
