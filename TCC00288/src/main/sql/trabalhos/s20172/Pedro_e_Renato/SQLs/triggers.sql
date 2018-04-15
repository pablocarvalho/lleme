

--legenda : (OK): conferido ; (T) : testado com sucesso

-- Atualiza o estoque depois de um novo pedido
CREATE OR REPLACE FUNCTION novo_estoque() RETURNS trigger AS $$
 BEGIN
    UPDATE cardapio
    SET qtd=qtd - NEW.qnt
    WHERE NEW.prato=cardapio.cod_cardap;
    RETURN NULL;
  END;
  $$
  LANGUAGE plpgsql;

CREATE TRIGGER att_estoque AFTER INSERT ON conteudo_pedido
FOR EACH ROW EXECUTE PROCEDURE novo_estoque();--*********TESTADO OK*********




-- Confere se existe estoque suficiente para criar um novo pedido

CREATE OR REPLACE FUNCTION estoque_disponivel() RETURNS trigger AS $$
  BEGIN
    IF((SELECT qtd FROM cardapio WHERE NEW.prato=cardapio.cod_cardap) - NEW.qnt <0) THEN
      RAISE EXCEPTION 'Estoque insuficiente';
    END IF;
    RETURN NEW;
  END;
  $$
  LANGUAGE plpgsql;

CREATE TRIGGER pode_comprar BEFORE INSERT ON conteudo_pedido
FOR EACH ROW EXECUTE PROCEDURE estoque_disponivel(); --*********TESTADO FUNFOU OK*********





-- Confere se o pedido foi feito enquanto a loja estava aberta
/*
IF((SELECT hora_pedido FROM pedido WHERE NEW.cod_pedido=pedido.cod_pedido) > (SELECT hora_abre FROM Loja WHERE Loja.cod_loja = (SELECT loja FROM cardapio WHERE NEW.prato=cardapio.cod_cardap))
    AND (SELECT hora_pedido FROM pedido WHERE NEW.cod_pedido=pedido.cod_pedido) < (SELECT hora_fecha FROM Loja WHERE Loja.cod_loja = (SELECT loja FROM cardapio WHERE NEW.prato=cardapio.cod_cardap)))
      THEN RETURN NEW;
END IF;
*/
/*
CREATE OR REPLACE FUNCTION loja_aberta() RETURNS trigger AS $$
  BEGIN
    IF ( (SELECT hora_pedido FROM pedido WHERE NEW.cod_pedido=pedido.cod_pedido) >
                            (SELECT hora_abre FROM Loja WHERE Loja.cod_loja =
                            (SELECT loja FROM cardapio WHERE NEW.prato=cardapio.cod_cardap))
      AND (SELECT hora_pedido FROM pedido WHERE NEW.cod_pedido=pedido.cod_pedido) <
                            (SELECT hora_fecha FROM Loja WHERE Loja.cod_loja =
                            (SELECT loja FROM cardapio WHERE NEW.prato=cardapio.cod_cardap)))
    	THEN RETURN NEW;
    END IF;
    RETURN OLD;
    END;
    $$
    LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION loja_aberta() RETURNS trigger AS $$
  BEGIN
  	IF(((select cast((SELECT momento_pedido FROM PEDIDO WHERE cod_pedido=NEW.cod_pedido ) as time))>(SELECT CAST ((SELECT hora_abre FROM conteudo_pedido INNER JOIN cardapio ON NEW.prato=cardapio.cod_cardapio INNER JOIN loja ON cardapio.loja=loja.cod_loja) as time))) OR 
((select cast((SELECT momento_pedido FROM PEDIDO WHERE cod_pedido=NEW.cod_pedido ) as time))<(SELECT CAST ((SELECT hora_fecha FROM conteudo_pedido INNER JOIN cardapio ON NEW.prato=cardapio.cod_cardapio INNER JOIN loja ON cardapio.loja=loja.cod_loja) as time))))
	THEN RETURN NEW;
    END IF;
    RETURN OLD;
  END
$$
LANGUAGE plpgsql;

*/
CREATE OR REPLACE FUNCTION loja_aberta() RETURNS trigger AS $$
  BEGIN
    IF ((select cast((SELECT momento_pedido FROM PEDIDO WHERE cod_pedido=new.cod_pedido ) as time))>
    (SELECT CAST ((SELECT distinct(hora_fecha) FROM conteudo_pedido INNER JOIN cardapio ON cardapio.cod_cardap=new.prato INNER JOIN loja ON cardapio.loja=loja.cod_loja) as time)))  
      THEN RAISE EXCEPTION 'Pedido feito com a loja fechada!';
    END IF;
    IF ((select cast((SELECT momento_pedido FROM PEDIDO WHERE cod_pedido=new.cod_pedido ) as time))<
    (SELECT CAST ((SELECT distinct(hora_abre) FROM conteudo_pedido INNER JOIN cardapio ON cardapio.cod_cardap=new.prato INNER JOIN loja ON cardapio.loja=loja.cod_loja) as time)))  
      THEN RAISE EXCEPTION 'Pedido feito com a loja fechada!';
    END IF;
    RETURN NULL;
  END
