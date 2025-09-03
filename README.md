# Book Library Management

This is a simple **Book Library Management System** written in Java.  
It allows managing books through a terminal interface.

## Project Structure

- **Model**: `Book` – holds book info (id, title, author, year)  
- **Repository**: `BookRepository` – handles adding, deleting, fetching books  
- **Service**: `BookService` – business logic (e.g., find books by author)  
- **Controller**: `BookController` – terminal menu, interacts with user  

## Features

1. Add a book  
2. Show all books  
3. Find a book by ID  
4. Delete a book by ID  
5. Find books by author  
6. Exit  

## How to Use

Run `BookController` class (it contains the main method) and follow the terminal menu to perform operations.
