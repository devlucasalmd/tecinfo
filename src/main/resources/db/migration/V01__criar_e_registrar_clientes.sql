CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `logradouro` varchar(100),
  `numero`varchar(20),
  `complemento` varchar(100),
  `bairro` varchar(100),
  `cidade` varchar(100),
  `estado` varchar(100),
  `cep` varchar(100),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO client (name, mail, phone, cpf, active, logradouro, numero, complemento, bairro, cidade, estado, cep) 
VALUES ('João Silva', 'joao.silva@email.com', '11999999999', '123.456.789-00', 1, 'Francisco Lamberto', '120', 
       '', 'Pq. São Luis', 'Taubaté', 'São Paulo', '12125808'),
       ('Maria Souza', 'maria.souza@email.com', '11888888888', '987.654.321-00', 1, 'Francisco Rizzini', '210', 
       '', 'Pq. São Luis', 'Taubaté', 'São Paulo', '12125808');