# Museum Finder API 🏛️

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Swagger / OpenAPI](https://img.shields.io/badge/Swagger-OpenAPI%203-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)](http://localhost:8080/swagger-ui.html)
[![Docker](https://img.shields.io/badge/Docker-Container-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Render](https://img.shields.io/badge/Render-Deployment-46E3B7?style=for-the-badge&logo=render&logoColor=black)](https://render.com/)

> API REST desenvolvida em **Java 17** e **Spring Boot 3** para busca, geolocalização e análise estatística de museus brasileiros com base nos dados abertos do **Cadastro Nacional de Museus (IBRAM/Ministério da Cultura)**.

---

## 🚀 Live Demo (Swagger UI)

Explore e execute todas as rotas interativamente diretamente pelo navegador (ao acessar a raiz `/`, você será redirecionado automaticamente para o Swagger):

🔗 **[Acessar Swagger UI no Render](https://SEU-APP-AQUI.onrender.com)** *(substitua pela sua URL após o deploy)*

Ou localmente em: `http://localhost:8080/`

---

## 📌 Funcionalidades Principais

- 📍 **Busca Geoespacial de Proximidade:** Localiza o museu mais próximo com base em coordenadas geográficas de latitude e longitude do usuário, respeitando um raio máximo em quilômetros (`max_dist_km`).
- 🏛️ **Gestão de Museus:** Cadastro de novos museus e consulta detalhada por identificador único (ID).
- 📊 **Análise de Tipos de Acervo:** Consulta e contagem agregada de instituições por múltiplos tipos de acervo cultural (ex: história, artes, arqueologia, etc.).
- 🛡️ **Tratamento Centralizado de Exceções:** Retornos semânticos com `@ControllerAdvice` para coordenadas inválidas e recursos não encontrados.
- 🧪 **Cobertura de Testes:** Testes unitários e de integração de controllers e services utilizando JUnit 5 e Mockito.
- 📑 **Documentação Interativa:** Especificação OpenAPI 3 gerada automaticamente via SpringDoc.

---

## 🛠️ Tecnologias e Arquitetura

- **Linguagem:** Java 17
- **Framework:** Spring Boot 3.0.5
- **Módulos Spring:** Spring Web (MVC), Spring Boot Actuator
- **Documentação:** Springdoc OpenAPI (Swagger UI)
- **Testes:** JUnit 5, Mockito, MockMvc, JaCoCo
- **Containerização:** Docker (Multi-stage build com Eclipse Temurin JRE 17)
- **Arquitetura:** Camadas bem definidas (*Controller*, *Service*, *Model*, *DTO* e *ControllerAdvice*) seguindo princípios de responsabilidade única e desacoplamento.

---

## 🗺️ Especificação dos Endpoints (API REST)

### 1. Museus

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/museums` | Cadastra um novo museu no sistema |
| `GET` | `/museums/closest?lat={lat}&lng={lng}&max_dist_km={dist}` | Retorna o museu mais próximo das coordenadas dentro do raio máximo |
| `GET` | `/museums/{id}` | Busca um museu pelo ID |

#### Exemplo de criação (`POST /museums`):
```json
{
  "name": "Museu Imperial",
  "description": "Museu histórico localizado em Petrópolis, antiga residência de verão de D. Pedro II.",
  "address": "Rua da Imperatriz, 220 - Centro, Petrópolis - RJ",
  "collectionType": "História, Artes Visuais",
  "subject": "Império do Brasil",
  "url": "https://museuimperial.museus.gov.br",
  "coordinate": {
    "latitude": -22.5054,
    "longitude": -43.1764
  }
}
```

#### Exemplo de resposta da busca mais próxima (`GET /museums/closest`):
```json
{
  "name": "Museu Imperial",
  "description": "Museu histórico localizado em Petrópolis...",
  "address": "Rua da Imperatriz, 220 - Centro, Petrópolis - RJ",
  "collectionType": "História, Artes Visuais",
  "subject": "Império do Brasil",
  "url": "https://museuimperial.museus.gov.br",
  "coordinate": {
    "latitude": -22.5054,
    "longitude": -43.1764
  }
}
```

---

### 2. Acervos Culturais

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/collections/count/{typesList}` | Conta quantos museus possuem os tipos de acervo informados (separados por vírgula) |

#### Exemplo (`GET /collections/count/historia,artes`):
```json
{
  "collectionTypes": [
    "historia",
    "artes"
  ],
  "count": 492
}
```

---

## 💻 Como Executar Localmente

### Pré-requisitos
- [Git](https://git-scm.com/)
- [Java 17+](https://www.oracle.com/java/technologies/downloads/#java17) e [Maven](https://maven.apache.org/) **OU** [Docker](https://www.docker.com/)

### 1. Clonar o Repositório
```bash
git clone https://github.com/ludson96/localizador-de-museus.git
cd localizador-de-museus
```

### Opção A: Executar com Docker (Recomendado)
```bash
# Construir a imagem Docker multi-stage
docker build -t museum-finder .

# Rodar o container na porta 8080
docker run -p 8080:8080 --name museum-finder-app museum-finder
```

Acesse a documentação Swagger em: `http://localhost:8080/swagger-ui.html`

---

### Opção B: Executar com Maven
```bash
# Compilar e empacotar
mvn clean package

# Executar o JAR
java -jar target/museum-finder-1.0-SNAPSHOT.jar
```

---

## ☁️ Como Fazer o Deploy no Render

1. Crie uma conta no [Render.com](https://render.com/).
2. Conecte sua conta do GitHub e clique em **New +** ➔ **Web Service**.
3. Selecione o repositório `localizador-de-museus`.
4. Em **Language / Environment**, escolha **Docker**.
5. O Render detectará automaticamente o `Dockerfile` com multi-stage build.
6. A aplicação já está configurada para ler dinamicamente a variável de ambiente `PORT` provida pelo Render.
7. Clique em **Create Web Service**.
8. Assim que a build concluir, acesse `https://<seu-subdominio>.onrender.com/swagger-ui.html`!

---

## 📄 Licença

Distribuído sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

Desenvolvido por [Ludson](https://github.com/ludson96) 🚀
