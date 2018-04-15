CREATE OR REPLACE FUNCTION comanda (nPedido INT)
RETURNS DEC(10,2) AS $$
  DECLARE
    curs CURSOR FOR SELECT * FROM conteudo_pedido WHERE nPedido=cod_pedido;
    c_linha conteudo_pedido%rowtype;
    soma DEC(10,2);
  BEGIN
    soma:=0;
    IF nPedido IS NOT NULL THEN
      FOR c_linha IN curs LOOP
        soma=soma + (SELECT preco_unitario FROM cardapio WHERE cod_cardap=c_linha.prato);
      END LOOP;
    END IF;
    RETURN soma;
  END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION ranking()
  RETURNS TABLE( loja CHARACTER VARYING,
                nota DEC(10,2)
                ) AS $$
  BEGIN
    RETURN
    QUERY
      SELECT loja.nome,avg(nota)
      FROM Avaliacao INNER JOIN Entrega ON Avaliacao.pedido=Entrega.cod_ent INNER JOIN conteudo_pedido ON conteudo_pedido.cod_pedido=Entrega.pedido
            INNER JOIN cardapio ON conteudo_pedido.prato=cardapio.cod_cardap INNER JOIN Loja on cardapio.loja=Loja.cod_loja
      GROUP BY Loja.cod_loja;
  END;
  $$
  LANGUAGE plpgsql;




