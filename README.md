# COSC236 — Object Oriented Systems Analysis & Design

Okanagan College — Fall 2026

Repository containing coursework and lab assignments for COSC236, lab README's are in descending order.

---

## COSC236 Lab 05: Refactoring Library Management System

Lab 5 refactors a Java library management system in stages. Parts 1–3 are complete. Part 4 is next.

[Lab 5 handout](lab5/COSC236-Lab-5.pdf)

### Progress

- [x] Part 1 — Sequence diagrams for adding Alice, borrowing Dune, and returning Dune (Liam & Mike)
- [x] Part 2 — Renamed the concrete `Book` class to `PaperBook`
- [x] Part 3 — Added the `Book` interface and updated the catalog, borrowing code, and tests (Ronny)
- [ ] Part 4 — Add more book types (Theo)
- [ ] Part 5 — Introduce `BorrowingService` (Aman)
- [ ] Part 6 — Return detailed results from borrowing and returning (Mike)
- [ ] Part 7 — Make the borrowing service a singleton (Liam)
- [ ] Part 8 — Apply Factory Method to book creation (Felix)

### Current design

`PaperBook` implements the `Book` interface. `Library` uses `Book` for catalog operations, and `Member` uses it for borrowing and returning. `LibrarianController` currently creates paper books and uses the interface for books returned by catalog lookups.

The existing tests create `PaperBook` objects and use them as `Book`. `TestBookDependencyInversion` uses a second, test-only implementation to check that a book can be added, found, borrowed, returned, and removed through the same methods.

### Running in Eclipse

1. Import the repository as an existing Eclipse project. The tracked `.classpath` configures `lab5/src` as a source folder and includes JUnit 5.
2. Run `lab5.LibraryApp` as a Java application to see the borrowing and returning demo.
3. Run `lab5.tests.AllTests` as a JUnit test. The suite includes `TestBookDependencyInversion`.

### Final submission

Combine the required results and written answers into one PDF and include the repository URL.

---

## COSC236 Lab 04: Library Management System

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

---

## COSC236 Lab 03: Restaurant System

- `RestaurantApp.java` — Liam McDonald and Mikyle Holt
- `Order.java` — Theo Royea
- `MenuItem.java` — Aman Singh
- `Customer.java` — Ronald Lorette