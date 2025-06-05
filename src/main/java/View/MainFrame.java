package View;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MazePanel mazePanel;

    public MainFrame(String title, MazePanel mazePanel){
        super(title);
        this.setSize(750 , 750);
        this.setLocationRelativeTo(null);
        this.mazePanel = mazePanel;
        this.add(mazePanel);
        this.setVisible(true);
    }

}
