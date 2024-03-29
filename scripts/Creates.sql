SET search_path TO museu,public;

CREATE TABLE Artista(
Nome VARCHAR(255) NOT NULL,
DescrArista VARCHAR(300) NOT NULL,
DataMorte DATE,
EstiloPrincipal VARCHAR(255) NOT NULL,
Periodo VARCHAR(50) NOT NULL,
PaisdeOrigem VARCHAR(50) NOT NULL,
PRIMARY KEY(Nome)
);


CREATE TABLE Objetosarte(
NumId INT NOT NULL,
Titulo VARCHAR(255) NOT NULL,
Descricao VARCHAR(255) NOT NULL,
AnoCriacao VARCHAR(4) NOT NULL,
PeriodoObj VARCHAR(50) NOT NULL,
PaisCultura VARCHAR(50) NOT NULL,
Estilo VARCHAR(255) NOT NULL,
TipoObjArt VARCHAR(255) NOT NULL,
CatObjArt VARCHAR (255) NOT NULL,
NomeArt VARCHAR(255) NOT NULL,
Custo DECIMAL(10,2) NOT NULL,
PRIMARY KEY(NumId),
FOREIGN KEY (NomeArt) REFERENCES Artista(Nome) ON DELETE CASCADE
);


CREATE TABLE Pinturas(
NumObj1 INT NOT NULL,
TipoTinta VARCHAR(50) NOT NULL,
Suporte VARCHAR(50) NOT NULL,
PRIMARY KEY(NumObj1),
FOREIGN KEY(NumObj1) REFERENCES Objetosarte(NumId) ON DELETE CASCADE
);


CREATE TABLE Esculturas(
NumObj2 INT NOT NULL,
Material VARCHAR(255) NOT NULL,
Altura DECIMAL(10,2) NOT NULL,
Peso DECIMAL(10,2) NOT NULL,
PRIMARY KEY(NumObj2),
FOREIGN KEY(NumObj2) REFERENCES Objetosarte(NumId) ON DELETE CASCADE
);


CREATE TABLE Outros(
NumObj3 INT NOT NULL,
Tipo VARCHAR(50) NOT NULL,
PRIMARY KEY(NumObj3),
FOREIGN KEY(NumObj3) REFERENCES Objetosarte(NumId) ON DELETE CASCADE
);


CREATE TABLE Exposicoes(
NomeExp VARCHAR(255) UNIQUE NOT NULL,
DataInicio DATE NOT NULL,
DataFinal DATE NOT NULL,
PRIMARY KEY(NomeExp, DataInicio)
);


CREATE TABLE ExpostoEm(
NumObj6 INT NOT NULL,
NomeExpo VARCHAR(255) NOT NULL,
PRIMARY KEY(NumObj6, NomeExpo),
FOREIGN KEY(NumObj6) REFERENCES Objetosarte(NumId) ON DELETE CASCADE,
FOREIGN KEY(NomeExpo) REFERENCES Exposicoes(NomeExp) ON DELETE NO ACTION
);


CREATE TABLE Colecao(
NomeCol VARCHAR(255) NOT NULL,
DescrCol VARCHAR(300) NOT NULL,
Endereco VARCHAR(300) NOT NULL,
Telefone VARCHAR(50) NOT NULL,
PessoaContato VARCHAR(255) NOT NULL,
TipoCol VARCHAR(50) NOT NULL,
PRIMARY KEY(NomeCol)
);


CREATE TABLE Permanentes(
NumObj5 INT NOT NULL,
DataAquisicao DATE NOT NULL,
EmExposicao BOOLEAN NOT NULL,
PRIMARY KEY(NumObj5),
FOREIGN KEY(NumObj5) REFERENCES Objetosarte(NumId) ON DELETE NO ACTION
);


CREATE TABLE Emprestados(
NumObj4 INT NOT NULL,
DataDevolucao DATE NOT NULL,
DataEmprestimo DATE NOT NULL,
NomeColPert VARCHAR(255) NOT NULL,
PRIMARY KEY(NumObj4),
FOREIGN KEY(NumObj4) REFERENCES Objetosarte(NumId) ON DELETE CASCADE,
FOREIGN KEY(NomeColPert) REFERENCES Colecao(NomeCol) ON DELETE NO ACTION
);