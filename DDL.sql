CREATE TABLE "livro" (
  "id_livro" serial UNIQUE NOT NULL,
  "fk_autor" int NOT NULL,
  "fk_sessao" int NOT NULL,
  "titulo" character varying,
  "editora" character varying,
  "preco" double precision NOT NULL DEFAULT 0
);

CREATE TABLE "autor" (
  "id_autor" serial UNIQUE NOT NULL,
  "nome" character varying
);

CREATE TABLE "categoria" (
  "id_categoria" serial UNIQUE NOT NULL,
  "nome" character varying
);

CREATE TABLE "sessao" (
  "id_sessao" serial UNIQUE NOT NULL,
  "fk_biblioteca" int NOT NULL,
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
  "fk_permissoes" int NOT NULL,
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

ALTER TABLE "livro" ADD CONSTRAINT "livro_autor" FOREIGN KEY ("fk_autor") REFERENCES "autor" ("id_autor");

ALTER TABLE "livro" ADD CONSTRAINT "livro_sessao" FOREIGN KEY ("fk_sessao") REFERENCES "sessao" ("id_sessao");

ALTER TABLE "sessao" ADD CONSTRAINT "sessao_biblioteca" FOREIGN KEY ("fk_biblioteca") REFERENCES "biblioteca" ("id_biblioteca");

ALTER TABLE "usuario" ADD CONSTRAINT "usuario_permissoes" FOREIGN KEY ("fk_permissoes") REFERENCES "permissoes" ("id_permissoes");

CREATE USER bobackend WITH PASSWORD '123456';
GRANT ALL PRIVILEGES ON DATABASE biblioteca_online TO bobackend;