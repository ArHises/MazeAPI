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



        for (int i = 0; i < 20; i++) {
            List<MazePoint> points =
                    ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
            Maze maze =
                    new Maze(points, WIDTH, HEIGHT);
//            System.out.println(maze);

            MazeSolver mazeSolver = new MazeSolver(maze);
            List<MazePoint> path = mazeSolver.solveMaze();
            if (path.get(path.size() - 1).getY() == maze.getHeight() - 1
                    && path.get(path.size() - 1).getX() == maze.getWidth() - 1) {
                count++;
            }
            System.out.println(i + "...");
        }
        System.out.println("Success rate: " + (float) (count * 100 / 20) + "%");
    }
}
