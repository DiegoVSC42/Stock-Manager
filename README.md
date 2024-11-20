# Stock Manager

Um sistema de gerenciamento de produtos (CRUD) que permite adicionar, visualizar, editar e excluir produtos de um estoque.
O front end foi desenvolvido com Angular e utiliza Java com Spring Boot para se conectar a um banco PostgreSQL, mas também pode ser executado utilizando o JSON Server como backend simulando uma API RESTful.

## Tecnologias Utilizadas

-   [Angular](https://angular.io/) - Framework para construção de aplicações web
-   [TypeScript](https://www.typescriptlang.org/) - Linguagem de programação baseada em JavaScript
-   [JSON Server](https://github.com/typicode/json-server) - Simulador de API RESTful
-   [Java](https://docs.oracle.com/en/java/javase/17/) - Linguagem de programação com suporte a Orientação a Objetos
-   [Spring](https://spring.io/) - Framework para desenvolvimento de APIs
-   [PostgreSQL](https://www.postgresql.org/) - Banco de dados relacional

## Funcionalidades

-   Adicionar produtos ao estoque
-   Visualizar lista de produtos
-   Editar informações dos produtos
-   Excluir produtos do estoque

## Como Executar o Projeto

### 1. **Clone o repositório**

Clone o repositório para sua máquina local e entre na pasta do projeto:

```bash
git clone https://github.com/DiegoVSC42/Stock-Manager.git
cd Stock-Manager
```

### 2. **Instale as dependências**

Instale as dependências do projeto:

```bash
npm install
```

### 3. **Escolha o Backend**

Você tem duas opções para rodar o backend: utilizando o **JSON Server** ou o **Java + Spring Boot**. Escolha a opção que preferir.

OBS.: O backend será iniciado na porta `3000` para os dois casos, então não execute os dois ao mesmo tempo.

#### **Opção 1: Usando o JSON Server (Simulação de Backend)**

O JSON Server é útil para desenvolvimento rápido, sem precisar de um backend real.

1. **Inicie o JSON Server:**

    Na pasta `backend/json-server`, execute o comando:

    ```bash
    npm start
    ```

    Isso irá rodar o JSON Server na porta `3000`.

2. **Inicie a aplicação Angular:**

    Em outra janela do terminal, execute:

    ```bash
    ng serve
    ```

3. **Acesse a aplicação:**

    Abra o navegador e vá para [http://localhost:4200](http://localhost:4200). A aplicação estará consumindo a API simulada do JSON Server na porta `3000`.

#### **Opção 2: Usando o Backend em Java com Spring Boot**

Se preferir utilizar um backend real com Java e Spring Boot, siga os passos abaixo:

1. **Configuração do banco de dados (PostgreSQL):**

    - Configure o banco de dados PostgreSQL com o schema necessário para o projeto.
    - Ajuste as configurações de conexão no arquivo `application.properties` dentro da pasta `backend/Stock-Manager-API/src/main/resources` do backend Spring Boot.
    - Nessa pasta haverão 3 linhas que são configuráveis e devem variar dependendo do ambiente, sendo elas:

    ```bash
    spring.datasource.url=jdbc:postgresql://${DB_HOST}/${DB_NAME}
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PASSWORD}
    ```

    Em que:

    - DB_HOST = Endereço do Host
    - DB_NAME = Nome do banco de dados que será acessado
    - DB_USER = Nome do usuário que acessará o banco de dados
    - DB_PASSWORD = Senha do usuário para acessar o banco de dados

2. **Inicie a aplicação Java + Spring Boot:**

    Utilizando sua IDE de preferência, navegue até a pasta `\backend\Stock-Manager-API\src\main\java\projects\Stock\Manager\API\` e execute o arquivo:

    ```bash
    StockManagerApiApplication.java
    ```

3. **Inicie a aplicação Angular:**

    Em outra janela do terminal, execute o comando para rodar o frontend Angular:

    ```bash
    ng serve
    ```

4. **Acesse a aplicação:**

    Abra o navegador e vá para [http://localhost:4200](http://localhost:4200).

## Próximos passos

O próximo passo para finalizar o desenvolvimento da aplicação será a criação de uma interface mais robusta e a implementação de funcionalidades adicionais de gerenciamento de estoque, como autenticação de usuários e integração com outras APIs.
