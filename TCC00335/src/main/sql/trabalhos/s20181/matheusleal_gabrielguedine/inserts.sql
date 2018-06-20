-- Negocio
INSERT INTO negocio(endereco, CNPJ, nome)
VALUES ('Rua Passos Da Patria', '34343421', 'Corte de cabelo');
INSERT INTO negocio(endereco, CNPJ, nome) 
VALUES ('Rua Roberto Silveira', '312321', 'Cabelo Top');

-- Tipo Funcionario
INSERT INTO tipo_funcionario(tipo)
VALUES ('Admistrador');
INSERT INTO tipo_funcionario(tipo)
VALUES ('Gerente');
INSERT INTO tipo_funcionario(tipo)
VALUES ('Funcionario');

-- Funcionarios

	-- Administradores
	INSERT INTO funcionario(cpf, nome, data_nasc, endereco, telefone, email, tipo_funcionario) 
	VALUES('1111111111', 'João Lucas',timestamp '19-11-1988', 'Rua Passos da Patria', '211234567', 'teste@gmail.com', 1);

	-- Gerentes
	INSERT INTO funcionario(cpf, nome, data_nasc, endereco, telefone, email, tipo_funcionario) 
	VALUES('2111111111', 'Bernado', timestamp '20-05-1998', 'Rua Feliciano Sodré', '211234567', 'teste@gmail.com', 2);

	-- Funcionarios
	INSERT INTO funcionario(cpf, nome, data_nasc, endereco, telefone, email, tipo_funcionario)
	VALUES('3111111111', 'Lucas',timestamp '19-03-1995', 'Av. Amaral Peixoto', '211234567', 'teste@gmail.com', 3);

-- Tipos de Serviços
INSERT INTO tipo_servico(nome_servico, valor, tempo_estimado)
VALUES ('Corte de Cabelo', 20.0,time '01:00:00');

INSERT INTO tipo_servico(nome_servico, valor, tempo_estimado)
VALUES ('Barba', 15.0,time '00:30:00');

INSERT INTO tipo_servico(nome_servico, valor, tempo_estimado)
VALUES ('Sobrancelha', 10.0, time '00:15:00');

-- Serviço Funcionario
INSERT INTO servico_funcionario(cpf_funcionario, tipo_servico)
VALUES ('3111111111', 1);
INSERT INTO servico_funcionario(cpf_funcionario, tipo_servico)
VALUES ('3111111111', 2);

-- Vinculo Empregaticio
INSERT INTO vinculo_empregaticio(cpf_funcionario, id_negocio, periodo_inicio, periodo_fim)
VALUES ('3111111111', 1, timestamp '19-03-2018', timestamp '19-09-2018');

-- Cliente
INSERT INTO cliente (cpf, nome, cartao_credito, email, senha)
VALUES ('1111111112', 'Matheus', NULL, 'teste@gmail.com', '12345');

-- Agendamento
INSERT INTO agendamento(cpf_cliente, cpf_funcionario, data_agendada, hora_inicio, hora_fim, tipo_pagamento, status, tipo_servico, id_negocio)
VALUES ('1111111112', '3111111111', timestamp '30-05-18', time '12:00:00', NULL, 'Dinheiro',
	1,1,1);
INSERT INTO agendamento(cpf_cliente, cpf_funcionario, data_agendada, hora_inicio, hora_fim, tipo_pagamento, status, tipo_servico, id_negocio)
VALUES ('1111111112', '3111111111', timestamp '05-06-18', time '12:00:00', time '12:30:00', 'Dinheiro',
	1,1,1);
INSERT INTO agendamento(cpf_cliente, cpf_funcionario, data_agendada, hora_inicio, hora_fim, tipo_pagamento, status, tipo_servico, id_negocio)
VALUES ('1111111112', '3111111111', timestamp '13-07-18', time '14:00:00', NULL, 'Cartao',
	1,1,1);
	INSERT INTO agendamento(cpf_cliente, cpf_funcionario, data_agendada, hora_inicio, hora_fim, tipo_pagamento, status, tipo_servico, id_negocio)
VALUES ('1111111112', '3111111111', timestamp '01-09-18', time '18:00:00', NULL, 'Cartao',
	1,1,1);