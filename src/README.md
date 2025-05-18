# EmpTrack

**EmpTrack** is a console-based Java application used to manage employee records. It supports essential operations like adding, viewing, updating, deleting, and searching employees, and is built using JDBC with a MySQL backend.

---

## Features

- Add new employee
- View all employees
- Search employee by ID
- Update employee name
- Delete employee by ID
- Update employee salary
- Search employees by department
- Search employees by designation

---

## Technologies Used

- Java (JDK 17+)
- JDBC
- MySQL (8.0.42)
- intelliJ IDEA
- MySQL Connector J

---

## Database Setup

1. Create a MySQL database named `employeedb`.
2. Create the `employee` table using the SQL below:

<pre>```sql
CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    department VARCHAR(100),
    designation VARCHAR(100),
    salary DOUBLE,
    email VARCHAR(100),
    phone INT,
    address VARCHAR(255)
);</pre>

3.Update your MySQL username, password, and database name in DbConnection.java.

---
## How to Run

- Clone or download the project.
- Import into intellij IDEA or your preferred IDE.
- Add the MySQL JDBC driver (e.g., mysql-connector-java-8.0.4 jar) to the build path.
- Compile and run the Main.java file.
- Use the text-based menu to perform operations.

---

- EmpTrack, built for learning and practical implementation of Java with JDBC.