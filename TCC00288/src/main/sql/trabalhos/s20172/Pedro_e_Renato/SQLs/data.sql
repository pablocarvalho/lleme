
--CLIENTES
INSERT INTO cliente VALUES
	('1','*****',2199999999,'Rua XV de Novembro, 9999, Centro , Niterói-RJ BR'),
    ('2','*****',2199999999,'Rua XV de Novembro, 9999, Centro , Niterói-RJ BR'),
    ('3','*****',2188888888,'Av. Visconde do Rio Branco, 9999, São Domingos , Niterói-RJ BR'),
    ('4','*****',2126330000,'Av. Simão da Motta, 9999, Centro , Magé-RJ BR'),
    ('5','*****',2199999999,'Rua da Assembléia, 9999, Centro , RJ-RJ BR'),
    ('user001','*',2126290000,'Rua 7 de Setembro, 9999, Icaraí , Niterói-RJ BR'),
    ('user002','*****',2126320000,'Av. Dedo de Deus, 9999, Centro , Guapimirim-RJ BR'),
    ('user004','*****',2198798798,'Av. Oliveira Botelho, 9999, Centro , Teresópolis-RJ BR'),
    ('user003','*****',2112312312,'Av. Pres. Kennedy, 9999, Centro , São Gonçalo-RJ BR'),
    ('user005','*****',2100001234,'Rua XV de Novembro, 9999, Centro , Niterói-RJ BR'),
    ('user006','*****',2112344321,'Rua XV de Novembro, 9998, Centro , Niterói-RJ BR');
--CATEGORIAS
INSERT INTO categoria VALUES
	(1,'Pizzaria'),(2,'Bar/Petisco'),(3,'Japonês'),(4,'Lanche/Fast-Food'),(5,'Fit-Food');
--LOJAS  

INSERT INTO loja VALUES
	(1,'7Grill','Rua 7 de Setembro, Icaraí , Niterói-RJ BR',1,'17:00:00','02:00:00');
INSERT INTO loja VALUES    
    (2,'McDonalds - Plaza','Rua XV de Novembro, Centro, Niterói-RJ BR',4,'10:00:00','23:59:59'),
    (3,'Dominos Pizza - Plaza','Rua XV de Novembro, Centro, Niterói-RJ BR',1,'10:00:00','23:59:59'),
    (4,'Restaurante Japones','Rua X, 123, Centro, RJ-RJ',3,'09:00:00','23:59:59');
--TIPOS
INSERT INTO tipo VALUES
	(1,'comida'),(2,'bebida');
--REFEICOES    
INSERT INTO refeicao VALUES
	(1,'Pizza de Calabresa',1),
	(2,'Pizza de Muçarela',1),
    (3,'Pizza de Pepperoni',1),
    (4,'Pizza de 4 Queijos',1),
    (5,'Big Mac',1),
    (6,'Batata Frita',1),
    (7,'CBO',1),
    (8,'Temaki',1),
    (9,'Sushi',1),
    (900,'Coca-Cola 2l',2),
    (901,'Coca-Cola 350ml',2),
    (902,'Suco 350ml',2),
    (903,'Guaraná Kuat 350ml',2),
    (904,'Guaraná Kuat 2l',2),
    (905,'Guaraná Dolly 2l',2);
    
--REFEICOES NOS CARDAPIOS
INSERT INTO cardapio VALUES
	(1,1,1,25,19.90),(1,2,3,10,20),
    (2,3,1,50,10),(2,4,3,40,12),
    (3,5,1,5,50),(3,6,3,1,60),
    (4,7,1,3,25),(4,8,3,2,20),
    (5,9,2,5,8),(6,10,2,5,5),(7,11,2,3,15),
    (8,12,4,3,21),(9,13,4,5,33.90),
    (900,14,1,10,7),(900,15,3,10,7),(900,16,4,10,7),
    (901,17,1,10,3),(901,18,2,10,3),(901,19,3,10,3),(901,20,4,10,3),
    (902,21,1,10,3),(902,22,3,10,3),(902,23,4,10,3),
    (903,24,1,10,3),(903,25,3,10,3),
    (904,26,1,10,7),
    (905,27,1,10,5);
--INSERT INTO cardapio VALUES (1,2,1,30,21.90);--DEVE FALHAR!!! INSERI O MESMO PROD NA MESMA LOJA ok


INSERT INTO pedido VALUES(1,'user001',current_timestamp,NULL,'pendente'),
							(3,'2',current_timestamp,NULL,'pendente'),
                            (2,'2',current_timestamp,NULL,'pendente');
--
INSERT INTO conteudo_pedido VALUES (1,1,1),(1,3,1);--

--CARDAPIO_COD 2: PIZZA NA LOJA 1, CARDAPIO COD 1: PIZZA NA LOJA 2
--INSERT INTO conteudo_pedido VALUES (2,1,1),(2,2,1);--DEVE DAR ERRO, PEDIDO CONTENDO LOJAS DIFERENTES! ok
--INSERT INTO conteudo_pedido VALUES (3,2,10);-- DEVE DAR ERRO, ESTOQUE INSUFICIENTE ok
--select cast(timestamp '2014-04-03 12:34:00' as time);

--SELECT cod_cardap,descr,nome,loja,hora_abre,hora_fecha,qtd,preco_unitario FROM CARDAPIO INNER JOIN REFEICAO ON CARDAPIO.refeicao=REFEICAO.cod_ref INNER JOIN LOJA ON CARDAPIO.loja=LOJA.cod_loja ;
-- EU RETORNO UMA TABELA QUE CONTEM A LOJA E OS PRATOS

    

    

    








    