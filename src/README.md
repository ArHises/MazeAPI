📁 ***model/***

`MazePoint.java`

    Purpose: Simple data class representing a point in the maze.
    
    Holds x and y coordinates.
    
    Might override .equals() and .hashCode() for comparisons and hash-based collections.

`Maze.java`

    Purpose: Core data structure for the maze.
    
    Holds a 2D array (boolean[][] maze) representing walkable (white) and blocked (black) tiles.
    
    Stores width and height.
    
    Initializes from a list of white MazePoints.

`MazeSolver.java`

    Purpose: Implements the maze-solving logic.
    
    Uses BFS or DFS to find a path from (0, 0) to (width - 1, height - 1).
    
    Returns the path if found (as a List<MazePoint>), or empty/null if no path exists.

📁 view/

`MazePanel.java`

    Purpose: Extends JPanel, responsible for drawing the maze and the solution path.
    
    Uses BufferedImage for efficient rendering.
    
    Provides a method to update the maze and path.

`MainFrame.java`

    Purpose: The main GUI window.
    
    Contains the MazePanel and a "Check Solution" JButton.
    
    Interacts with the MazeController.

📁 controller/
`MazeController.java`

    Purpose: Connects view and model.
    
    Fetches data using ApiFetcher.
    
    Instantiates Maze and hands it to MazePanel.
    
    Handles "Check Solution" button click:
    
    Solves the maze using MazeSolver.
    
    Updates view with the solution path or displays a dialog if no solution.

📁 util/
`ApiFetcher.java`

    Purpose: Handles all HTTP requests.
    
    Sends GET request to the API endpoint with optional width and height.
    
    Parses the JSON response into a list of MazePoint.

📄 `Run.java`

    Purpose: The entry point of the application.
    
    Initializes the frame and controller.
    
    Sets default size or receives optional width/height args.

🔁 Flow Summary:

    Main starts → initializes MainFrame and MazeController.
    
    MazeController calls ApiFetcher → gets white points.
    
    Maze is constructed → sent to MazePanel for drawing.
    
    User clicks "Check Solution" → MazeController runs MazeSolver.
    
    If solution exists → path drawn in green, else → message dialog shown.

