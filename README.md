# CRUD Simples em Java Spring Boot 3.2

Este projeto é destinado ao aprendizado, onde foi desenvolvida uma aplicação CRUD simples em Java 22, utilizando o framework Spring Boot 3.2. A implementação aborda o caso de implementação de relacionamento One-to-One entre as entidades Person e Address.

## Descrição

O projeto consiste em uma aplicação CRUD básica, demonstrando o uso do Spring Boot para gerenciar um servidor e integrar um banco de dados PostgreSQL. As principais tecnologias e serviços utilizados neste projeto incluem:

- **JPA**: Para o gerenciamento das classes e da base de dados.
- **PostgreSQL Starter**: Para garantir a integração com o banco de dados PostgreSQL.
- **Validation**: Para lidar com as validações dos dados.
- **Spring Web**: Para gerenciar o servidor e fornecer serviços web.

## Funcionalidades

- Criação, leitura, atualização e exclusão (CRUD) de registros de pessoas e endereços.
- Implementação de relacionamento One-to-One entre as entidades Person e Address.

## Instalação

Para executar o projeto localmente, siga os passos abaixo:

1. Clone este repositório.
2. Certifique-se de ter o PostgreSQL instalado e configurado.
3. Configure as informações do banco de dados no arquivo `application.properties`.
4. Execute a aplicação usando sua IDE de preferência ou através do comando `./mvnw spring-boot:run`.

## Contribuição

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, por favor, abra uma issue para discutir as mudanças propostas.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
