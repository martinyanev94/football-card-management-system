# Final Project: Creating a Football Card Management System using Spring Boot

## Overview
In this project, students will apply the knowledge gained from the course on Spring Boot by developing a RESTful API for managing football players, teams, and cards. The goal is to solidify the concepts learned throughout the course, including API design, database interaction, and services integration.

## Project Objectives
1. **Create a RESTful API** that handles CRUD operations for managing football players, teams, and cards.
2. **Integrate with a database** (PostgreSQL) to persist data.
3. **Implement exception handling** and appropriate HTTP responses.

## Project Requirements
1. **Development Environment**:
   - Java 21
   - Spring Boot 3.x
   - PostgreSQL database
   - Maven or Gradle for dependency management
   - IDE (IntelliJ IDEA, Eclipse, or similar)

2. **Dependencies**:
   - Spring Web
   - Spring Data JPA
   - PostgreSQL Driver
   - Spring Boot DevTools (for development)

## Step-by-Step Instructions

### 1. Setting Up the Project
- Use [Spring Initializr](https://start.spring.io/) to bootstrap the project:
  - Project: Maven or Gradle
  - Language: Java
  - Spring Boot: 3.x
  - Dependencies: Spring Web, Spring Data JPA, PostgreSQL Driver
  - Artifact: football
  - Name, Description, Package name: as desired.

### 2. Create Entity Classes
Define entity classes for `Player`, `Team`, and `Card` in `src/main/java/com/packt/football/model`:

```java
package com.packt.football.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int jerseyNumber;
    private String position;
    private LocalDate dateOfBirth;

    // Getters and Setters
}
```

### 3. Repositories
Create repository interfaces for each entity in `src/main/java/com/packt/football/repository`:

```java
package com.packt.football.repository;

import com.packt.football.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
```

### 4. Service Layer
Implement a service to handle business logic in `src/main/java/com/packt/football/service`:

```java
package com.packt.football.service;

import com.packt.football.model.Player;
import com.packt.football.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Additional methods for update and delete
}
```

### 5. Controller Layer
Create a REST controller in `src/main/java/com/packt/football/controller`:

```java
package com.packt.football.controller;

import com.packt.football.model.Player;
import com.packt.football.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.addPlayer(player));
    }

    // Additional endpoints for update and delete
}
```

### 6. Exception Handling
Implement custom exception handling for scenarios like not found or conflict errors.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handleNotFound(PlayerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Other exception handlers
}
```

### 7. Test the API
- Use tools like Postman or curl to test different endpoints (GET, POST, PUT, DELETE).
- Ensure to validate inputs and provide meaningful responses.

## Submission Guidelines
- Code should be well-organized and commented.
- Provide a README file with instructions on how to run the application.
- Deploy the application to a local server and verify functionality before submission.

## Evaluation Criteria
- Proper implementation of RESTful principles.
- Correctness of API functionality (endpoints, HTTP methods).
- Code quality (readability, organization, use of standards).
- Exception handling and validation.

---

By completing this project, students will have a comprehensive understanding of how to utilize Spring Boot for building a robust, production-ready application.