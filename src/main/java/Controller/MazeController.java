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
    private Maze maze;
    private MazeSolver mazeSolver;
    private final int cellSize;
    private static final int IMAGE_SIZE = 750; // גודל התמונה המקסימלי

    public MazeController(int width , int height){
        this.WIDTH = width;
        this.HEIGHT = height;

        this.cellSize =
                Math.min(IMAGE_SIZE / WIDTH
                        , IMAGE_SIZE / HEIGHT); // מחשב את גודל התא המינימלי כדי שהתמונה תתאים לגודל המקסימלי

        List<MazePoint> points = ApiFetcher.fetchMazePoints(WIDTH, HEIGHT);

        if (points == null){
            System.err.println("error");
            points = List.of();
        }
        this.maze = new Maze(points, WIDTH, HEIGHT);
        this.mazeSolver = new MazeSolver(this.maze);
    }

    public BufferedImage createMazeImage(){

        BufferedImage img =
                new BufferedImage(WIDTH * cellSize
                , HEIGHT * cellSize
                , BufferedImage.TYPE_INT_RGB);

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

    public MazeSolver getMazeSolver() {
        return mazeSolver;
    }

    public int getCellSize() {
        return this.cellSize;
    }

    public int getImageWidth() {
        return maze.getWidth() * getCellSize();
    }

    public int getImageHeight() {
        return maze.getHeight() * getCellSize();
    }


}
