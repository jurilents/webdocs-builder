# DocUni

A group project created in 2021 by students from the MIT-21 group of Taras Shevchenko National University of Kyiv.

### References

* [Design in Figma](https://www.figma.com/file/F9US9vZdzJbe7ysFbbPoN4/%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD%D0%B8%D0%B7%D0%B0%D1%82%D0%BE%D1%80)
* [Database Diagram](https://lucid.app/lucidchart/dd22ed6b-9351-41f3-8b3f-719b0732baf8/edit?shared=true)

**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

## Getting Started

To run this example application, run the following commands:

```bash
./gradlew bootRun
```

This will likely fail. You need to configure a PostgreSQL database with the following settings
in `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://192.168.99.100:5432/db_name
spring.datasource.username=postgres
spring.datasource.password=mysecretpassword
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create
```

And start PostgreSQL in a Docker container:

```bash
docker pull postgres:11
docker run --name dev-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres:11
# CREATE db db_name
docker exec dev-postgres psql -U postgres -c"CREATE DATABASE db_name" postgres
```

### Base Template

[Spring Boot with PostgreSQL, Flyway, and JSONB](https://developer.okta.com/blog/2019/02/20/spring-boot-with-postgresql-flyway-jsonb)
to see how this app was created.

This example uses [Okta's Spring Boot Starter](https://github.com/okta/okta-spring-boot).

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.5/maven-plugin/reference/html/#build-image)
* [Spring Integration JPA Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/jpa.html)
* [Spring Integration Test Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/testing.html)
* [Spring Integration HTTP Module Reference Guide](https://docs.spring.io/spring-integration/reference/html/http.html)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#howto-use-exposing-spring-data-repositories-rest-endpoint)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Integration](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-integration)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#using-boot-devtools)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.4.5/reference/htmlsingle/#boot-features-spring-mvc-template-engines)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Integrating Data](https://spring.io/guides/gs/integration/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

-------------------------------------------------------

## Developers

__Team-lead:__ [Yermakov Yurii](https://github.com/jurilents) \
__Testing:__ [Baida Danylo](https://github.com/kakoytohren)

__Backend:__

- [Fit\` Vladyslav](https://github.com/TweekerGit)
- [Kulchitsky Dmytro](https://github.com/KulchytskiyDmytro)
- [Lunin Leonid](https://github.com/lunleo)

__Frontend:__

- [Khomik Bohdan]()
- [Shmat Kateryna]()
