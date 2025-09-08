# Config Client

This is a Spring Boot application that acts as a client for the Spring Cloud Config Server. It fetches its configuration from a remote config server at startup.

## Features
- Loads configuration from a centralized config server
- Demonstrates dynamic configuration management
- REST API endpoints (see `ConfigController`)

## Prerequisites
- Java 17+
- Maven
- Running Spring Cloud Config Server

## Setup
1. Ensure the config server is running and accessible.
2. Update `src/main/resources/application.properties` to point to your config server (e.g., `spring.cloud.config.uri=http://localhost:8889`).
3. Build the project:
   ```bash
   mvn clean package
   ```
4. Run the client:
   ```bash
   java -jar target/config-client-1.0.0.jar
   ```

## Usage
- The client will fetch configuration from the config server based on its application name and profile.
- Access REST endpoints as defined in `ConfigController`.

## Troubleshooting
- If startup fails, check the config server URL and ensure the config repo contains the correct config files.