$$
LANGUAGE plpgsql;



CREATE TRIGGER pode_comprar_loja_aberta BEFORE INSERT ON conteudo_pedido
FOR EACH ROW EXECUTE PROCEDURE loja_aberta();

-- confere se o pedido foi de itens da mesma loja

CREATE OR REPLACE FUNCTION mesma_loja() RETURNS trigger AS $$
  BEGIN
    IF ((SELECT COUNT(DISTINCT loja) FROM conteudo_pedido INNER JOIN cardapio ON cardapio.cod_cardap=conteudo_pedido.prato)>1)  THEN
        RAISE EXCEPTION 'Pedido com mais de uma loja ao mesmo tempo';
    END IF;
    RETURN NULL;
  END;
  $$
  LANGUAGE plpgsql;
--*********TESTADO OK*********
/*
CREATE OR REPLACE FUNCTION mesma_loja() RETURNS trigger AS $$
  DECLARE
    c_pedido CURSOR FOR SELECT cod_pedido FROM pedido;
  BEGIN
    FOR cod_pedido IN c_pedido LOOP
	    IF ((SELECT count(DISTINCT loja) FROM conteudo_pedido INNER JOIN cardapio ON cardapio.cod_cardap=conteudo_pedido.prato WHERE conteudo_pedido.cod_pedido=cod_pedido)>1) 
        	THEN RAISE EXCEPTION 'Pedido com mais de uma loja ao mesmo tempo';
    	END IF;
    END LOOP;
    RETURN NULL;
  END;
  $$
  LANGUAGE plpgsql;


*/


CREATE TRIGGER confere_pedido AFTER INSERT ON conteudo_pedido
FOR EACH statement EXECUTE PROCEDURE mesma_loja();




-- atualiza o estoque se o pedidor for cancelado

CREATE OR REPLACE FUNCTION att_status() RETURNS trigger AS $$
  DECLARE
    --c_estoque CURSOR FOR SELECT prato,qnt FROM conteudo_pedido WHERE NEW.cod_pedido=conteudo_pedido.cod_pedido;
    --c_prato conteudo_pedido.prato%TYPE; 
    --c_qtd_pedido conteudo_pedido.qnt%TYPE;
    
    curs CURSOR IS SELECT * FROM conteudo_pedido;
    i_row conteudo_pedido%ROWTYPE;
  BEGIN
    IF EXISTS ( SELECT * FROM pedido WHERE pedido.cod_pedido=NEW.cod_pedido) THEN
      IF (OLD.status NOT LIKE NEW.status) THEN
        IF(NEW.status LIKE '%cancel%') THEN
        
          FOR i_row IN curs LOOP

          
		  --FETCH c_estoque INTO c_prato,c_qtd_pedido;
          --EXIT WHEN NOT FOUND;
              UPDATE cardapio
              SET qtd=qtd + i_row.qnt
              --SET cardapio.qnt=cardapio.qnt + (SELECT qnt FROM cardapio WHERE cardapio.cod_cardap=c_linha.prato)
              WHERE i_row.prato=cardapio.cod_cardap ;
          END LOOP;
        END IF;
      END IF;
    END IF;
    RETURN NULL;
  END;
  $$
  LANGUAGE plpgsql;

--***************OK TESTADO*****************************
CREATE TRIGGER muda_status AFTER UPDATE ON pedido
FOR EACH ROW EXECUTE PROCEDURE att_status();


CREATE OR REPLACE FUNCTION fnprevent_update()
  RETURNS trigger AS $$
  BEGIN
  	RAISE EXCEPTION 'Proibido modificação de pedidos, cancele o pedido e crie um novo, ou apenas crie um novo.';
  END
  $$
  LANGUAGE plpgsql;
  
CREATE TRIGGER trg_prevent_update
  BEFORE UPDATE OF cod_pedido, prato, qnt
  ON conteudo_pedido
  FOR EACH ROW
  EXECUTE PROCEDURE fnprevent_update();  
--OK TESTADO *****************
