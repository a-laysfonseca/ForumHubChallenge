# FórumHub API

> Status do Projeto: Concluído ✔️
> Data: 17/08/2025

## 📝 Descrição
API REST para o FórumHub, uma plataforma de debates e troca de conhecimentos. Este projeto foi desenvolvido como parte do Challenge Back-End do programa Oracle Next Education (ONE) em parceria com a Alura. O objetivo foi construir uma API RESTful completa seguindo as melhores práticas do mercado, incluindo operações de CRUD, validações, e um sistema de segurança com autenticação e autorização via Tokens JWT.

## ⚙️ Funcionalidades
A API FórumHub permite realizar as seguintes operações sobre os tópicos de um fórum:

* **Autenticação**:
    * `POST /login`: Autentica um usuário na aplicação, retornando um token JWT para acesso aos endpoints protegidos.

* **Tópicos (Endpoints Protegidos)**:
    * `POST /topicos`: Cria um novo tópico.
    * `GET /topicos`: Lista todos os tópicos de forma paginada e ordenada por data de criação.
    * `GET /topicos/{id}`: Detalha um tópico específico pelo seu ID.
    * `PUT /topicos/{id}`: Atualiza o título e/ou a mensagem de um tópico existente.
    * `DELETE /topicos/{id}`: Exclui um tópico.

## 🛠️ Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Security** (Autenticação/Autorização com Tokens JWT)
- **Spring Data JPA** (Persistência de dados)
- **Maven** (Gerenciador de dependências)
- **Lombok** (Redução de código boilerplate)
- **MySQL** (Banco de Dados Relacional)
- **Flyway** (Ferramenta de Migration para versionamento do banco de dados)

## 🚀 Como Executar o Projeto

**Pré-requisitos:**
* Java JDK 17 ou superior
* Maven 4 ou superior
* MySQL 8 ou superior

**1. Clone o Repositório:**
```bash
git clone [https://github.com/a-laysfonseca/ForumHubChallenge.git](https://github.com/a-laysfonseca/ForumHubChallenge.git)
```

**2. Configure o Banco de Dados:**
* Crie um banco de dados no MySQL com o nome `forumhub_db`.
* Exemplo de comando no MySQL: `CREATE DATABASE forumhub_db;`
* O Flyway cuidará da criação das tabelas automaticamente na primeira vez que a aplicação for executada.

**3. Configure as Variáveis de Ambiente:**
* É necessário configurar uma variável de ambiente com a sua senha do MySQL:
    * **Nome da variável:** `DB_PASSWORD_MYSQL`
    * **Valor da variável:** `sua_senha_do_mysql`
* A chave secreta do JWT também está configurada no arquivo `application.properties`. Para um ambiente de produção, o ideal seria movê-la para uma variável de ambiente também.

**4. Execute a Aplicação:**
* Abra o projeto na sua IDE de preferência (ex: IntelliJ).
* Deixe o Maven baixar todas as dependências do projeto.
* Execute a classe principal `ForumhubApplication.java`.
* A API estará disponível em `http://localhost:8080`. Você pode testar os endpoints utilizando o [Insomnia](https://insomnia.rest/) ou [Postman](https://www.postman.com/).

## ✒️ Autor
Lays Fonseca