# Aplicação Museu
Repositório para o projeto de um museu da disciplina de Banco de Dados 2 (2022)

## Framework
Utilizamos o framework SpringBoot para construir um projeto Maven (que uma ferramenta de gerenciamento de projetos de software), adicionando dependência ao SGBD Postresql, à API do JDBC (
Java Database Connectivity), ao JPA (Hibernate) e ao Thymeleaf mecanismo do Java para integração back e front-end.

## Organização do Código e Integração
   Resumidamente, primeiro configuramos os acessos ao banco no arquivo `../src/resources/application.properties` e as dependências do Spring-Boot no arquivo `pom.xml`. Em seguida, modelamos as Models em `../src/main/java/com/museu/model/` que consistem em representações das tabelas do banco. Em seguida, as consultas no postresql estão concentradas nas classes do pacote de Repository (`../src/main/java/com/museu/repository/`), dessa forma elas não ficam espalhadas em diversos pontos do código, facilitando a manutenção. 
   </br>É tarefa das classes do pacote Service chamar os métodos dos repositories e manipular o retorno para o que for necessário, no nosso caso mapeá-las para as chamadas Dtos (`../src/main/java/com/museu/dtos/`) as quais podem ser definidas como entidades para suportar as projeções feitas nas consultas sql. Nesse ponto da aplicação entram as Controllers com a responsabilidade de, dependendo da url acessada da aplicação, realizar a ação de chamar os métodos da classes services e passar os objetos formados para as views em html (`../src/main/resources/templates/`)

## Para usar a aplicação
- Certifique-se que seu arquivo ../src/resources/application.properties está coerente com sua configuração do Postresql para a aplicação do museu
- Rodar scripts/Creates.sql e scripts/Inserts.sql
- Abrir a pasta do arquivo no terminal
- Rodar o comando: `mvn spring-boot:run`
- Acessar a URL: localhost:8080/home/

## Exemplos da aplicação rodando

