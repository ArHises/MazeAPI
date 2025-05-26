package View;

import Controller.MazeController;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    private Image image;

    public MazePanel() {
        MazeController mazeController
                = new MazeController(40 , 40);
        this.image = mazeController.createMazeImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(this.image , 5 , 5 , 400 , 400 , this);
    }
}
