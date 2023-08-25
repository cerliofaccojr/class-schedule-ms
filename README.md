# Class Schedule Management System - Spring Boot Project

Welcome to the Class Schedule Management System! This is a Spring Boot application that provides a web-based interface for managing class schedules.
 It runs on port 8080 and utilizes an H2 in-memory database.

## Getting Started

To run the application locally, follow these steps:

1. Make sure you have Java 17 or higher installed on your system.

2. Clone this repository to your local machine using the following command:

   ```shell
   git clone https://github.com/cerliofaccojr/class-schedule-ms.git



# Class Schedule Management System - Spring Boot Project

Welcome to the Class Schedule Management System! This is a Spring Boot application that provides a web-based interface for managing class schedules.
It runs on port 8080 and utilizes an H2 in-memory database.

## Getting Started

To run the application locally, follow these steps:

1. Make sure you have Java 17 or higher installed on your system.

2. Clone this repository to your local machine using the following command:

   ```shell
   git clone https://github.com/cerliofaccojr/class-schedule-ms.git

3. Navigate to the project directory:

   ```shell
    cd class-schedule-ms

4. Build the project using Maven:
    ```shell
    mvn clean package


5.  Run the application using the following command:
     ```shell
        java -jar target/class-schedule-ms.jar
6. 
7.  The application should now be running and accessible at
    ```shell
     http://localhost:8080.

##  Accessing the H2 Database
The H2 in-memory database can be accessed via the H2 console. Follow these steps:

While the application is running, open a web browser and go to http://localhost:8080/h2-console.

In the "JDBC URL" field, enter jdbc:h2:mem:testdb.

Leave the "Username" and "Password" fields blank, and click "Connect".

You should now have access to the H2 database console.

Initial Database Data
An initial database script is loaded from src/main/resources/data.sql. This script populates the H2 database with some sample data when the application starts.


##  License
This project is licensed under the MIT License. See the LICENSE file for details.

For questions or support, please contact cerliofaccojr.