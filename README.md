# Connect 4 (Java Project)

## Description
This project is a Java implementation of the classic strategy board game **Connect 4**. It was developed as a university assignment to demonstrate object-oriented programming concepts, GUI development, and algorithmic logic in Java.

The game features a fully interactive Graphical User Interface (GUI) built using the **ACM Java Task Force** library, allowing two players to compete locally.

## Features
* **Interactive GUI:** Built with `acm.graphics`, featuring mouse interaction to drop disks.
* **2-Player Local Mode:** Play against a friend on the same computer (Red vs. Yellow).
* **Win Detection:** Algorithms to detect wins horizontally, vertically, and diagonally.
* **Animations:** Smooth visual feedback when dropping disks and hovering over columns.
* **Unit Testing:** Comprehensive test suite using **JUnit 5** to verify game logic, board state, and player actions.

## Project Structure

The project follows a clean architecture separating the model, view, and controller logic:

* **`Connect4.java`**: The entry point. Extends `GraphicsProgram` and manages the main game loop and event listeners.
* **`Game.java`**: Manages the high-level game state (turns, checking for a winner, switching players).
* **`Board.java`**: Represents the 6x7 grid data structure. Handles the logic for placing tokens and checking connection paths.
* **`Display.java`**: Handles all rendering logic, drawing the board, disks, and status messages to the canvas.
* **`Player.java`**: Logic for player identity (Player ONE/Red and Player TWO/Yellow).
* **`Geometry.java`**: Helper class to calculate coordinate geometry for the UI rendering.
* **`Move.java`**, **`Position.java`**, **`Direction.java`**: Helper classes for movement logic and board navigation.

## Prerequisites

* **Java Development Kit (JDK)** (Version 8 or higher).
* **ACM Library (`acm.jar`)**: This project relies on the ACM Java Task Force library for graphics.
* **JUnit 5**: Required to run the test suite.

## How to Run

1.  Open the project in your preferred IDE (IntelliJ IDEA, Eclipse, etc.).
2.  Ensure `acm.jar` is added to your project's classpath/dependencies.
3.  Navigate to `src/Connect4.java`.
4.  Run the `main` method.

## How to Play

1.  The game starts with an empty 6x7 grid.
2.  **Player 1 (Red)** moves first.
3.  Move the mouse over the board to select a column.
4.  **Click** to drop a disk into the selected column.
5.  The turn automatically switches to **Player 2 (Yellow)**.
6.  The first player to connect **4 disks** of the same color (horizontally, vertically, or diagonally) wins.
7.  The game status is displayed in the window title.

## Testing

The project includes a robust suite of unit tests located in the `test/` folder. To verify the logic:

1.  Run `GameTest.java` to test game flow and winning conditions.
2.  Run `BoardTest.java` to test grid logic and valid moves.
3.  Run `GeometryTest.java` to verify UI calculations.

## Authors
* [Your Name] - University Project
