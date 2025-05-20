package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MazeSolver {

    private Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public List<MazePoint> solveMaze() {
        List<MazePoint> path = new LinkedList<>();
        int[] start = {0, 0};
        int[] end = {maze.getWidth() - 1, maze.getHeight() - 1};
        int[] pointer = start;

        int steps = 0;

        while (!Arrays.equals(pointer, end) && steps < 1000) {
            if (isValidMove(pointer[0],pointer[1] + 1) && !isExit(path, pointer[0], pointer[1] + 1)) {
                pointer[1]++;
                path.add(new MazePoint(pointer[0], pointer[1], true));
            } else if (isValidMove(pointer[0] + 1, pointer[1]) && !isExit(path, pointer[0] + 1, pointer[1])) {
                pointer[0]++;
                path.add(new MazePoint(pointer[0], pointer[1], true));
            } else if (isValidMove(pointer[0], pointer[1] - 1) && !isExit(path, pointer[0], pointer[1] - 1)) {
                pointer[1]--;
                path.add(new MazePoint(pointer[0], pointer[1], true));
            } else if (isValidMove(pointer[0] - 1, pointer[1]) && !isExit(path, pointer[0] - 1, pointer[1])) {
                pointer[0]--;
                path.add(new MazePoint(pointer[0], pointer[1], true));
            } else {
                System.out.println("No valid moves available from " + Arrays.toString(pointer));
                break;
            }
            steps++;
        }
        System.out.println("Steps taken: " + steps);
        if (steps >= 1000) {
            System.out.println("Reached max steps, stopping.");
        }
        return path;
    }

    public boolean isValidMove(int x, int y) {
        if (x < 0 || x >= maze.getWidth() || y < 0 || y >= maze.getHeight()) {
            return false;
        }
        return maze.isWhite(x, y);
    }

    public boolean isExit(List<MazePoint> path, int x, int y) {
        boolean exist = false;
        for (MazePoint point : path) {
            if (point.getX() == x && point.getY() == y) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
