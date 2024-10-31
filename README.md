# Stock Manager

Um sistema de gerenciamento de produtos (CRUD) que permite adicionar, visualizar, editar e excluir produtos de um estoque. O projeto foi desenvolvido com Angular e utiliza JSON para simular um backend.

## Tecnologias Utilizadas

- [Angular](https://angular.io/) - Framework para construção de aplicações web
- [TypeScript](https://www.typescriptlang.org/) - Linguagem de programação baseada em JavaScript
- [JSON Server](https://github.com/typicode/json-server) - Simulador de API RESTful

## Funcionalidades

- Adicionar produtos ao estoque
- Visualizar lista de produtos
- Editar informações dos produtos
- Excluir produtos do estoque

## Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/DiegoVSC42/Stock-Manager.git
   cd Stock-Manager
   ```

2. **Instale as dependências:**
   ```bash
   npm install
   ```

3. **Inicie o JSON Server na pasta "backend":**
   Inicie o JSON Server através do comando:
   ```bash
   npm start
   ```

4. **Inicie a aplicação Angular:**
   ```bash
   ng serve
   ```

5. **Acesse a aplicação:**
   Abra seu navegador e vá para `http://localhost:4200`.

## Próximos passos
O próximo passo para finalizar o desenvolvimento da aplicação será a criação de um backend real utilizando Java e Spring Boot, ou seja, uma API. Essa API vai fazer comunicação com um banco de dados PostgreSQL e retornar os dados para o usuário.
