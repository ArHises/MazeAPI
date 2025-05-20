package Model;

import java.util.LinkedList;
import java.util.List;

public class MazeSolver {

    private Maze maze;

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public List<MazePoint> solveMaze() {
        List<MazePoint> path = new LinkedList<>();
        MazePoint start = new MazePoint(0,0,true);
        MazePoint end = new MazePoint(maze.getWidth() - 1, maze.getHeight() - 1, true);
        MazePoint pointer = start;

        path.add(start);
        int steps = 0;

        while (!pointer.equals(end) && steps < 200) {
            if (isRight(pointer, path)) {

                pointer.setX(pointer.getX() + 1);
                path.add(new MazePoint(pointer.getX(), pointer.getY(), true));

            } else if (isDown(pointer, path)) {

                pointer.setY(pointer.getY() + 1);
                path.add(new MazePoint(pointer.getX(), pointer.getY(), true));

            } else if (isLeft(pointer, path)) {

                pointer.setX(pointer.getX() - 1);
                path.add(new MazePoint(pointer.getX(), pointer.getY(), true));

            } else if (isUp(pointer, path)) {

                pointer.setY(pointer.getY() - 1);
                path.add(new MazePoint(pointer.getX(), pointer.getY(), true));

            } else {
                if (!path.isEmpty()){
                    pointer = path.removeLast();
                    continue;
                }
                System.out.println("No path found.");
                break;
            }
            steps++;
        }
        System.out.println("Steps taken: " + steps);
        if (steps >= 200) {
            System.out.println("Failed at: " + path.getLast());
        }
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
