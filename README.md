# 🧙 Archive Arcane

## Sistema de Gerenciamento de Academia de Magia

### 📖 Sobre o projeto

O **Archive Arcane** é uma aplicação desenvolvida para o gerenciamento de uma academia de magia, permitindo o cadastro e gerenciamento de casas mágicas, bruxos, feitiços, criaturas mágicas e combinações de elementos.

O sistema foi desenvolvido como projeto da disciplina de Desenvolvimento Web, utilizando Spring Boot para o backend e banco de dados MySQL, seguindo a arquitetura em camadas (Controller, Service, Repository e Model).

---

# 👥 Integrantes

* Pietra Andrade
* Ana Vitória
---

# 🎯 Objetivo

Desenvolver uma API REST capaz de gerenciar uma academia de magia através de operações CRUD, consultas personalizadas, regras de negócio, geração de relatórios e internacionalização.

---

# 🛠 Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* OpenPDF
* REST API
* Thunder Client
* React.js
* Tailwind CSS
* 
* Git e GitHub

---

# 📂 Estrutura do Projeto

```
src
 └── main
      ├── controller
      ├── service
      ├── repository
      ├── model
      ├── exception
      ├── config
      ├── util
      └── resources
```

---

---
# 📂 Estrutura do Frontend
```
src/
    ├──  assets/       
    ├──  components/   
    ├──  pages/        
    ├──  context/      
    └── App.jsx
```
--- 
---
# 📚 Funcionalidades

## Casas

* Cadastro
* Consulta
* Atualização
* Exclusão
* Ranking por pontuação
* Busca por fundador

---

## Bruxos

* Cadastro
* Consulta
* Atualização
* Exclusão
* Associação com casas
* Associação com feitiços
* Busca por casa
* Busca por ano escolar
* Busca por nível de aprendizado

---

## Feitiços

* Cadastro
* Consulta
* Atualização
* Exclusão
* Busca por elemento
* Busca por tipo
* Busca por nível de dificuldade

---

## Criaturas Mágicas

* Cadastro
* Consulta
* Atualização
* Exclusão
* Busca por categoria
* Busca por habitat
* Busca por periculosidade
* Busca por casa

---

## Combinações

* Cadastro
* Consulta
* Atualização
* Exclusão
* Busca por elemento resultante
* Busca pelos elementos utilizados

---
# 🛠 Funcionalidades do Frontend
* Fluxo de Matrícula: Cadastro dinâmico de novos bruxos com customização visual baseada na casa escolhida
* Painel do Salão Comunal: Dashboard central para visualização de status do bruxo e pontos da linhagem
* Grimório Arcano: Interface interativa para estudo e domínio de feitiços
* Ranking em Tempo Real: Exibição competitiva da pontuação das casas.
---
# ⭐ Regras de Negócio

O sistema implementa regras específicas para a academia de magia.

* Cada novo bruxo cadastrado adiciona **10 pontos** à sua casa.
* Ao remover um bruxo, a pontuação da casa é atualizada automaticamente.
* O ranking das casas é ordenado pela pontuação.
* As combinações de elementos permitem gerar novos elementos mágicos.

---

# 📄 Relatório em PDF

O sistema gera automaticamente um relatório contendo:

* Quantidade de registros
* Ranking das casas
* Bruxos cadastrados
* Criaturas mágicas
* Feitiços
* Combinações de elementos

---

# 🌎 Internacionalização

A aplicação possui suporte para múltiplos idiomas.

Idiomas disponíveis:

* Português
* Inglês
* Espanhol

A seleção do idioma ocorre automaticamente através do cabeçalho **Accept-Language** enviado pelo cliente.

---

# ⚠ Tratamento de Exceções

Foi implementado um tratamento global de exceções utilizando:

* `@RestControllerAdvice`
* `GlobalExceptionHandler`

Padronizando as respostas de erro da API.

---

# ▶ Como executar

## Clonar o projeto

```bash
git clone https://github.com/pietra055/Arcane-Archive.git
```

## Entrar na pasta

```bash
cd backend
```

## Executar

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```
#  ▶ Como executar o Frontend

## Clonar o projeto
o Primeiro passo é clonar o projeto, como exemplificado anteriormente.

```bash
git clone https://github.com/pietra055/Arcane-Archive.git
```

## Entrar na pasta
```bash
cd frontend
```

## Executar
```bash
npm run dev
```
---

# Banco de Dados

MySQL

Exemplo de configuração:

```
spring.datasource.url=jdbc:mysql://localhost:3306/archive_arcane
spring.datasource.username=root
spring.datasource.password=*****
```

---

---

# Principais Endpoints

## Casas

```
GET /casas
POST /casas
PUT /casas/{id}
DELETE /casas/{id}
GET /casas/ranking-casas
GET /casas/fundador/{fundador}
```

## Bruxos

```
GET /bruxos
POST /bruxos
PUT /bruxos/{id}
DELETE /bruxos/{id}
GET /bruxos/casa/{id}
GET /bruxos/ano/{ano}
GET /bruxos/nivel/{nivel}
```

## Feitiços

```
GET /feiticos
POST /feiticos
PUT /feiticos/{id}
DELETE /feiticos/{id}
GET /feiticos/elemento/{elemento}
GET /feiticos/tipo/{tipo}
GET /feiticos/dificuldade/{nivel}
```

## Criaturas

```
GET /criaturas
POST /criaturas
PUT /criaturas/{id}
DELETE /criaturas/{id}
GET /criaturas/categoria/{categoria}
GET /criaturas/habitat/{habitat}
GET /criaturas/periculosidade/{periculosidade}
GET /criaturas/casa/{id}
```

## Combinações

```
GET /combinacoes
POST /combinacoes
PUT /combinacoes/{id}
DELETE /combinacoes/{id}
GET /combinacoes/resultado/{resultado}
GET /combinacoes/elemento1/{elemento1}
GET /combinacoes/elemento2/{elemento2}
GET /combinacoes/{elemento1}/{elemento2}
```

---

# Arquitetura

O projeto segue a arquitetura em camadas:

* Controller
* Service
* Repository
* Model

promovendo separação de responsabilidades, organização e facilidade de manutenção.

---

# Licença

Projeto desenvolvido exclusivamente para fins acadêmicos.
