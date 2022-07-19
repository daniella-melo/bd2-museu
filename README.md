# Aplicação Museu
Repositório para o projeto de um museu da disciplina de Banco de Dados 2 (2022)

## Framework
Utilizamos o framework SpringBoot para construir um projeto Maven (que uma ferramenta de gerenciamento de projetos de software), adicionando dependência ao SGBD Postresql, à API do JDBC (
Java Database Connectivity), ao Thymeleaf mecanismo do Java para integração back e front-end.

## Para usar a aplicação
- Certifique-se que seu arquivo ../src/resources/application.properties está coerente com sua configuração do Postresql para a aplicação do museu
- Rodar scripts/Creates.sql e scripts/Inserts.sql
- Rodar .exe em <ADICIONAR CAMINHO AO .EXE>
- Acessar a URL: localhost:8080/home/

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
