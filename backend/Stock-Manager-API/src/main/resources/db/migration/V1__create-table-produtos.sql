CREATE TABLE produtos
(
	id         BIGSERIAL PRIMARY KEY,
	nome       VARCHAR(100)   NOT NULL,
	marca      VARCHAR(100),
	categoria  VARCHAR(100),
	valor      DECIMAL(10, 2) NOT NULL,
	quantidade INT DEFAULT 0,
	descricao  TEXT,
	imagem     VARCHAR(255)
);
