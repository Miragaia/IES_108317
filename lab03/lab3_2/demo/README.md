# LAB3_2

## Employee Management App

This guide will help you set up and understand the basics of an Employee Management Application developed using Spring Boot and MySQL. The application provides RESTful APIs for managing employee information.

### Setting up MySQL Server with Docker

To run the MySQL server, we'll use Docker by running the following command to set up a MySQL container:

```
docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7
```

### Project structure
* Controller (*EmployeeController*)
* Repository (*EmployeeRepository*)
* Entities (*Employee*)
* Exceptions

#### Employee Entity:

**Description:** This class represents the structure of an employee record. It defines the attributes of an employee, such as id, firstName, lastName, and emailId.
**Purpose:** To model and store employee data in the database.

#### Employee Repository:

**Description:** This is an interface that extends JpaRepository from Spring Data JPA. It provides basic CRUD operations and a custom query method for finding an employee by email.
**Purpose:** To interact with the database and perform database operations related to employees.

#### Employee Controller:

**Description:** This is a RESTful controller class that defines various endpoints for managing employee data. It includes methods to retrieve a list of all employees, get an employee by ID, get an employee by email, create a new employee, update an existing employee, and delete an employee.
**Purpose:** To handle HTTP requests and map them to corresponding service methods, enabling API interaction with employee data.

#### Exceptions:

**Description:** Error and Exception handlers

### Testing

Testing the application endpoints could be done using Postman or a command-line tool like curl. Make requests to the following endpoints:

- **GET /api/v1/employees** - List all employees
- **GET /api/v1/employees/{id}** - Get an employee by ID
- **GET /api/v1/employees?email={email}** - Get an employee by email
- **POST /api/v1/employees** - Create a new employee
- **PUT /api/v1/employees/{id}** - Update an existing employee
- **DELETE /api/v1/employees/{id}** - Delete an employee by ID
