# Profile Technical Test

### Purpose

Technical test is an application that provides the current price at the indicated time of a product price inventory. The
objective of this project is developing the initial technical test of Profile selection process.

### Project structure

This project is structured following the hexagonal architecture. It is divided in 3 principal folders:

* ``application``: This folder contains code related to the uses of cases, which will interact with the domain elements.

* ``domain``: This folder contains the domain models, the services, and the definition of the operations that must 
  be done by the infrastructure.

* ``infra``: This folder contains the implementations for the external data operations, such as persistence or event producing.

### Recommended prerequisites

For building and running the app you will need:

* Intellij
* Maven plugin.
* Java SDK 17

### Running locally

Using IntelliJ: ``Run -> Run Demo Application 'Test'``

Using command line: ``mvn spring-boot:run``

### Automated tests

The tests are contained in tests folder. They are integration tests, that uses an H2 database, which will be filled
with data before running the tests.

The tests 1 to 5, that had been demanded in the definition on the technical  test, checks the success responses and verify 
the content of the response body content. There are also  additional tests to check the "Bad Request" and "Not Found" response code.

Execute test locally: ``mvn test``

### Links of interest

[![Linkedin joelcb](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/joelcb)