CREATE TABLE coordenador (
  matricula BIGINT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE aluno (
  matricula BIGINT PRIMARY KEY,
  senha VARCHAR(12) NOT NULL,
  nome VARCHAR(100) NOT NULL,
  data_nascimento DATE NOT NULL,
  area VARCHAR(50)
);

CREATE TABLE projeto (
  id_projeto SERIAL PRIMARY KEY,
  aluno_matricula BIGINT NOT NULL ,
  coordenador_matricula BIGINT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  tipo VARCHAR(1) NOT NULL,
  data DATE,
  status VARCHAR(1) NOT NULL,
  descricao VARCHAR(500),

  FOREIGN KEY (aluno_matricula) REFERENCES aluno (matricula) ON DELETE CASCADE,
  FOREIGN KEY (coordenador_matricula) REFERENCES coordenador (matricula)
 
);

CREATE TABLE habilidade (
  id_habilidade SERIAL PRIMARY KEY,
  tipo VARCHAR(50) NOT NULL,
  nome VARCHAR(50) NOT NULL,
  descricao VARCHAR(500)
);

CREATE TABLE aluno_habilidade (
  aluno_matricula BIGINT NOT NULL,
  habilidade_id BIGINT NOT NULL,

  FOREIGN KEY (aluno_matricula) REFERENCES aluno (matricula) ON DELETE CASCADE,
  FOREIGN KEY (habilidade_id) REFERENCES habilidade (id_habilidade)
);

