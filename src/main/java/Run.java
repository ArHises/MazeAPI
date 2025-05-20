import Model.Maze;
import Model.MazePoint;

import java.util.List;

import Model.MazeSolver;
import Util.ApiFetcher;

public class Run {

    public static int HEIGHT = 20;
    public static int WIDTH = 20;

    public static void main(String[] args) {

        int count = 0;
        int tries = 10;

        for (int i = 0; i < tries; i++) {

            List<MazePoint> points = ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
            Maze maze = new Maze(points, WIDTH, HEIGHT);

            MazeSolver mazeSolver = new MazeSolver(maze);
            List<MazePoint> path = mazeSolver.solveMaze();

            if ( !path.isEmpty() && (path.getLast().getY() == maze.getHeight() - 1
                    && path.getLast().getX() == maze.getWidth() - 1)) {
                count++;
            } else {
                System.out.println(maze);
                Maze solve = new Maze(path, WIDTH, HEIGHT);
                System.out.println(solve);
            }
            System.out.println(i + "...");
        }
        System.out.println("Success rate: " + (float) (count * 100 / tries) + "%");
    }
}
