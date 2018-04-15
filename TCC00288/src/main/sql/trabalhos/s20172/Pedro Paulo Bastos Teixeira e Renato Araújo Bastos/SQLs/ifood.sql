CREATE TABLE Cliente(
    login           CHARACTER VARYING       NOT NULL,
    senha           CHARACTER VARYING       NOT NULL,
    tel             CHARACTER VARYING               ,
    endereco        CHARACTER VARYING               ,
    CONSTRAINT PK_Cliente PRIMARY KEY(login)
);

CREATE TABLE Tipo(
    cod_tipo        INT                     NOT NULL,
    tip             CHARACTER VARYING       NOT NULL,
    CONSTRAINT PK_Tipo PRIMARY KEY(cod_tipo)
);

CREATE TABLE Refeicao(
    cod_ref         INT                     NOT NULL,
    descr           CHARACTER VARYING       NOT NULL,
    tipo            CHARACTER VARYING       NOT NULL,
    CONSTRAINT PK_Refeicao PRIMARY KEY(cod_ref)
);

CREATE TABLE Categoria(
    cod_cat         INT                    NOT NULL,
    nome_cat        CHARACTER VARYING      NOT NULL,
    CONSTRAINT PK_Categoria PRIMARY KEY(cod_cat)
);

CREATE TABLE Loja(
    cod_loja        INT                    NOT NULL,
    nome	        CHARACTER VARYING 	   NOT NULL,
    end_loja        CHARACTER VARYING      NOT NULL,
    categoria       INT                    NOT NULL,
    hora_abre       TIME                           ,
    hora_fecha      TIME                           ,
    CONSTRAINT PK_Loja PRIMARY KEY(cod_loja),
    CONSTRAINT FK_Loja FOREIGN KEY(categoria) REFERENCES Categoria(cod_cat)
);

CREATE TABLE cardapio(
    refeicao        INT                   NOT NULL,
    cod_cardap      INT                   NOT NULL,
    loja            INT                   NOT NULL,
    qtd             DEC(10,2)                     ,
    preco_unitario  DEC(10,2)                     ,
    CONSTRAINT PK_cardapio PRIMARY KEY(cod_cardap),
    CONSTRAINT SK_cardapio UNIQUE(refeicao,loja),
    CONSTRAINT FK1_cardapio FOREIGN KEY(refeicao) REFERENCES Refeicao(cod_ref),
    CONSTRAINT FK2_cardapio FOREIGN KEY(loja) REFERENCES Loja(cod_loja)
);

CREATE TABLE pedido(
    cod_pedido      INT                   NOT NULL,
    cliente         CHARACTER VARYING     NOT NULL,
    momento_pedido  TIMESTAMP             NOT NULL,
    momento_entrega TIMESTAMP                     ,
    status          CHARACTER VARYING     NOT NULL,
    CONSTRAINT PK_pedido PRIMARY KEY(cod_pedido),
    CONSTRAINT FK1_pedido FOREIGN KEY(cliente) REFERENCES Cliente(login)
);
CREATE TABLE conteudo_pedido(
    cod_pedido    INT                   NOT NULL,
    prato         INT                   NOT NULL,
    qnt           DEC(10,2)             NOT NULL,
    CONSTRAINT PK_conteudo_pedido PRIMARY KEY (cod_pedido,prato),
    CONSTRAINT FK1_conteudo_pedido FOREIGN KEY(cod_pedido) REFERENCES pedido(cod_pedido),
    CONSTRAINT FK2_conteudo_pedido FOREIGN KEY(prato) REFERENCES cardapio(cod_cardap)
);

CREATE TABLE Entrega(
    cod_ent       INT                     NOT NULL,
    pedido        INT                     NOT NULL,
    status        CHARACTER VARYING       NOT NULL,
    momento_saida TIMESTAMP               NOT NULL,
    momento_chegada  TIMESTAMP               NOT NULL,
    CONSTRAINT PK_Entrega PRIMARY KEY(cod_ent),
    CONSTRAINT FK1_Entrega FOREIGN KEY(pedido) REFERENCES pedido(cod_pedido)
);

CREATE TABLE Avaliacao(
    pedido          INT                  NOT NULL,
    nota            INT                  NOT NULL,
    coment          CHARACTER VARYING            ,
    CONSTRAINT PK_Avaliacao PRIMARY KEY(pedido),
    CONSTRAINT FK_Avaliacao FOREIGN KEY(pedido) REFERENCES Entrega(cod_ent)
);

CREATE TABLE Resposta(
    pedido          INT                 NOT NULL,
    coment          CHARACTER VARYING   NOT NULL,
    CONSTRAINT PK_Resposta PRIMARY KEY(pedido),
    CONSTRAINT FK_Resposta FOREIGN KEY(pedido) REFERENCES Avaliacao(pedido)
);

CREATE TABLE Pagamento(
    pedido          INT                  NOT NULL,
    momento_pag     TIMESTAMP            NOT NULL,
    CONSTRAINT PK_Pagamento PRIMARY KEY(pedido),
    CONSTRAINT FK_Pagamento FOREIGN KEY(pedido) REFERENCES pedido(cod_pedido)
);

CREATE TABLE Pg_card(
    pedido          INT                  NOT NULL,
    n_card          INT                  NOT NULL,
    CONSTRAINT PK_Pg_card PRIMARY KEY(pedido),
    CONSTRAINT FK_Pg_card FOREIGN KEY(pedido) REFERENCES Pagamento(pedido)
);

CREATE TABLE Pg_PayPal(
    pedido          INT                   NOT NULL,
    login           CHARACTER VARYING     NOT NULL,
    senha           CHARACTER VARYING     NOT NULL,
    CONSTRAINT PK_Pg_PayPal PRIMARY KEY(pedido),
    CONSTRAINT FK_Pg_PayPal FOREIGN KEY(pedido) REFERENCES Pagamento(pedido)
);


-- ************************* assertivas e triggers

-- ************************* relatorios de saida
