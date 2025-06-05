# MazeAPIProject

מגישים:
- רומן
- דליה
- בתיה

A Java Swing application that fetches a random maze from an API, displays it, and allows the user to solve it visually.

## Project Structure

```
MazeAPIProject/
├── src/
│   └── main/
│       └── java/
│           ├── Controller/
│           │   └── MazeController.java
│           ├── Model/
│           │   ├── Maze.java
│           │   ├── MazePoint.java
│           │   └── MazeSolver.java
│           ├── Util/
│           │   └── ApiFetcher.java
│           └── View/
│               ├── MainFrame.java
│               └── MazePanel.java
│           └── Run.java
│       └── resources/
│           └── Images/
├── pom.xml
└── README.md
```

## Components

### model/
- **MazePoint.java**: Data class for a maze cell (x, y, white/black). Overrides `equals()` for comparison.
- **Maze.java**: Represents the maze as a 2D boolean array. Initializes from a list of white MazePoints.
- **MazeSolver.java**: Implements DFS maze-solving logic. Returns a path as `List<MazePoint>` or empty if no solution.

### view/
- **MazePanel.java**: Extends `JPanel`. Draws the maze and solution path using `BufferedImage`. Supports scaling.
- **MainFrame.java**: Main GUI window. Contains `MazePanel` and a "Check Solution" button. Handles user interaction.

### controller/
- **MazeController.java**: Connects view and model. Fetches maze data, builds the maze, and handles solution logic.

### util/
- **ApiFetcher.java**: Handles HTTP requests to fetch maze data from the API and parses JSON into `MazePoint` objects.

### Run.java
- Entry point. Initializes the GUI and starts the application.

## Flow Summary
1. `Run.java` starts the app, creates `MazePanel` and `MainFrame`.
2. `MazeController` fetches maze data via `ApiFetcher` and builds the maze.
3. Maze is drawn in `MazePanel`.
4. User clicks "Check Solution". `MazeController` solves the maze using `MazeSolver`.
5. If a solution exists, the path is drawn in green. Otherwise, a message is shown.

## API
- Uses: `https://app.seker.live/fm1/get-points?width={w}&height={h}`
- Returns: JSON array of points with `x`, `y`, and `white` (boolean).

## Requirements
- Java 11+
- OkHttp (for HTTP requests)
- org.json (for JSON parsing)

## How to Run
1. Build the project with Maven or your IDE.
2. Run `Run.java`.
3. The maze will be displayed. Click "Check Solution" to see the solution path.

---
