# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

**My Recipe Book** is a Spring Boot 4.0.5 backend REST API (Java 21) backed by PostgreSQL. The project is in early development — no controllers, entities, or service layers exist yet.

## Build & Run Commands

All commands run from the `backend/` directory using the Maven wrapper:

```bash
# Run the application
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=RecipebookApplicationTests

# Build JAR
./mvnw package

# Clean build
./mvnw clean package
```

## Architecture

**Stack**: Spring Boot Web MVC + PostgreSQL + Lombok

**Package root**: `com.my.recipebook`

**Standard Spring layered architecture** (to be built out):
- Controllers (`@RestController`) — HTTP request handling
- Services (`@Service`) — business logic
- Repositories (`@Repository` / Spring Data JPA) — data access
- Entities (`@Entity`) — JPA models mapped to PostgreSQL

**Entry point**: `backend/src/main/java/com/my/recipebook/RecipebookApplication.java`

**Configuration**: `backend/src/main/resources/application.properties` — currently only sets `spring.application.name=recipebook`. PostgreSQL connection properties need to be added here before running.

## Key Setup Notes

- The `.mvn/wrapper/` directory is missing — run `mvn wrapper:wrapper` to regenerate if `./mvnw` fails.
- PostgreSQL is a runtime dependency but no connection is configured yet. Add `spring.datasource.*` properties to `application.properties` before starting the app.
- Lombok is configured as an annotation processor; ensure your IDE has the Lombok plugin enabled.
