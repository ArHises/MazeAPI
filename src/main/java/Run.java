import Model.Maze;
import Model.MazePoint;

import java.util.List;

import Model.MazeSolver;
import Util.ApiFetcher;
import View.MainFrame;
import View.MazePanel;

import javax.swing.*;

public class Run {

    public static int HEIGHT = 500;
    public static int WIDTH = 500;

    public static void main(String[] args) {

//        System.out.println("Example Maze:");
//        List<MazePoint> points = ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
//        Maze maze = new Maze(points, WIDTH, HEIGHT);
//
//        MazeSolver mazeSolver = new MazeSolver(maze);
//        List<MazePoint> path = mazeSolver.solveMaze();
//
//        System.out.println(maze);
//        Maze solve = new Maze(path, WIDTH, HEIGHT);
//        System.out.println(solve);

        MazePanel mazePanel = new MazePanel();
        MainFrame window = new MainFrame("Maze", mazePanel);

        window.setVisible(true);
        window.setSize(WIDTH, HEIGHT);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
    }
}
