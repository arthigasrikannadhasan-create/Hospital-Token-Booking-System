# Hospital Token Booking System

## Project Description
The Hospital Token Booking System is a Java-based console application designed to simplify patient registration and doctor token booking. It allows users to register patients, view doctor details, book tokens, search for tokens, and cancel bookings.

## Objectives
- Simplify hospital token booking.
- Maintain patient information.
- Display available doctors and their departments.
- Generate unique token numbers.
- Allow token searching and cancellation.
- Handle invalid inputs using exception handling.

## Technologies Used
- **Programming Language:** Java
- **IDE:** Visual Studio Code
- **Version Control:** Git
- **Repository Hosting:** GitHub

## Project Structure

```text
HospitalTokenBookingSystem/
│
├── src/
│   ├── HospitalException.java
│   ├── Bookable.java
│   ├── Person.java
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Token.java
│   ├── Hospital.java
│   └── HospitalTokenSystem.java
│
└── README.md
```

## OOP Concepts Applied

1. **Encapsulation:** Private data members with getter and setter methods.
2. **Inheritance:** Patient and Doctor inherit from the abstract Person class.
3. **Polymorphism:** Method overriding and parent-class references.
4. **Abstraction:** Abstract Person class and Bookable interface.
5. **Exception Handling:** Custom HospitalException handles invalid operations.

## Main Features
- Patient registration
- View all registered patients
- Search patient by ID
- View available doctors
- Book hospital tokens
- View active tokens
- Search token by number
- Cancel tokens

## How to Run the Project

### Prerequisites
- Java JDK installed
- Visual Studio Code or another Java-supported IDE

### Compilation

Open the terminal in the project folder and execute:

```bash
cd src
javac *.java
```

### Execution

```bash
java HospitalTokenSystem
```

## Token Booking Details
- Token numbers start from 1001.
- Each doctor can have up to five active tokens.
- The system supports a maximum of 20 registered patients.
- The system supports a maximum of five doctors.
- The system supports a maximum of 30 tokens.

## GitHub Repository

[Hospital Token Booking System](https://github.com/arthigasrikannadhasan-create/Hospital-Token-Booking-System)

## Future Enhancements
- Store patient records permanently using file handling or a database.
- Develop a graphical user interface.
- Add appointment date and time selection.
- Generate reports of patient bookings.

## Team Project
Developed as an Object-Oriented Programming mini project.