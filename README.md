# Flight_Management_System
Flight Management System
A Java-based Spring Boot application for managing flight-related operations such as booking, passengers, tickets, payments, and crew management. This project provides a RESTful API for a backend flight management solution with layered architecture (Controller-Service-DAO)


Flight_Management_System/
├── src/
│   ├── main/
│   │   ├── java/com/project/flight_management_system/
│   │   │   ├── controller/          # REST controllers
│   │   │   ├── dao/                 # Data access objects (repositories)
│   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   ├── exception/           # Custom exception handling
│   │   │   ├── repo/                # Spring Data JPA repositories
│   │   │   ├── service/             # Business logic layer
│   │   │   ├── util/                # Utility classes
│   │   │   └── FlightManagementSystemApplication.java # Main class
│   ├── resources/
│   │   └── application.properties
│
├── test/java/com/project/flight_management_system/  # Unit & Integration Tests
├── pom.xml                     # Maven dependencies
└── README.md                   # Project documentation


Technologies Used
_________________________
1.Java 11+
2.Spring Boot
3.Spring Data JPA
4.Hibernate
5.Maven
6.RESTful APIs
7.MySQL (Configurable



✨ Features
1.Add, update, and delete flights, passengers, tickets, payments.
2.Manage flight crew: pilots, air hostesses.
3.Book and assign seats.
4.Handle food preferences and passport details.
5.Exception handling for API endpoints.
6.Layered architecture following best practices.



License

This project is open-source and free to use under the MIT License.


