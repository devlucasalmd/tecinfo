CREATE TABLE `ordem_servico` (
	`codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  	`description` varchar(500) NOT NULL,
  	`data_emissao` date NOT NULL,
  	`data_finalizacao` date,
  	`valor` decimal NOT NULL,
  	`observacao` varchar(100) NOT NULL,
  	`client_id` bigint(20) NOT NULL,
  	`forma_id` bigint(20) NOT NULL,
  	PRIMARY KEY (`codigo`),
  	FOREIGN KEY(`client_id`) REFERENCES client(id),
  	FOREIGN KEY(`forma_id`) REFERENCES forma_pagamento(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ordem_servico (codigo, description, data_emissao, data_finalizacao, valor, observacao, client_id, forma_id)
	values(1, "Produto A", '1980-01-01', '1980-02-01', 250.00, 'Primeiro produto vendido', 1, 1)