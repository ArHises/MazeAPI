package service;

import java.util.*;

public class MazeSolverService {
    // ...existing code...

    /**
     * Solves the maze and returns the fastest route as a list of Points.
     * @param maze 2D int array representing the maze (0 = open, 1 = wall)
     * @param start starting Point
     * @param end ending Point
     * @return List of Points representing the fastest route, or empty list if no path found
     */
    public List<Point> solveMaze(int[][] maze, Point start, Point end) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Map<Point, Point> prev = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.equals(end)) {
                return reconstructPath(prev, end);
            }
            for (int[] dir : directions) {
                int nx = current.x + dir[0];
                int ny = current.y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
                    maze[nx][ny] == 0 && !visited[nx][ny]) {
                    Point neighbor = new Point(nx, ny);
                    queue.add(neighbor);
                    visited[nx][ny] = true;
                    prev.put(neighbor, current);
                }
            }
        }
        return Collections.emptyList(); // No path found
    }

    private List<Point> reconstructPath(Map<Point, Point> prev, Point end) {
        List<Point> path = new LinkedList<>();
        for (Point at = end; at != null; at = prev.get(at)) {
            path.add(0, at);
        }
        return path;
    }

    // ...existing code...
}
