package View;

import Model.MazePoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {

    private MazePanel mazePanel;

    public MainFrame(String title, MazePanel mazePanel){
        super(title);
        this.mazePanel = mazePanel;

        this.setLayout(new BorderLayout());
        this.add(mazePanel, BorderLayout.CENTER);
        JButton checkSolutionBtn = new JButton("Check Solution");

        checkSolutionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MazePoint> solution = mazePanel.getMazeController().getMazeSolver().solveMaze();
                if (solution == null || solution.isEmpty()){
                    System.out.println("NO SOLUTION !! ");
                }else {
                    mazePanel.setSolutionPath(solution);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(checkSolutionBtn);
        this.add(buttonPanel, BorderLayout.SOUTH);


        this.add(mazePanel);
        this.pack(); // מתאים את החלון לגודל של הפאנל חשוב כשמשתמשים ב preferredSize
        this.setLocationRelativeTo(null);
        this.setVisible(true);





    }

}
