package View;

import Controller.MazeController;
import Model.MazePoint;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MazePanel extends JPanel {
    private Image image;
    private MazeController mazeController;
    private List<MazePoint> solutionPath;

    public MazePanel() {
        this.mazeController
                = new MazeController(40 , 40);
        this.image = mazeController.createMazeImage();
        List<MazePoint> solution = mazeController.getMazeSolver().solveMaze();
        setSolutionPath(solution);

    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);

        if (solutionPath != null && solutionPath.size() > 1) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 255, 0));
            g2.setStroke(new BasicStroke(4));

            int cellWidth = getWidth() / mazeController.getMaze().getWidth();
            int cellHeight = getHeight() / mazeController.getMaze().getHeight();

            System.out.println("cell w: " + cellWidth + ", cell height: " + cellHeight);

            for (int i = 0; i < solutionPath.size() - 1; i++) {
                MazePoint p1 = solutionPath.get(i);
                MazePoint p2 = solutionPath.get(i + 1);

                int x1 = p1.getX() * cellWidth + cellWidth / 2;
                int y1 = p1.getY() * cellHeight + cellHeight / 2;
                int x2 = p2.getX() * cellWidth + cellWidth / 2;
                int y2 = p2.getY() * cellHeight + cellHeight /2;

                g2.drawLine(x1, y1 , x2, y2);
            }
        }
    }


    public MazeController getMazeController() {
        return mazeController;
    }

    public void setSolutionPath(List<MazePoint> solutionPath) {
        this.solutionPath = solutionPath;
        repaint(); // מבקש לצייר מחדש עם הפתרון החדש
    }
}
