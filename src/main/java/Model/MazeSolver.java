package Model;

import java.util.*;

public class MazeSolver {

    private Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public List<MazePoint> solveMazeBFS() {
        Queue<List<MazePoint>> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.getWidth()][maze.getHeight()];

        MazePoint start = new MazePoint(0, 0, true);
        MazePoint end = new MazePoint(maze.getWidth() - 1, maze.getHeight() - 1, true);

        List<MazePoint> initialPath = new LinkedList<>();
        initialPath.add(start);
        queue.add(initialPath);
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            List<MazePoint> path = queue.poll();
            MazePoint current = path.getLast();

            if (current.equals(end)) {
                return path; // Shortest path found
            }

            // Explore neighbors: right, down, left, up
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            for (int dir = 0; dir < 4; dir++) {
                int newX = current.getX() + dx[dir];
                int newY = current.getY() + dy[dir];

                if (isValidMove(newX, newY) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    List<MazePoint> newPath = new LinkedList<>(path);
                    newPath.add(new MazePoint(newX, newY, true));
                    queue.add(newPath);
                }
            }
        }

        return new LinkedList<>(); // No path found
    }

    private boolean isValidMove(int x, int y) {
        if (x < 0 || x >= maze.getWidth() || y < 0 || y >= maze.getHeight()) {
            return false;
        }
        return maze.isWhite(x, y);
    }
}