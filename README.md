# 📌 Todo API

Esta é uma **API RESTful** para gerenciamento de tarefas (**to-do list**) desenvolvida em **Java** com o framework **Spring Boot**.  
Ela permite **criar, visualizar, atualizar e deletar tarefas**.

---

## 🚀 Funcionalidades

- **POST /tasks** → Cria uma nova tarefa.  
- **GET /tasks** → Retorna todas as tarefas existentes.  
- **PUT /tasks/{id}** → Atualiza uma tarefa existente.  
- **DELETE /tasks/{id}** → Remove uma tarefa com base no ID fornecido.  

---

## 🛠 Tecnologias

- Java 21  
- Spring Boot 3.3.1  
- Maven  
- JPA / Hibernate  
- SQL Server  

---

## ⚙️ Como Rodar o Projeto

### ✅ Pré-requisitos
- **JDK 21**  
- **Maven 3.8.1 ou superior**  

### 🔧 Configuração do Banco de Dados
O banco de dados está hospedado na nuvem.  
Configure as credenciais de acesso no seu sistema como **variáveis de ambiente**:

- `SPRING_DATASOURCE_USERNAME` → Usuário do banco  
- `SPRING_DATASOURCE_PASSWORD` → Senha do banco  

A **URL de conexão** e demais configs já estão no `application.properties`.  

⚠️ O arquivo **`data.sql`** em `src/main/resources` é executado automaticamente para criar a tabela `task` na inicialização.

---

### ▶️ Executando a Aplicação

Clone o repositório:

```bash
git clone https://github.com/lucasomsilva/todo-api.git
```

Entre no diretório do projeto:

```bash
cd todo-api
```

Rode a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em:  
👉 [http://localhost:8080](http://localhost:8080)

---

## 📬 Exemplos de Requisições

### 1️⃣ Criar uma Tarefa
**POST /tasks**

```http
POST http://localhost:8080/tasks
Content-Type: application/json
```

**Body**
```json
{
  "titulo": "Escrever o README",
  "descricao": "Documentar a API para o GitHub"
}
```

✅ Resposta **201 Created**
```json
{
  "id": 1,
  "titulo": "Escrever o README",
  "descricao": "Documentar a API para o GitHub",
  "status": "PENDENTE",
  "createdAt": "2025-08-18T10:30:00"
}
```

❌ Resposta **400 Bad Request**
```json
{
	"timestamp": "2025-08-18T17:06:09.548+00:00",
	"status": 400,
	"error": "Bad Request",
	"path": "/todo"
}
```

---

### 2️⃣ Listar Todas as Tarefas
**GET /tasks**

✅ Resposta **200 OK**
```json
[
  {
    "id": 1,
    "titulo": "Escrever o README",
    "descricao": "Documentar a API para o GitHub",
    "status": "PENDENTE",
    "createdAt": "2025-08-18T10:30:00"
  },
  {
    "id": 2,
    "titulo": "Corrigir bugs",
    "descricao": "Revisar o código e corrigir possíveis falhas",
    "status": "EM_ANDAMENTO",
    "createdAt": "2025-08-18T11:00:00"
  }
]
```

✅ Resposta **204 No Content** (lista vazia)
```json
[]
```

---

### 3️⃣ Atualizar uma Tarefa
**PUT /tasks/{id}**

```http
PUT http://localhost:8080/tasks/1
Content-Type: application/json
```

**Body**
```json
{
  "titulo": "Corrigir bugs da API",
  "status": "CONCLUIDA"
}
```

✅ Resposta **200 OK**
```json
{
  "id": 1,
  "titulo": "Corrigir bugs da API",
  "descricao": "Documentar a API para o GitHub",
  "status": "CONCLUIDA",
  "createdAt": "2025-08-18T10:30:00",
  "updatedAt": "2025-08-18T12:00:00"
}
```

❌ Resposta **404 Not Found**
```json
{
  "status": 404,
  "error": "Recurso não encontrado",
  "timestamp": "2025-08-18T12:05:00Z"
}
```

---

### 4️⃣ Excluir uma Tarefa
**DELETE /tasks/{id}**

```http
DELETE http://localhost:8080/tasks/1
```

✅ Resposta **204 No Content**  
(Sem corpo na resposta)

❌ Resposta **404 Not Found**
```json
{
	"timestamp": "2025-08-18T17:01:00.499+00:00",
	"status": 404,
	"error": "Not Found",
	"path": "/todo/2"
}
```

---

