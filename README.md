
# ![WS Work Logo](https://wswork.com.br/assets/logos/ws_logo.svg) 

# Aplicação de Teste Técnico - WS Work

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
[![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Flyway](https://img.shields.io/badge/Flyway-E32322?style=for-the-badge&logo=flyway&logoColor=white)](https://flywaydb.org/)

## Descrição

Esta aplicação foi desenvolvida como parte de um teste técnico para a empresa [WS Work](https://wswork.com.br/). A aplicação utiliza uma arquitetura de camadas simples, desenvolvida em Java e Kotlin, utilizando o framework Spring e Flyway para o controle de migrations.

## Tecnologias Utilizadas

- **Java**
- **Kotlin**
- **Spring Framework**
- **Flyway**
- **Docker**

## Estrutura do Projeto

A arquitetura de camadas utilizada nesta aplicação é composta por:

1. **Camada de Apresentação (Presentation Layer)**: Contém os controladores que lidam com as requisições HTTP.
2. **Camada de Serviço (Service Layer)**: Contém a lógica de negócios da aplicação.
3. **Camada de Dados (Data Layer)**: Contém os repositórios e entidades que interagem com o banco de dados.

```plaintext
src/
├── main/
│   ├── java/
│   │   └── me.ghisiluizgustavo/
│   │       └── testewswork/
│   │           ├── controller/
│   │           ├── dto/
│   │           ├── entidade/
│   │           ├── service/
│   │           └── repositorio/
│   └── resources/
│       └── db/
│           └── migration/
│               └── V1_0__create_initial_tables.sql
└── 
```

## Configuração do Ambiente

Para configurar o ambiente de desenvolvimento, siga os passos abaixo:

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/ghisiluizgustavo/teste-ws-work.git
    ```

2. **Navegue até o diretório do projeto**:
    ```bash
    cd teste-ws-work
    ```

3. **Configure o banco de dados**:
    - Será necessário rodar o arquivo docker-compose.yml
   

4. **Execute as migrations**:
    - Flyway será executado automaticamente ao iniciar a aplicação e aplicará as migrations na inicialização.


5. **Execute a aplicação**:
    ```bash
    ./mvnw spring-boot:run
    ```