# Repositório do projeto `Localizador de Museus` 🏛️️

Repositório possuí projeto desenvolvido abordando conceitos
de `Injeção de dependencia`, `API REST com Spring`, `Spring Boot`, `Exceções`, `Testes com JUnit5` e `Docker`.

## Informações de aprendizados

- Primeiro projeto usando `Spring e seus complementos`;
- Primeiro projeto em `Java` usando `API REST`;
- Primeiro projeto em `Java` usando `Docker`;
- Primeiro projeto com `testes`.

## Linguagens e ferramentas usadas

[![Git][Git-logo]][Git-url]
[![Java][Java-logo]][Java-url]
[![Apache Maven][Apache Maven-logo]][Apache Maven-url]
[![Docker][Docker-logo]][Docker-url]
[![Spring][Spring-logo]][Spring-url]
[![Spring Boot][Spring boot-logo]][Spring boot-url]

## O que foi desenvolvido

Neste projeto implementei uma API cuja principal funcionalidade é facilitar a busca por museus baseada em sua localização. Os dados foram retirados [desta](http://dados.cultura.gov.br/dataset/series-historicas-cadastro-nacional-de-museus) série histórica.

## Habilidades trabalhadas

- Criar classes de controle e suas rotas
- Criar classes de serviço
- Utilizar injeção de dependências
- Trabalhar com exceções customizadas
- Tratar exceções da API através de gerenciadores de erros
- Implementar testes unitários para cobertura de código
- Criar uma configuração Docker para sua aplicação

## Instruções para instalar e rodar

<details>

1. Clone o repositório (recomendado usar em SSH) e entre na pasta:

    ```bash
    git clone git@github.com:ludson96/localizador-de-museus.git
    cd sistema-votacao
    ```

1. Instale as dependências:

    ```bash
    mvn install
    ```
   
1. Caso não tenha java ou maven instalados, basta executar o `Docker` com o comando abaixo:

   ```bash
   #Comando para gerar imagem.
   docker build . -t multi-stage-image
   
   #Comando para executar o container usando a imagem gerada anteriormente. Irá executar o servidor Spring automaticamente e podendo ignorar o passo abaixo.
   docker run -p 8080:8080 --name multi-stage-container multi-stage-image
   ```
1. Para executar o servidor spring:

    ```bash
   mvn clean package
   java -jar target/museum-finder-1.0-SNAPSHOT.jar
    ```

</details>

[//]: # (## Detalhamento de execução)

[//]: # ()
[//]: # (<details>)

[//]: # ()
[//]: # (  <summary><strong>Museus</strong></summary>)

[//]: # ()
[//]: # (### Endpoints)

[//]: # ()
[//]: # (Abaixo você pode conferir um detalhamento dos endpoints utilizados no projeto. Para realizar as requisições HTTP e consultar o comportamento de cada endpoint, você pode utilizar o [Insomnia]&#40;https://insomnia.rest/download&#41;.)

[//]: # ()
[//]: # (### POST /museums)

[//]: # ()
[//]: # (- Retorna todos os carros registrados no banco de dados.)

[//]: # (- URL: `http://localhost:PORT/cars`)

[//]: # ()
[//]: # (### POST /cars)

[//]: # ()
[//]: # (- Adiciona um novo carro ao banco de dados.)

[//]: # (- URL: `http://localhost:PORT/cars`)

[//]: # (- O corpo da requisição deve seguir o formato abaixo:)

[//]: # ()
[//]: # (```)

[//]: # ({)

[//]: # (  "model": "Marea",)

[//]: # (  "year": 2002,)

[//]: # (  "color": "Black",)

[//]: # (  "status": true, // Não é obrigatório. Se não for inserido, o valor do status será 'false')

[//]: # (  "buyValue": 15.990,)

[//]: # (  "doorsQty": 4,)

[//]: # (  "seatsQty": 5)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (### GET /cars/:id)

[//]: # ()
[//]: # (- Retorna o carro cujo id foi passado na URL.)

[//]: # (- Exemplo de URL: `http://localhost:PORT/cars/634852326b35b59438fbea2f`)

[//]: # ()
[//]: # (### PUT /cars/:id)

[//]: # ()
[//]: # (- Atualiza o carro cujo id foi passado na URL.)

[//]: # (- Exemplo de URL: `http://localhost:PORT/cars/634852326b35b59438fbea2f`)

[//]: # (- O corpo da requisição deve seguir o formato abaixo:)

[//]: # ()
[//]: # (```)

[//]: # ({)

[//]: # (  "model": "Marea",)

[//]: # (  "year": 1992,)

[//]: # (  "color": "Red",)

[//]: # (  "status": true, // Não é obrigatório. Se não for inserido, o valor do status será 'false')

[//]: # (  "buyValue": 12.000,)

[//]: # (  "doorsQty": 2,)

[//]: # (  "seatsQty": 5)

[//]: # (})

[//]: # (```)

[//]: # ()
[//]: # (### DELETE /cars/:id)

[//]: # ()
[//]: # (- Remove do banco de dados o carro cujo id foi passado na URL.)

[//]: # (- Exemplo de URL: `http://localhost:PORT/cars/634852326b35b59438fbea2f`)

[//]: # ()
[//]: # (</details>)

[Git-logo]: https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white
[Git-url]: https://git-scm.com

[Java-logo]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/pt-BR/

[Apache Maven-logo]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[Apache Maven-url]: https://maven.apache.org/

[Docker-logo]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white
[Docker-url]: https://www.docker.com

[Spring-logo]: https://img.shields.io/badge/Spring-6DB33F.svg?style=for-the-badge&logo=Spring&logoColor=white
[Spring-url]: https://spring.io/

[Spring boot-logo]:https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white
[Spring boot-url]: https://spring.io/projects/spring-boot
