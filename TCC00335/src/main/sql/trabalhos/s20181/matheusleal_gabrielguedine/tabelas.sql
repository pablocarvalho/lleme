DROP TABLE IF EXISTS agendamento;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS vinculo_empregaticio;
DROP TABLE IF EXISTS servico_funcionario;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS tipo_servico;
DROP TABLE IF EXISTS tipo_funcionario;
DROP TABLE IF EXISTS negocio;

CREATE TABLE negocio(
	ID SERIAL PRIMARY KEY,
	endereco TEXT NOT NULL,
	CNPJ TEXT NOT NULL,
	nome TEXT NOT NULL
);

CREATE TABLE tipo_funcionario (
	ID SERIAL PRIMARY KEY,
	tipo TEXT NOT NULL
);

CREATE TABLE funcionario(
	CPF TEXT PRIMARY KEY,
	nome TEXT NOT NULL,
	data_nasc TIMESTAMP NOT NULL,
	endereco TEXT,
	telefone TEXT NOT NULL,
	email TEXT NOT NULL,
	tipo_funcionario INTEGER NOT NULL,
	CONSTRAINT tipoFuncionario_fk FOREIGN KEY(tipo_funcionario)
	REFERENCES tipo_funcionario(ID)
);

CREATE TABLE tipo_servico(
	ID SERIAL PRIMARY KEY,
	nome_servico TEXT NOT NULL,
	valor FLOAT NOT NULL,
	tempo_estimado TIME
);

CREATE TABLE servico_funcionario(
	cpf_funcionario TEXT NOT NULL,
	tipo_servico INTEGER NOT NULL,
	CONSTRAINT funcionario_fk FOREIGN KEY (cpf_funcionario)
	REFERENCES funcionario(CPF),
	CONSTRAINT tipoServico_fk FOREIGN KEY (tipo_servico)
	REFERENCES tipo_servico(ID)	
);

CREATE TABLE vinculo_empregaticio(
	cpf_funcionario TEXT NOT NULL,
	id_negocio INTEGER NOT NULL,
	periodo_inicio TIMESTAMP NOT NULL,
	periodo_fim TIMESTAMP NOT NULL, 
	CONSTRAINT funcionario_fk FOREIGN KEY (cpf_funcionario)
	REFERENCES funcionario(CPF),
	CONSTRAINT negocio_fk FOREIGN KEY (id_negocio)
	REFERENCES negocio(ID),
	PRIMARY KEY(cpf_funcionario, id_negocio)
);

CREATE TABLE cliente(
	CPF TEXT NOT NULL PRIMARY KEY,
	nome TEXT NOT NULL,
	cartao_credito TEXT,
	email TEXT NOT NULL,	
	senha TEXT NOT NULL
);

CREATE TABLE agendamento(
	cpf_cliente TEXT NOT NULL,
	cpf_funcionario TEXT NOT NULL,
	data_agendada TIMESTAMP NOT NULL,
	hora_inicio TIME NOT NULL,
	hora_fim TIME,
	tipo_pagamento TEXT NOT NULL,
	status INTEGER NOT NULL DEFAULT 1, -- 1 se estiver ativo, 0 se for cancelado
	tipo_servico INTEGER NOT NULL,
	id_negocio INTEGER NOT NULL,
	
	CONSTRAINT funcionario_fk FOREIGN KEY (cpf_funcionario)
	REFERENCES funcionario(CPF),
	CONSTRAINT negocio_fk FOREIGN KEY (id_negocio)
	REFERENCES negocio(ID),
	CONSTRAINT cliente_fk FOREIGN KEY (cpf_cliente)
	REFERENCES cliente(CPF),
	CONSTRAINT tipoServico_fk FOREIGN KEY (tipo_servico)
	REFERENCES tipo_servico(ID),
	PRIMARY KEY(cpf_cliente, cpf_funcionario, data_agendada, hora_inicio, id_negocio)
);
