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
    private final double scaleFactor = 0.6; //  קובע כמה להקטין את המבוך (60% מהגודל המקורי)
    private final int mazeSize = 50; // גודל של המבוךw

    public MazePanel() {
        this.mazeController
                = new MazeController(mazeSize , mazeSize);
        this.image = mazeController.createMazeImage();

        //חשב את הרוחב והגובה המוקטנים לפי קנה המידה
        int scaledWidth = (int)(mazeController.getImageWidth() * scaleFactor);
        int scaledHeight = (int)(mazeController.getImageHeight() * scaleFactor);

        this.setPreferredSize(new Dimension(scaledWidth, scaledHeight)); // עוזר ל pack (עדיין לא סגורה עלזה)

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //מחשב את גודל התמונה אחרי ההקטנה
        int scaledWidth = (int)(image.getWidth(this) * scaleFactor);
        int scaledHeight = (int)(image.getHeight(this) * scaleFactor);

        g.drawImage(this.image, 0, 0, scaledWidth , scaledHeight ,this); //מצייר את התמונה המוקטנת של המבוך

        if (solutionPath != null && solutionPath.size() > 1) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(new Color(0, 255, 0));
            g2.setStroke(new BasicStroke(3));

           int cellSize = mazeController.getCellSize();

            System.out.println("cell w: " + cellSize + ", cell height: " + cellSize);

            //מחשב גודל תא מוקטן לפתרון (קו ירוק)
            int cellWidth = (int)((mazeController.getCellSize()) * scaleFactor);
            int cellHeight = (int)((mazeController.getCellSize()) * scaleFactor);

            for (int i = 0; i < solutionPath.size() - 1; i++) {
                MazePoint p1 = solutionPath.get(i);
                MazePoint p2 = solutionPath.get(i + 1);

                //מחשב מיקום ממרכז התא לפי קנה המידה
                int x1 = (int)(p1.getX() * cellWidth + cellWidth / 2);
                int y1 = (int)(p1.getY() * cellHeight + cellHeight / 2);
                int x2 = (int)(p2.getX() * cellWidth + cellWidth / 2);
                int y2 = (int)(p2.getY() * cellHeight + cellHeight / 2);

                g2.drawLine(x1, y1 , x2, y2); //מצייר את הקו הירוק בין נקודות הפתרון
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
