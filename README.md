# Library Management System

## Project Overview
This project is a Library Management System developed in Java. It allows users to borrow, return, and manage library items such as books, DVDs, and magazines. The system also supports data persistence using CSV files.

---

## Features

- User management (Student, Teacher, Admin)
- Item management (Book, DVD, Magazine)
- Borrow and return system
- Lost item handling
- Borrowing limits per user
- Sorting system (by ID, name, title)
- Data persistence using CSV files
- Exception handling for invalid operations
- Unit testing using JUnit

---

## Key Design Decisions

- Items and users use unique IDs
- Comparable used for default sorting (by ID)
- Comparator used for alternative sorting strategies
- Library class handles system logic and coordination
- Validation ensures data integrity (ISBN, borrowing rules)

---

## Exception Handling

The system handles invalid operations such as:
- Borrowing beyond user limits
- Borrowing unavailable items
- Returning items not borrowed by the user
- Null or invalid inputs

---

## Data Persistence

Data is stored in CSV files:
- users.csv
- items.csv

The system loads data at startup and saves changes automatically.

---

## Testing

Unit tests cover:
- Borrowing and returning items
- Edge cases (null values, invalid operations)
- Status changes
- Exception handling
