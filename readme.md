# 📦 CLI - Sistema de Cadastro de Usuários com JDBC + PostgreSQL

Este é um projeto de linha de comando (CLI) desenvolvido em Java que realiza operações de CRUD (Create, Read, Update, Delete) em um banco de dados PostgreSQL utilizando JDBC puro.  
O projeto segue uma arquitetura em camadas (**Model**, **DAO**, **Service**) para uma melhor organização e manutenibilidade.

---

## 🌟 Status do Projeto

**Status:** Concluído ✔️

---

## ✅ Funcionalidades

- [x] Inserção de usuários  
- [x] Listagem de todos os usuários  
- [x] Busca por ID  
- [x] Atualização de dados do usuário  
- [x] Exclusão de usuários  
- [x] Menu interativo via terminal  

---

## 🛠️ Tecnologias utilizadas

- **Java 17** – Versão da linguagem Java utilizada  
- **Maven 3.8+** – Gerenciador de dependências e build  
- **PostgreSQL 14** – Banco de dados relacional  
- **JDBC 42.7+** – Driver para conexão com o PostgreSQL  
- **JUnit 4** – Framework de testes de unidade  
- **Mockito 5** – Mock para testes unitários  

---

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [JDK 17](https://www.oracle.com/br/java/technologies/javase/jdk17-archive-downloads.html) ou superior  
- [Maven](https://maven.apache.org/)  
- [PostgreSQL](https://www.postgresql.org/)  
- IDE (IntelliJ IDEA, Eclipse ou VS Code)

---

## 🚀 Como Começar

### 1. Clone o repositório

git clone https://seu-repositorio-aqui.git
cd nome-da-pasta-do-projeto

## Configure o Banco de Dados
Abra seu cliente PostgreSQL (psql, pgAdmin, DBeaver etc) e execute:

**Crie o banco de dados**
CREATE DATABASE cli_usuarios;

**Conecte-se ao banco e crie a tabela**
\c cli_usuarios

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
**3. Configure a Conexão no Projeto** 
No arquivo:
src/main/java/com/pedroviena/cliusuarios/db/DatabaseConnection.java

**Edite as credenciais:**
private static final String USER = "seu_usuario_do_postgres";
private static final String PASSWORD = "sua_senha_do_postgres";
## ▶️ Executando a Aplicação

**1. Compile e empacote o projeto**
mvn clean install
2. Execute a aplicação

java -jar target/cli-usuarios-1.0-SNAPSHOT.jar
O menu interativo será exibido no terminal.

## 🧪 Executando os Testes
mvn test
## 🗃️ Estrutura do Projeto
O projeto está organizado em uma arquitetura de 4 camadas para separar responsabilidades:

.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── pedroviena
│   │   │           └── cliusuarios
│   │   │               ├── Main.java              # (Apresentação) Interface CLI
│   │   │               ├── dao
│   │   │               │   └── UserDao.java       # (Dados) JDBC e SQL
│   │   │               ├── db
│   │   │               │   └── DatabaseConnection.java # Conexão com PostgreSQL
│   │   │               ├── model
│   │   │               │   └── User.java          # (Modelo) Entidade de Usuário
│   │   │               └── service
│   │   │                   └── UserService.java   # (Serviço) Lógica de negócio
│   └── test
│       └── java
│           └── com/pedroviena/cliusuarios         # Testes unitários
└── pom.xml                                        # Configuração do Maven

## ▶️ Executando com Docker Compose
mvn clean install
docker-compose up --build
A aplicação será executada com o menu no terminal e o banco já conectado.



## ✒️ Autor
Pedro Viena
Este projeto foi desenvolvido como parte de um estudo prático sobre arquitetura de software em Java, JDBC e testes de unidade.

## 📜 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE.md para mais detalhes.
© 2025 - Pedro Viena