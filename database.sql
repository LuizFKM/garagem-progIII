create database db_garagem;
use db_garagem;

CREATE TABLE tb_usuarios(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(50),
    senha VARCHAR(8)
);

CREATE TABLE tb_garagens(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    pais VARCHAR(100),
    estado VARCHAR(100),
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    rua VARCHAR(100),
    numero VARCHAR(50),
    cep VARCHAR(100)
);

INSERT INTO tb_usuarios (id, nome, email, senha) 
	VALUES ("1", "aaa", "aaa", "123");
    
SELECT * FROM tb_usuarios;

SELECT @@version;