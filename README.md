# CostCalc

## Description
CostCalc is a Spring Boot application that provides endpoints for cost calculation. It uses Swagger 3 for API documentation.

## Technologies Used
- Spring Boot
- Swagger 3

## Getting Started
To get started with CostCalc, follow these steps:

1. Clone the repository:
     ```shell
     git clone https://github.com/karththikeyanK/CostCalc.git
     ```

2. Build the project using Maven:
     ```shell
     cd CostCalc
     mvn clean install
     ```

3. Run the application:
     ```shell
     mvn spring-boot:run
     ```

4. Access the Swagger UI to explore the API documentation:
     ```
     http://localhost:8080/swagger-ui.html
     ```

## Sample Endpoints
- Calculate cost:
    - Method: POST
    - URL: `/api/calculate`
    - Request Body:
        ```json
        {
            "quantity": 10,
            "price": 5.99
        }
        ```
    - Response:
        ```json
        {
            "totalCost": 59.9
        }
        ```

- Get cost details:
    - Method: GET
    - URL: `/api/cost/{id}`
    - Path Variable: `id` (integer)
    - Response:
        ```json
        {
            "id": 1,
            "quantity": 10,
            "price": 5.99,
            "totalCost": 59.9
        }
        ```

## License
This project is licensed under the [MIT License](LICENSE).

