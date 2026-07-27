# Product Management REST API

A Spring Boot REST API for managing products — the Module 4 mini project.
Demonstrates layered architecture, request validation, centralized exception
handling, meaningful HTTP status codes, and Swagger/OpenAPI documentation.

## Architecture

```
Controller  ->  Service  ->  In-Memory Store
```

`ProductController` is intentionally thin — it only parses requests and maps
results to HTTP responses. All business rules live in `ProductServiceImpl`.
Data is held in a `ConcurrentHashMap` for this module; in the next module,
`ProductServiceImpl` would be swapped for a version that talks to a
`ProductRepository` backed by a real database, with no changes needed to the
controller:

```
Controller  ->  Service  ->  Repository  ->  Database
```

## Project layout

```
src/main/java/com/example/productapi/
├── ProductApiApplication.java     # Spring Boot entry point
├── controller/ProductController.java
├── service/ProductService.java        (interface)
├── service/ProductServiceImpl.java    (in-memory implementation)
├── model/Product.java              # domain model
├── dto/ProductRequest.java         # validated create/update payload
├── dto/ProductResponse.java         # what's returned to clients
├── dto/ErrorResponse.java          # consistent error body shape
├── exception/ProductNotFoundException.java
├── exception/GlobalExceptionHandler.java   (@RestControllerAdvice)
└── config/OpenApiConfig.java       # Swagger metadata
```

## Endpoints

| Method | Endpoint         | Purpose             | Success | Failure                  |
|--------|------------------|----------------------|---------|---------------------------|
| GET    | `/products`      | List all products    | 200 OK  | —                         |
| GET    | `/products/{id}` | Get one product       | 200 OK  | 404 if not found          |
| POST   | `/products`      | Create a product      | 201 Created | 400 on validation failure |
| PUT    | `/products/{id}` | Update a product      | 200 OK  | 404 / 400                 |
| DELETE | `/products/{id}` | Delete a product      | 204 No Content | 404 if not found  |

## Validation

`ProductRequest` enforces:
- `name`: `@NotBlank`
- `price`: `@Positive`
- `quantity`: `@PositiveOrZero`

Validation failures return `400 Bad Request` with a body like:

```json
{
  "timestamp": "2026-07-27T10:15:30",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed for one or more fields",
  "path": "/products",
  "details": ["name: Product name must not be blank"]
}
```

## Running it

Requires Java 17+ and Maven.

```bash
mvn spring-boot:run
```

The API starts on `http://localhost:8080`.

Swagger UI: `http://localhost:8080/swagger-ui.html`
OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Try it with curl

```bash
# Create a product
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Wireless Mouse","description":"Ergonomic mouse","price":19.99,"quantity":50}'

# Get all products
curl http://localhost:8080/products

# Get one product
curl http://localhost:8080/products/1

# Update a product
curl -X PUT http://localhost:8080/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Wireless Mouse Pro","description":"Now with USB-C","price":24.99,"quantity":40}'

# Delete a product
curl -X DELETE http://localhost:8080/products/1 -i

# Trigger a validation error (blank name, negative price)
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{"name":"","price":-5}'

# Trigger a 404
curl http://localhost:8080/products/999 -i
```

## Running the tests

```bash
mvn test
```

`ProductServiceTests` covers create, update, delete, and the not-found path.
