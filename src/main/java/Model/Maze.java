package Model;

import java.util.List;

public class Maze {

    private boolean[][] maze;

    public Maze(List<MazePoint> mazePointList, int width, int height) {
        this.maze = buildMazeGrid(mazePointList, width, height);
    }

    public boolean isWhite(int x, int y) {
        return maze[y][x]; // Note: maze[y][x] because row is y, col is x
    }

    public int getWidth() {
        return maze[0].length;
    }

    public int getHeight() {
        return maze.length;
    }

    public boolean[][] getGrid() {
        return maze;
    }

    public boolean[][] buildMazeGrid(List<MazePoint> points, int width, int height) {
        boolean[][] grid = new boolean[height][width];
        points.forEach(point -> grid[point.getY()][point.getX()] = true);
        return grid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                sb.append(isWhite(x,y) ? "\t." : "\t#");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
