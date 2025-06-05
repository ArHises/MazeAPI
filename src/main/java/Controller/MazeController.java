package Controller;

import Model.Maze;
import Model.MazePoint;
import Model.MazeSolver;
import Util.ApiFetcher;
import View.MazePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class MazeController {

    private int WIDTH;
    private int HEIGHT;
    private BufferedImage image;
    private Maze maze;
    private MazeSolver mazeSolver;
    private MazePanel mazePanel;

    public MazeController(int width , int height){
        this.WIDTH = width;
        this.HEIGHT = height;

        List<MazePoint> points = ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);
        System.out.println(points.toArray());


        if (points == null){
            System.err.println("error");
            points = List.of();
        }
        this.maze = new Maze(points, WIDTH, HEIGHT);
        this.mazeSolver = new MazeSolver(this.maze);
    }

    public BufferedImage createMazeImage(){
        int cellSize = 20;

        BufferedImage img
                = new BufferedImage(WIDTH * cellSize, HEIGHT * cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (maze.isWhite(x, y)) {
                    g.setColor(Color.WHITE);
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize); // לבדוק
                }
            }
        }

        g.dispose(); // משחרר את משאבי הציור
        return img;
    }


    public BufferedImage getImage() {
        return image;
    }

    public Maze getMaze() {
        return maze;
    }

    public MazeSolver getMazeSolver() {
        return mazeSolver;
    }

    public MazePanel getMazePanel() {
        return mazePanel;
    }
}
