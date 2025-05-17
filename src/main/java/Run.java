import Model.Maze;
import Model.MazePoint;

import java.util.List;
import Util.ApiFetcher;

public class Run {

    public static int HEIGHT = 20;
    public static int WIDTH = 20;


    public static void main(String[] args) {

        List<MazePoint> points =
                ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
        Maze maze =
                new Maze(points, WIDTH, HEIGHT);

        System.out.println(maze);
    }
}
