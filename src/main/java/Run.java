import Model.Maze;
import Model.MazePoint;

import java.util.List;

import Model.MazeSolver;
import Util.ApiFetcher;

public class Run {

    public static int HEIGHT = 20;
    public static int WIDTH = 20;

    public static float calculateSuccessRate(int tries) {
        System.out.println("Calculating success rate...");

        int count = 0;

        for (int i = 0; i < tries; i++) {
            List<MazePoint> points = ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
            Maze maze = new Maze(points, WIDTH, HEIGHT);

            MazeSolver mazeSolver = new MazeSolver(maze);
            List<MazePoint> path = mazeSolver.solveMaze();

            if (!path.isEmpty() && (path.getLast().getY() == maze.getHeight() - 1
                    && path.getLast().getX() == maze.getWidth() - 1)) {
                count++;
            }
        }

        return ((float) count / tries) * 100;
    }

    public static void main(String[] args) {

        System.out.println("\nSuccess Rate: " + calculateSuccessRate(20) + "%");

        System.out.println("Example Maze:");
        List<MazePoint> points = ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
        Maze maze = new Maze(points, WIDTH, HEIGHT);

        MazeSolver mazeSolver = new MazeSolver(maze);
        List<MazePoint> path = mazeSolver.solveMaze();

        System.out.println(maze);
        Maze solve = new Maze(path, WIDTH, HEIGHT);
        System.out.println(solve);
    }
}
