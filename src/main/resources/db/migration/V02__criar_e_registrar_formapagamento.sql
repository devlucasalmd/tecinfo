CREATE TABLE `forma_pagamento` (
	`codigo` bigint(20) NOT NULL AUTO_INCREMENT,
  	`nome` varchar(100) NOT NULL,
  	PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO forma_pagamento (codigo, nome)
	values (1, 'Debíto')