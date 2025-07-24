# RDS Hexagonal API

A high-quality backend API integrated with Amazon RDS (PostgreSQL) as a managed relational database.

---

## 📌 Purpose

This project showcases how to:

- Structure a backend application using Hexagonal Architecture
- Connect securely to a managed PostgreSQL database on Amazon RDS
- Expose clean RESTful APIs for user management
- Apply SOLID principles, clean code, and separation of concerns

---

## 🧱 Tech Stack

| Layer         | Technology                         |
|---------------|------------------------------------|
| Language      | Java 17                            |
| Framework     | Spring Boot 3                      |
| Architecture  | Hexagonal (Ports and Adapters)     |
| Database      | PostgreSQL (Amazon RDS)            |
| Build Tool    | Maven                              |
| Testing       | JUnit 5 + Mockito                  |
| ORM           | JPA / Hibernate                    |

---

## ☁️ Amazon RDS (PostgreSQL)

This project connects directly to a managed PostgreSQL instance provisioned via Amazon RDS.

### 🛠️ AWS Configuration Steps

1. Go to the [Amazon RDS Console](https://console.aws.amazon.com/rds/)
2. Create a new PostgreSQL DB instance (free-tier eligible)
3. Enable public access (only for test/demo purposes)
4. Add your IP in the VPC Security Group's inbound rules
5. Save host, port, database name, username, and password

### Example `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://your-rds-endpoint:5432/dbname
    username: your_rds_user
    password: your_rds_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

---

## 🧪 Testing via Postman

Import the provided Postman collection to test the API:

| Method | Endpoint       | Description         |
|--------|----------------|---------------------|
| POST   | `/users`       | Create a new user   |
| GET    | `/users`       | List all users      |

Sample payload for POST:

```json
{
  "name": "Ricardo Proença",
  "email": "ricardo@dev.com"
}
```

---

## ✅ Unit Tests

Unit tests are implemented in the `UserServiceTest.java` using:

- JUnit 5
- Mockito
- Behavior verification with BDD style

```java
@Test
void shouldCreateUserSuccessfully() {
    User user = new User("John", "john@email.com");
    when(userRepository.save(any())).thenReturn(user);

    User result = userService.createUser(user);

    assertEquals("John", result.getName());
}
```

---

## 🧩 Project Structure

```
src
├── adapters
│   └── input
│       └── rest
│           └── UserController.java
│   └── output
│       └── DataUserRepository.java
|       └── UserRepositoryAdapter.java
├── application
│   └── service
│       └── UserService.java
├── domain
│   └── model
│       └── User.java
├── infrastructure
│   └── repository
│       └── UserRepository.java
└── RdsHexagonalApiApplication.java
```

---

## 🔒 Notes

- Do **not** expose Amazon RDS publicly in production environments
- Consider using Amazon Secrets Manager and IAM roles for real projects
- Add observability: Spring Actuator, CloudWatch integration, etc.

---

## 🚀 Author

Developed by **Ricardo Proença**  
[LinkedIn](https://www.linkedin.com/in/ricardoproenca-dev/) | [GitHub](https://github.com/rpdesenvolve)