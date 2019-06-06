# SpringBoot Workshop at BBVA

This is a RestFull API App with JWT security, that I have dictated in a workshop at BBVA.

## About the code

Rest API App developed with Spring Boot. It has Actuator, Web, JPA and Security modules.

* [Spring Web Starter](https://spring.io/projects/spring-boot): Build web, including RESTful, applications using Spring MVC. Uses Tomcat as the default embedded container.
* [Spring Data JPA](https://spring.io/projects/spring-boot): Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
* [Spring Security](https://spring.io/projects/spring-boot): Highly customizable authentication and access-control framework for Spring applications.
* [Spring Boot Actuator](https://spring.io/projects/spring-boot): Supports built in (or custom) endpoints that let you monitor and manage your application - such as application health, metrics, sessions, etc.

### Requirements
Install dependecies
```console
$ mvn install
```

### Running the application
```console
$ mvn spring-boot:run
```
Test the status app in: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
