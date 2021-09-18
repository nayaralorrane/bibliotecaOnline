CREATE TABLE "livro" (
  "id_livro" serial UNIQUE NOT NULL,
  "id_autor" int NOT NULL,
  "id_sessao" int NOT NULL,
  "titulo" character varying,
  "editora" character varying,
  "preco" double precision NOT NULL DEFAULT 0
);

CREATE TABLE "autor" (
  "id_autor" serial UNIQUE NOT NULL,
  "aut_nome" character varying
);

CREATE TABLE "categoria" (
  "id_categoria" serial UNIQUE NOT NULL,
  "nome_categoria" character varying
);

CREATE TABLE "sessao" (
  "id_sessao" serial UNIQUE NOT NULL,
  "id_biblioteca" int NOT NULL,
  "nome_sessao" character varying,
  "estante" int,
  "prateleira" int
);

CREATE TABLE "biblioteca" (
  "id_biblioteca" serial UNIQUE NOT NULL,
  "nome_biblioteca" character varying,
  "cnpj" character varying UNIQUE,
  "endereco" character varying,
  "numero" int,
  "cidade" character varying,
  "estado" character varying
);

CREATE TABLE "usuario" (
  "id_usuario" serial UNIQUE NOT NULL,
  "id_permissoes" int NOT NULL,
  "nome" character varying,
  "email" character varying,
  "documento" character varying,
  "senha" character varying
);

CREATE TABLE "permissoes" (
  "id_permissoes" serial UNIQUE NOT NULL,
  "nome_permissao" character varying
);

CREATE TABLE "livro_categoria" (
  "id_livro" int NOT NULL,
  "id_categoria" int NOT NULL
);

ALTER TABLE "livro_categoria" ADD CONSTRAINT "livro_categoria_relation" FOREIGN KEY ("id_livro") REFERENCES "livro" ("id_livro");

ALTER TABLE "livro_categoria" ADD CONSTRAINT "categoria_livro" FOREIGN KEY ("id_categoria") REFERENCES "categoria" ("id_categoria");

ALTER TABLE "livro" ADD CONSTRAINT "livro_autor" FOREIGN KEY ("id_autor") REFERENCES "autor" ("id_autor");

ALTER TABLE "livro" ADD CONSTRAINT "livro_sessao" FOREIGN KEY ("id_sessao") REFERENCES "sessao" ("id_sessao");

ALTER TABLE "sessao" ADD CONSTRAINT "sessao_biblioteca" FOREIGN KEY ("id_biblioteca") REFERENCES "biblioteca" ("id_biblioteca");

ALTER TABLE "usuario" ADD CONSTRAINT "usuario_permissoes" FOREIGN KEY ("id_permissoes") REFERENCES "permissoes" ("id_permissoes");

CREATE USER bobackend WITH PASSWORD '123456';
GRANT ALL PRIVILEGES ON DATABASE biblioteca_online TO bobackend;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO bobackend;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO bobackend;

INSERT INTO permissoes(nome_permissao) 
VALUES('Funcionário'), ('Cliente');

INSERT INTO biblioteca(nome_biblioteca, cnpj, endereco, numero, cidade, estado)
VALUES('Saraiva','00.000.000/0001-00','Avenida', 2, 'Jambeiro', 'São Paulo');

INSERT INTO sessao(nome_sessao, estante, prateleira, id_biblioteca)
VALUES('A', '1', 1, 1);

INSERT INTO autor(aut_nome)
VALUES('Nayara');

INSERT INTO livro(titulo, editora, preco, id_autor, id_sessao)
VALUES('Kiara Aventureira', 'Lorrane', 120.00, 1, 1);

INSERT INTO categoria(nome_categoria)
VALUES ('Comédia'), ('Mistério');

INSERT INTO livro_categoria(id_livro, id_categoria)
VALUES (1,1), (1,2);
