# 🎓 EduWise

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![SQL Server](https://img.shields.io/badge/SQL%20Server-2019+-red.svg)](https://www.microsoft.com/sql-server)
[![OpenAPI/Swagger](https://img.shields.io/badge/OpenAPI-3.0-blue.svg)](https://swagger.io/specification/)

> **Uma API REST robusta para plataforma de cursos online, construída com Spring Boot e arquitetura limpa.**

EduWise é uma API completa para gerenciamento de cursos online que oferece funcionalidades para criação de cursos, gerenciamento de usuários, inscrições de estudantes e organização de conteúdo educacional.

## 📋 Índice

- [Características](#-características)
- [Arquitetura](#-arquitetura)
- [Tecnologias](#-tecnologias)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Configuração](#-configuração)
- [Uso](#-uso)
- [API Endpoints](#-api-endpoints)
- [Documentação Swagger](#-documentação-swagger)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Validações](#-validações)
- [Tratamento de Erros](#-tratamento-de-erros)
- [Contribuindo](#-contribuindo)

## ✨ Características

- 🏗️ **Arquitetura Limpa** - Separação clara entre domínio, casos de uso e infraestrutura
- 🔐 **Validação Robusta** - Validações de entrada com Bean Validation
- 🚨 **Tratamento de Erros** - Sistema completo de tratamento de exceções
- 📊 **SQL Server** - Integração com Microsoft SQL Server
- 🔄 **RESTful API** - APIs seguindo padrões REST
- 📝 **DTOs e Mappers** - Separação entre modelos de domínio e API
- ⚡ **Spring Boot 3.5.5** - Framework moderno com Java 21

## 🏛️ Arquitetura

O projeto segue os princípios da **Clean Architecture** com as seguintes camadas:

```
├── core/
│   ├── domain/         # Entidades de negócio
│   ├── enums/          # Enumeradores
│   ├── gateway/        # Interfaces de saída
│   └── usecases/       # Casos de uso (regras de negócio)
└── infra/
    ├── beans/          # Configurações Spring
    ├── dtos/           # Objetos de transferência
    ├── exceptions/     # Tratamento de exceções
    ├── gateway/        # Implementações dos gateways
    ├── mappers/        # Conversores DTO ↔ Domain
    ├── persistence/    # Repositórios JPA
    └── presentation/   # Controllers REST
```

## 🛠️ Tecnologias

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - APIs REST
- **Microsoft SQL Server** - Banco de dados
- **Lombok** - Redução de boilerplate
- **Bean Validation** - Validações
- **Maven** - Gerenciamento de dependências

## 📋 Pré-requisitos

Antes de executar o projeto, certifique-se de ter:

- ☕ **Java 21** ou superior
- 🔧 **Maven 3.8+**
- 🗃️ **Microsoft SQL Server 2019+**
- 🖥️ **IDE** (IntelliJ IDEA, VS Code, Eclipse)

## 🚀 Instalação

### 1. Clone o repositório
```bash
git clone https://github.com/GustaHenriPe/eduwise.git
cd eduwise
```

### 2. Execute o projeto
O banco de dados será criado e migrado automaticamente pelo Flyway ao iniciar a aplicação, não é necessário criar tabelas ou rodar scripts manualmente.

Certifique-se de que o SQL Server está rodando e que as credenciais em `src/main/resources/application.yml` estão corretas para o seu ambiente local.

```bash
# Instalar dependências
mvn clean install

# Executar aplicação
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## ⚙️ Configuração

O projeto já está pronto para rodar localmente sem necessidade de configuração extra de variáveis de ambiente. O arquivo `src/main/resources/application.yml` já contém as configurações padrão para desenvolvimento.

Se desejar customizar usuário/senha do banco, edite diretamente o `application.yml`.

## 📘 Uso

### Exemplo de Criação de Usuário

```bash
curl -X POST http://localhost:8080/users/ \
  -H "Content-Type: application/json" \
  -d '{
    "name": "João Silva",
    "email": "joao@example.com",
    "passwordHash": "hash_da_senha",
    "role": "TEACHER"
  }'
```

### Exemplo de Criação de Curso

```bash
curl -X POST http://localhost:8080/courses/ \
  -H "Content-Type: application/json" \
  -d '{
    "teacherId": 1,
    "categoryId": 1,
    "title": "Curso de Java Avançado",
    "description": "Aprenda conceitos avançados de Java"
  }'
```

## 🔗 API Endpoints

### 👥 Usuários
- `GET /users/` - Listar todos os usuários
- `GET /users/{id}` - Buscar usuário por ID
- `POST /users/` - Criar novo usuário
- `PUT /users/{id}` - Atualizar usuário
- `DELETE /users/{id}` - Remover usuário

### 📚 Cursos
- `GET /courses/` - Listar todos os cursos
- `GET /courses/{id}` - Buscar curso por ID
- `POST /courses/` - Criar novo curso
- `PUT /courses/{id}` - Atualizar curso
- `DELETE /courses/{id}` - Remover curso

### 📂 Categorias de Curso
- `GET /course-categories/` - Listar categorias
- `GET /course-categories/{id}` - Buscar categoria por ID
- `POST /course-categories/` - Criar categoria
- `PUT /course-categories/{id}` - Atualizar categoria
- `DELETE /course-categories/{id}` - Remover categoria

### 📖 Módulos
- `GET /modules/` - Listar módulos
- `GET /modules/{id}` - Buscar módulo por ID
- `POST /modules/` - Criar módulo
- `PUT /modules/{id}` - Atualizar módulo
- `DELETE /modules/{id}` - Remover módulo

### 🎓 Inscrições
- `GET /student-enrollments/` - Listar inscrições
- `GET /student-enrollments/{id}` - Buscar inscrição por ID
- `POST /student-enrollments/` - Criar inscrição
- `PUT /student-enrollments/{id}` - Atualizar inscrição
- `DELETE /student-enrollments/{id}` - Cancelar inscrição

## 📖 Documentação Swagger

A documentação interativa da API é gerada automaticamente com o Springdoc OpenAPI e Swagger UI.

- **Swagger UI:**
  - Acesse: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
  - Explore e teste todos os endpoints diretamente pelo navegador.
- **OpenAPI JSON:**
  - [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

A documentação inclui exemplos de requisição/resposta, descrições dos campos, códigos de status e detalhes de erros.

## 📁 Estrutura do Projeto

```
src/main/java/com/EduWise/EduWise/
├── EduWiseApplication.java          # Classe principal
├── core/
│   ├── domain/
│   │   ├── entities/               # User, Course, Module, etc.
│   │   └── exceptions/            # Exceções de domínio
│   ├── enums/                     # Roles, ContentType
│   ├── gateway/                   # Interfaces dos repositórios
│   └── usecases/                  # Casos de uso por entidade
│       ├── user/
│       ├── course/
│       ├── module/
│       └── ...
└── infra/
    ├── beans/                     # Configurações Spring
    ├── dtos/                      # Request/Response DTOs
    ├── exceptions/                # Handler global de exceções
    ├── gateway/                   # Implementações JPA
    ├── mappers/                   # Conversores de dados
    ├── persistence/               # Repositórios JPA
    └── presentation/              # Controllers REST
```

## ✅ Validações

O projeto utiliza **Bean Validation** para garantir a integridade dos dados:

### Validações de Usuário
```java
public record UserRequest(
    @NotBlank(message = "Name cannot be null or empty")
    String name,
    
    @NotBlank @Email(message = "Email should be valid")
    String email,
    
    @NotBlank(message = "Password hash cannot be null or empty")
    String passwordHash,
    
    @NotNull(message = "Role cannot be null")
    Roles role
) {}
```

### Validações de Curso
```java
public record CourseRequest(
    @NotNull(message = "Teacher ID cannot be null")
    Long teacherId,
    
    @NotNull(message = "Category ID cannot be null")
    Long categoryId,
    
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 100)
    String title,
    
    @NotBlank(message = "Description cannot be blank")
    String description
) {}
```

## 🚨 Tratamento de Erros

Sistema robusto de tratamento de exceções com respostas padronizadas:

### Tipos de Erro Tratados
- **400 Bad Request** - Dados de entrada inválidos (validação de campos, regras de negócio, exceções de domínio, parâmetros nulos, erros de JSON, violação de constraints)
- **403 Forbidden** - Acesso proibido (ex: `UserRoleNotAllowedException`)
- **404 Not Found** - Recurso não encontrado (`UserNotFoundException`, `CourseNotFoundException`, `ModuleNotFoundException`, `LessonNotFoundException`, `EnrollmentNotFoundException`, `CourseCategoryNotFoundException`, `EntityNotFoundException`)
- **500 Internal Server Error** - Erros internos inesperados

### Formato de Resposta de Erro
```json
{
  "message": "Validation failed: email must be valid",
  "timestamp": "2025-01-16T10:30:00",
  "status": 400
}
```


## 🧠 Clean Code & SOLID no EduWise

Este projeto foi desenvolvido com foco em boas práticas de engenharia de software, visando não apenas a entrega funcional, mas também a manutenibilidade, legibilidade e escalabilidade do código. Abaixo, destaco como os princípios de Clean Code e SOLID foram aplicados no EduWise:

### Clean Code
- **Nomenclatura Clara:** Classes, métodos, variáveis e pacotes possuem nomes descritivos e autoexplicativos, facilitando o entendimento do código por qualquer desenvolvedor.
- **Métodos Enxutos:** Métodos curtos, com uma única responsabilidade, facilitando testes e manutenção.
- **Separação de Responsabilidades:** Cada camada (domínio, casos de uso, infraestrutura) tem uma função bem definida, evitando acoplamento excessivo.
- **Código Expressivo:** Uso de DTOs, mapeadores e handlers para tornar o fluxo de dados e tratamento de erros explícitos.
- **Evita Comentários Desnecessários:** O código busca ser autoexplicativo, reduzindo a necessidade de comentários redundantes.

### SOLID
- **S (Single Responsibility Principle):** Cada classe/record tem uma única responsabilidade. Exemplo: DTOs apenas transportam dados, UseCases encapsulam regras de negócio, Controllers expõem endpoints.
- **O (Open/Closed Principle):** O sistema é facilmente extensível sem modificar código existente, graças ao uso de interfaces (gateways) e injeção de dependências.
- **L (Liskov Substitution Principle):** As abstrações (interfaces) podem ser substituídas por suas implementações sem afetar o funcionamento do sistema.
- **I (Interface Segregation Principle):** Interfaces são específicas para cada contexto, evitando métodos desnecessários.
- **D (Dependency Inversion Principle):** Camadas de alto nível dependem de abstrações, não de implementações concretas. Os gateways e beans do Spring facilitam essa inversão.

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 👨‍💻 Autor

**Seu Nome**
- GitHub: [@GustaHenriPe](https://github.com/GustaHenriPe)
- LinkedIn: [Gustavo Henrique](www.linkedin.com/in/gustavo-henriquep)
- Email: guhhpj@gmail.com


⭐ **Gostou do projeto? Deixe uma estrela!** ⭐
