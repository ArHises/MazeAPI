package Model;

import java.util.*;

public class MazeSolver {

    private Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }
    /**
     * Solves the maze using simple DFS algorithm.
     * This method is not optimal and may not find the shortest path.
     * @return List of MazePoint representing the path from start to end.
     */
    public List<MazePoint> solveMaze() {
        LinkedList<MazePoint> path = new LinkedList<>();
        LinkedList<MazePoint> passed = new LinkedList<>();

        MazePoint start = new MazePoint(0, 0, true);
        MazePoint end = new MazePoint(maze.getWidth() - 1, maze.getHeight() - 1, true);

        passed.add(start);
        path.add(start);
        int steps = 0;

        while (!path.isEmpty() && steps < 1000) {
            MazePoint pointer = path.getLast();

            if (pointer.equals(end)) {
                System.out.println("Finished: Steps taken - " + steps);
                return path; // Found the exit
            }

            // Try all directions
            if (isRight(pointer, passed)) {
                MazePoint next = new MazePoint(pointer.getX() + 1, pointer.getY(), true);
                path.add(next);
                passed.add(next);
            } else if (isDown(pointer, passed)) {
                MazePoint next = new MazePoint(pointer.getX(), pointer.getY() + 1, true);
                path.add(next);
                passed.add(next);
            } else if (isLeft(pointer, passed)) {
                MazePoint next = new MazePoint(pointer.getX() - 1, pointer.getY(), true);
                path.add(next);
                passed.add(next);
            } else if (isUp(pointer, passed)) {
                MazePoint next = new MazePoint(pointer.getX(), pointer.getY() - 1, true);
                path.add(next);
                passed.add(next);
            } else {
                // Backtrack if no direction is valid
                path.removeLast();
            }
            steps++;
        }

        System.out.println("Steps taken: " + steps);
        System.out.println("No path found.");
        return path;
    }


    private boolean isRight(MazePoint pointer, List<MazePoint> path) {
        return (isValidMove(pointer.getX() + 1, pointer.getY())
                && !isExit(path, pointer.getX() + 1, pointer.getY()));
    }

    private boolean isLeft(MazePoint pointer, List<MazePoint> path) {
        return (isValidMove(pointer.getX() - 1, pointer.getY())
                && !isExit(path, pointer.getX() - 1, pointer.getY()));
    }

    private boolean isDown(MazePoint pointer, List<MazePoint> path) {
        return (isValidMove(pointer.getX(), pointer.getY() + 1)
                && !isExit(path, pointer.getX(), pointer.getY() + 1));
    }

    private boolean isUp(MazePoint pointer, List<MazePoint> path) {
        return (isValidMove(pointer.getX() , pointer.getY() - 1)
                && !isExit(path, pointer.getX(), pointer.getY()  - 1));
    }

    private boolean isExit(List<MazePoint> path, int x, int y) {
        boolean exist = false;
        for (MazePoint point : path) {
            if (point.getX() == x && point.getY() == y) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    private boolean isValidMove(int x, int y) {
        if (x < 0 || x >= maze.getWidth() || y < 0 || y >= maze.getHeight()) {
            return false;
        }
        return maze.isWhite(x, y);
    }
}