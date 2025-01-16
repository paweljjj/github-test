# GitHub Sample Tests

This project contains some basic tests of GitHub.com. It uses TestNG, Playwright and SpringBoot.

## Requirements
* Java 21 LTS
* Maven

## Running the tests

Run all the tests:
```bash
mvn test
```
Run a group of tests:
```bash
mvn test -Dgroups=repository
```

## Configuration files:
- TestNG configuration file: `src/test/resources/testng.xml`.
- Spring and Playwright configuration file: `src/test/resources/application.properties`.
 