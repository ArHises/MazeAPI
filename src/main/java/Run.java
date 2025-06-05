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


        MazePanel mazePanel = new MazePanel();
        MainFrame window = new MainFrame("Maze", mazePanel);

        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
    }

}
