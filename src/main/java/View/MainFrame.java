package View;

import javax.swing.*;

public class MainFrame extends JFrame {

    private MazePanel mazePanel;

    public MainFrame(String title, MazePanel mazePanel){
        super(title);
        this.mazePanel = mazePanel;
    }
}