### Home
![home](https://user-images.githubusercontent.com/35119030/180326250-f2f4b9ba-0ee9-4db1-ac35-8d6c61f06b31.png)

### Consulta 1
![Consulta1](https://user-images.githubusercontent.com/35119030/180326284-e61501b9-c00d-4aac-99da-47ff40e40774.png)

### Gráfico 1 - Consulta 3
![grafico-1-consulta-3](https://user-images.githubusercontent.com/35119030/180326302-de343784-240c-4206-a54d-f003a442a65a.png)

### Gráfico 1 - Colsulta 4
![grafico-1-consulta-4](https://user-images.githubusercontent.com/35119030/180326321-7490a315-85d0-4f02-8f68-fa3f08e6b0d5.png)

## Sobre as consultas realizadas
Todas as consultas realizadas se encontram na pasta scripts/ e, no código, podem ser visualizadas nas classes de Repository em src/main/java/com/museu/repository

### Consulta 1
<b>Objetivo: </b> Liste os objetos de arte comprados por tipo e por classe (emprestado ou próprio)
</br><b>Oportunidades de melhoria: </b> Criar um índice de agrupamento por tipo.
</br><b>Plano de Execução: </b></br>
![image](https://user-images.githubusercontent.com/47679110/179651125-648740ec-7b4c-4a54-a64c-c2b96d57181d.png)
</br>
![image](https://user-images.githubusercontent.com/47679110/179652358-612eb954-21d7-47d0-8f47-b9e848f35e2a.png)


### Consulta 2
<b>Objetivo: </b> Liste as coleções com o maior número de empréstimos por mês e por ano
</br><b>Oportunidades de melhoria: </b> Considerando que esta é uma consulta importante para o negócio por dar origem a um relatório, poderia ser criada uma view com o objetivo de filtrar o conteúdo de uma tabela a ser exibida, protegendo certas colunas e simplificando o código.
</br><b>Plano de Execução: </b></br>
![image](https://user-images.githubusercontent.com/47679110/179652555-ee3bae39-a66b-4115-840a-d5c950e5d38b.png)
</br>
![image](https://user-images.githubusercontent.com/47679110/179653619-4d719eff-3aea-43f1-b194-ca8e22629d20.png)


### Consulta 3
<b>Objetivo: </b> Faça um controle (listagem) da compra de objetos de arte por mês e por ano do museu
</br><b>Oportunidades de melhoria: </b> Criar um índice sobre o campo dataAquisicao
</br><b>Plano de Execução: </b></br>
![image](https://user-images.githubusercontent.com/47679110/179653793-b7c829e0-880b-42b8-a45d-22b189a0d3a6.png)
</br>
![consulta 3](https://user-images.githubusercontent.com/47679110/179654910-c99279c1-d3b8-41fd-8877-dbc5ee512bbe.jpg)


### Consulta 4
<b>Objetivo: </b> Faça uma controle (listagem) da quantidade de objetos emprestados por coleção, por mês e por ano.
</br><b>Oportunidades de melhoria: </b> Criar um índice de agrupamento por coleção na tabela Emprestados e talvez indexar pelo campo dataEmprestimo.
</br><b>Plano de Execução: </b></br>
![image](https://user-images.githubusercontent.com/47679110/179655044-0d4fb088-a332-494c-b0bc-239be79e1461.png)
</br>
![image](https://user-images.githubusercontent.com/47679110/179655893-1f929542-0a57-43b9-8c8f-0a26d1efe37a.png)


## Possibilidades de Melhorias Gerais
Após a apresentação do trabalho, percebemos que interpretamos errado o tipo de gráfico pedido referente às consultas 3 e 4, pois como agrupamos por mês e por ano, ficaria poluido um gráfico nesse molde devido à alta densidade de anos, como mostramos no esboço abaixo referente à consulta 3:
![image](https://user-images.githubusercontent.com/47679110/180258006-224a9348-fe09-46ec-b56a-edcb5da5c7ef.png)

</br> Porém, se o grupo tivesse modelado a seguinte consulta e a utilizado para gerar um gráfico, ele ficaria mais homogêneo e fácil de ser lido
```sql
select CAST(SUM(oa.custo) as money) as custo_total, EXTRACT(month from pe.dataaquisicao) as mes,
EXTRACT(year from pe.dataaquisicao) as ano
from permanentes pe
inner join objetos_arte oa on oa.numid = pe.numobj5
group by mes, ano
order by ano, mes; 
```
OBS: A consulta acima retorna 70 tuplas nos seguinte molde:</br>
![image](https://user-images.githubusercontent.com/47679110/180255560-fec0ebf5-0dee-41c7-a390-5dbd1da4c94b.png)

</br>Esse seria um esboço do gráfico passível de ser modelado a partir desses dados:</br>
![image](https://user-images.githubusercontent.com/47679110/180258132-e408a77d-4401-4648-9c07-95ad957cc1f4.png)


A mesma ideia vale para a consulta 4, onde poderiamos ter usado a seguinte consulta para modelar um gráfico:
```sql
select co.nomeCol as nome_colecao, count(e.numObj4) as qtd_obj_emprestados,
EXTRACT(month from e.dataemprestimo) as mes,
EXTRACT(year from e.dataemprestimo) as ano
from colecao co
join emprestados e on e.nomeColPert = co.nomeCol
group by co.nomeCol, mes, ano
order by ano, mes;
```
OBS: A consulta acima retorna 74 tuplas nos seguinte molde:</br>
![image](https://user-images.githubusercontent.com/47679110/180258997-adee9e01-a0f5-40b7-8328-e2ea681dbe6e.png)

</br> Outras possibilidades de melhoria incluem expandir a apliação, oferecendo mais funcionalidades, como cadastros, formulários para atualização de dados, exclusão de itens, etc.
