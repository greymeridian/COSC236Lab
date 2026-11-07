# COSC236 — Object Oriented Systems Analysis & Design

Okanagan College — Fall 2026

Repository containing coursework and lab assignments for COSC236.

## COSC236 Lab 03 — Restaurant System

- `RestaurantApp.java` — Liam McDonald and Mikyle Holt
- `Order.java` — Theo Royea
- `MenuItem.java` — Aman Singh
- `Customer.java` — Ronald Lorette

## COSC236 Lab 04 — Library Management System

A Java library management system demonstrating the GRASP principles of Information Expert, Creator, Controller, Low Coupling, and High Cohesion.

Group members: Aman, Felix, Mike, Liam, Ronny, and Theo.

### Contributions

- Initial class diagram — Theo
- Use case diagram — Liam
- `Book.java` — Ronny
- `Member.java` — Mike
- `Library.java` — Aman
- `LibrarianController.java` — Felix
- Initial `LibraryApp.java` — Liam
- Initial GRASP report — Theo
- Final integration, demonstration scenarios, class diagram, and report updates — Ronny

### Project Structure

```text
lab4/
├── library/
│   ├── Book.java
│   ├── LibrarianController.java
│   ├── Library.java
│   ├── LibraryApp.java
│   └── Member.java
└── docs/
    ├── COSC 236 GRASP Report Lab 4.pdf
    ├── COSC236Lab04_ClassDiagram.png
    └── COSC236UseCase.png
```

### GRASP Responsibilities

- **Information Expert:** `Book` manages its availability, `Member` manages its borrowed books, and `Library` provides catalog and member lookups.
- **Creator:** `Library` creates and manages `Book` and `Member` objects.
- **Controller:** `LibrarianController` handles borrowing and returning requests by delegating to `Library`.
- **Low Coupling:** Classes collaborate through public methods rather than directly modifying one another’s private fields.
- **High Cohesion:** Each class focuses on its assigned responsibility; `LibraryApp` demonstrates the system.

### Demonstrated Scenarios

The application uses Alice and Bob, with the books *Dune*, *1984*, and *Moby Dick*, to demonstrate:

- Adding and removing books and members.
- Looking up books and members.
- Displaying available books.
- Borrowing and returning books.
- Rejecting requests to borrow unavailable books.
- Rejecting returns from members who do not hold the book.
- Preventing removal of borrowed books or members with outstanding loans.

### Running in Eclipse

1. Import the repository as a Java project.
2. Configure `lab4` as a source folder.
3. Set its compiled output folder to `build/library/bin`.
4. Exclude `docs/` from the `lab4` source folder.
5. Run `library.LibraryApp` as a Java application.

All Lab 04 Java classes use `package library;`. Eclipse configuration files are maintained locally and are not tracked in the repository.