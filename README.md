# Spring Boot entry
### Spring Framework (problem solve)
As a framework, the key feature is Dependency Injection (DI) and Inversion of Control (IOC) that allow develop loosely coupled applications make easier to unit test.

`@Component` - tell Spring: manage this bean!
	
`@Autowired` - tell Spring: find the correct match and inject this bean

Spring Framework was built using DI with Spring modules like Spring JDBC, Spring MVC, Spring AOP, Spring Test, etc. With this module structure Spring reduces boilerplate code, code duplication and promote decoupling and unit testability. Spring also has a good integration with other framework.

Basic Spring base project:
- Spring - core, beans, context, aop
- Web MVC - (Spring MVC)
- Jackson - for JSON Binding
- Validation - Hibernate Validator, Validation API
- Embedded Servlet Container - Tomcat
- Logging - logback, slf4j

### Spring Boot
Spring Boot is a project to allow create new applications easy and without waste time with configuration, based on frameworks available on the CLASSPATH Spring Boot can provide basic configuration.

`@SpringBootApplication`

To manage many configurations necessary to build an application Spring Boot has some STARTER project, a set of dependency that is ready to use without additional configuration.

- spring-boot-starter-web - Web & RESTful applications
- spring-boot-starter-test - Unit testing and Integration Testing
- spring-boot-starter-jdbc - Traditional JDBC
- spring-boot-starter-security - Authentication and Authorization using Spring Security
- spring-boot-starter-data-jpa - Spring Data JPA with Hibernate
- spring-boot-starter-cache - Enabling Spring Framework’s caching support
- spring-boot-starter-data-rest - Expose Simple REST Services using Spring Data REST
- spring-boot-starter-web-services - SOAP Web Services

Embedded container, also provide an embedded container Tomcat or Jetty

### MAVEN
>by me:
"Tool which you use to manage the libraries, and much more!"
> by Apache:
"can be used for building and managing any Java-based project."
	
#### Quickly overview:

* Making the build process easy
	- Manage dependency, run locally (Tomcat or Jetty)
* Providing a uniform build system
	- Build jar, war or ear; deploy in N environment
* Providing quality project information
	- Run unit test, generate reports;
* Providing guidelines for best practices development
	- PMD, Coverage;
* Allowing transparent migration to new features
	- generate projects based on Archetype
	
#### Build Life Cycle

- Validate
- Compile
- Test
- Package
- Integration Test
- Verify
- Install
- Deploy

### MongoDB

### Mokito 

### Practical Time

Tools used:
- Java8
- Eclipse 
- STS eclipse plugin
- Maven eclipse plugin
- MongoDB (https://www.mongodb.com/cloud)
- Postman (https://www.getpostman.com/)


### Reference
* Spring Initializer
  	- https://start.spring.io/
	- Project: _Maven Project_
	- Language: _Java_
	- Spring Boot version: _latest_
	- Group: _es.sopra-training_
	- Name: _boot-news_
	- Description: 
	- Dependencies: _Web_

=> Generate the project, download and unzip, import as Maven project.

- Spring
- Spring-web
	configuration
	usage
- Spring-data
	configuration
	methods
	usage
	

