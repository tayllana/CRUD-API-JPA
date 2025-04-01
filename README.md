# Santander Dev Week 2023

Java RESTful API criada para a Santander Dev Week.

## Principais Tecnologias
- **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## [Link do Figma](https://www.figma.com/file/0ZsjwjsYlYd3timxqMWlbj/SANTANDER---Projeto-Web%2FMobile?type=design&node-id=1421%3A432&mode=design&t=6dPQuerScEQH0zAn-1)

O Figma foi utilizado para a abstração do domínio desta API, sendo útil na análise e projeto da solução.

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
  class User {
    - Long id
    - String name
    - Account account
    - Feature[] features
    - Card card
    - News[] news
  }

  class Account {
    - Long id
    - String number
    - String agency
    - Number balance
    - Number limit
  }

  class Card {
    - Long id
    - String number
    - Number limit
  }

  class BaseItem {
    - Long id
    - String icon
    - String description
  }

  class News {
  }

  class Feature {
  }

  News --|> BaseItem
  Feature --|> BaseItem

  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News


```

## Configuração de Perfis (Profiles)
O Spring Boot permite configurar diferentes perfis de execução para a aplicação. Utilizamos dois arquivos de configuração:

- **`application-dev.yml`**: Contém configurações para o ambiente de desenvolvimento, utilizando o banco de dados H2.
- **`application-prd.yml`**: Contém configurações para o ambiente de produção, utilizando PostgreSQL.

Para definir qual perfil deve ser usado ao rodar a aplicação, é necessário configurar a variável de ambiente `SPRING_PROFILES_ACTIVE`. 

Isso pode ser feito no "Edit Configurations" da IDE:
![image](https://github.com/user-attachments/assets/911f2eaa-dfe2-424e-b703-b396760d7c6e)

Adicionando a seguinte configuração em "Environment Variables":
![image](https://github.com/user-attachments/assets/f17e5ef2-3204-48bf-93f3-db47c5df3c1c)

```
SPRING_PROFILES_ACTIVE=dev
```

Com essa configuração, a aplicação rodará em modo de desenvolvimento (`dev`). Para rodar em produção, basta alterar para `SPRING_PROFILES_ACTIVE=prd`.


