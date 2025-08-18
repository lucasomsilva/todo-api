# Todo API

API REST para gerenciamento de tarefas (to-do list), desenvolvida em Spring Boot.

## Funcionalidades

- Criar tarefas
- Listar todas as tarefas
- Atualizar tarefas
- Remover tarefas

## Endpoints

### Criar tarefa
- **POST** `/todo`
- **Body:**
  ```json
  {
    "titulo": "Título da tarefa",
    "descricao": "Descrição da tarefa"
  }
  ```
- **Resposta:** 201 Created
  ```json
  {
    "id": 1,
    "titulo": "Título da tarefa",
    "descricao": "Descrição da tarefa",
    "status": "PENDENTE",
    "createdAt": "2025-08-17T12:00:00"
  }
  ```
- **Validações:**
  - `titulo` e `descricao` são obrigatórios.

### Listar tarefas
- **GET** `/todo`
- **Resposta:** 200 OK
  ```json
  [
    {
      "id": 1,
      "titulo": "Título da tarefa",
      "descricao": "Descrição da tarefa",
      "status": "PENDENTE",
      "createdAt": "2025-08-17T12:00:00",
      "updatedAt": null
    }
  ]
  ```
- **Validações:**
  - Retorna erro se não houver tarefas cadastradas.

### Atualizar tarefa
- **PUT** `/todo/{id}`
- **Body:**
  ```json
  {
    "titulo": "Novo título",
    "descricao": "Nova descrição",
    "status": "ANDAMENTO"
  }
  ```
- **Resposta:** 200 OK
  ```json
  {
    "id": 1,
    "titulo": "Novo título",
    "descricao": "Nova descrição",
    "status": "ANDAMENTO",
    "createdAt": "2025-08-17T12:00:00",
    "updatedAt": "2025-08-17T13:00:00"
  }
  ```
- **Validações:**
  - Retorna erro se a tarefa não existir.
  - Campos não enviados mantêm o valor anterior.

### Remover tarefa
- **DELETE** `/todo/{id}`
- **Resposta:** 204 No Content
- **Validações:**
  - Retorna erro se a tarefa não existir.

## Status possíveis
- `PENDENTE`
- `ANDAMENTO`
- `CONCLUIDA`

## Como rodar o projeto

### Pré-requisitos
- Java 21
- Maven

### Passos
1. Clone o repositório:
   ```sh
   git clone <url-do-repositorio>
   cd todo-api
   ```
2. Configure o banco de dados no arquivo `src/main/resources/application.properties` (já configurado para SQL Server na nuvem):
   ```properties
   spring.datasource.url=jdbc:sqlserver://todo-api.database.windows.net:1433;database=TodoListDB;encrypt=true;trustServerCertificate=true;loginTimeout=30;
   spring.datasource.username=springuser@todo-api
   spring.datasource.password=API-todo2025
   spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
   ```
3. Execute a aplicação:
   - Windows:
     ```sh
     .\mvnw.cmd spring-boot:run
     ```
   - Linux/Mac:
     ```sh
     ./mvnw spring-boot:run
     ```
4. Acesse: `http://localhost:8080/todo`

## Estrutura do banco de dados
A tabela `task` é criada automaticamente. Exemplo de estrutura:
- id (int, PK)
- titulo (varchar(50), obrigatório)
- descricao (nvarchar, obrigatório)
- status (nvarchar, obrigatório, default 'PENDENTE')
- created_at (datetime2)
- updated_at (datetime2)

## Observações
- O projeto já está pronto para uso com SQL Server na nuvem.
- Para usar outro banco, ajuste as configurações em `application.properties`.
- O projeto utiliza validação de dados e tratamento de exceções customizadas.

## Testes
Para rodar os testes:
```sh
./mvnw test
```

---

Dúvidas? Abra uma issue ou entre em contato com o mantenedor.
