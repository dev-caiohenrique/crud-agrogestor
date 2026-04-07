# 🚜 Agrogestor - Sistema de Gestão Agrícola

Este é um projeto de **CRUD (Create, Read, Update, Delete)** desenvolvido para o curso de **Análise e Desenvolvimento de Sistemas (ADS)**. O foco do sistema é o gerenciamento e a negociação de animais em uma fazenda, abrangendo aves, bovinos e suínos.

## 🚀 Tecnologias Utilizadas
* **Linguagem:** Java 25

* **Framework:** Spring Boot 3
* **Banco de Dados:** PostgreSQL
* **Ferramenta de Testes:** Insomnia

## 🛠️ Funcionalidades
* Cadastro de animais (Raça e Preço).
* Listagem completa de todos os animais no banco de dados.
* Atualização de dados de animais existentes.
* Exclusão de registros do sistema.

## ⚙️ Como rodar o projeto
1. Certifique-se de ter o **PostgreSQL** instalado na porta `5432`.
2. Crie um banco de dados chamado `agrogestor`.
3. Configure seu usuário e senha no arquivo `src/main/resources/application.properties`.
4. Execute a aplicação através da sua IDE (IntelliJ/Eclipse) ou via terminal.
5. A API estará disponível em `http://localhost:8080`.

## 📌 Endpoints Principais
* `POST /bovino` - Cadastrar um bovino.
* `GET /bovino` - Listar todos os bovinos.
* `POST /ave` - Cadastrar uma ave.
* `POST /suino` - Cadastrar um suíno.

---
Desenvolvido por **Caio Henrique** como parte do projeto acadêmico de ADS.
