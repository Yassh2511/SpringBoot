# SpringBoot Demo Application

A complete Spring Boot application with all essential components including REST API, JPA, H2 Database, and layered architecture.

## Project Structure

```
springboot-demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/springboot/
│   │   │   ├── SpringBootDemoApplication.java  # Main starter class
│   │   │   ├── controller/                      # REST Controllers
│   │   │   │   ├── UserController.java
│   │   │   │   └── WelcomeController.java
│   │   │   ├── service/                         # Service layer
│   │   │   │   └── UserService.java
│   │   │   ├── repository/                      # Data access layer
│   │   │   │   └── UserRepository.java
│   │   │   └── model/                           # Entity classes
│   │   │       └── User.java
│   │   └── resources/
│   │       └── application.properties           # Configuration
│   └── test/
│       └── java/com/example/springboot/
├── pom.xml                                      # Maven configuration
└── .gitignore

```

## Technologies Used

- **Spring Boot 3.1.0** - Application framework
- **Spring Web** - REST API development
- **Spring Data JPA** - Database abstraction layer
- **H2 Database** - In-memory database
- **Maven** - Build and dependency management
- **Java 17** - Programming language

## Features

### 1. Main Application
- **SpringBootDemoApplication.java**: Entry point with `@SpringBootApplication` annotation

### 2. REST Controllers
- **WelcomeController**: Basic endpoints
  - `GET /` - Welcome message
  - `GET /health` - Health check

- **UserController**: Full CRUD operations for users
  - `GET /api/users` - Get all users
  - `GET /api/users/{id}` - Get user by ID
  - `POST /api/users` - Create new user
  - `PUT /api/users/{id}` - Update user
  - `DELETE /api/users/{id}` - Delete user

### 3. Service Layer
- **UserService**: Business logic for user operations

### 4. Data Layer
- **UserRepository**: JPA repository for database operations
- **User Entity**: JPA entity with id, name, and email fields

### 5. Database
- H2 in-memory database
- H2 Console accessible at: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Build the Application

```bash
mvn clean package
```

### Run the Application

```bash
java -jar target/springboot-demo-1.0.0.jar
```

Or using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Examples

### Welcome Endpoint
```bash
curl http://localhost:8080/
# Response: Welcome to Spring Boot Demo Application!
```

### Health Check
```bash
curl http://localhost:8080/health
# Response: Application is running!
```

### Create a User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@example.com"}'
# Response: {"id":1,"name":"John Doe","email":"john@example.com"}
```

### Get All Users
```bash
curl http://localhost:8080/api/users
# Response: [{"id":1,"name":"John Doe","email":"john@example.com"}]
```

### Get User by ID
```bash
curl http://localhost:8080/api/users/1
# Response: {"id":1,"name":"John Doe","email":"john@example.com"}
```

### Update a User
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane Doe","email":"jane@example.com"}'
# Response: {"id":1,"name":"Jane Doe","email":"jane@example.com"}
```

### Delete a User
```bash
curl -X DELETE http://localhost:8080/api/users/1
# Response: 204 No Content
```

## Configuration

The application properties can be found in `src/main/resources/application.properties`:

- Server port: 8080
- H2 Console: enabled
- JPA: auto-create schema, show SQL queries

## Development in IntelliJ IDEA

### Import Project
1. Open IntelliJ IDEA
2. Select "File" > "Open" or "Import Project"
3. Navigate to the project directory and select `pom.xml`
4. Click "Open as Project"
5. Wait for Maven to download dependencies

### Run Configuration
1. IntelliJ will automatically detect the Spring Boot application
2. Click the green play button next to `SpringBootDemoApplication` class
3. Or create a run configuration:
   - Go to "Run" > "Edit Configurations"
   - Click "+" and select "Application"
   - Set main class: `com.example.springboot.SpringBootDemoApplication`
   - Click "OK" and run

### Hot Reload (Optional)
Add Spring Boot DevTools dependency for automatic restart on code changes.

## Project Components Explained

### @SpringBootApplication
Main annotation that combines:
- `@Configuration` - Spring configuration
- `@EnableAutoConfiguration` - Auto-configures Spring application
- `@ComponentScan` - Scans for components in the package

### @RestController
Combines `@Controller` and `@ResponseBody` for REST APIs

### @Service
Marks the service layer containing business logic

### @Repository
Marks the data access layer

### @Entity
Marks a JPA entity that maps to a database table

## License

This project is open source and available for educational purposes.
