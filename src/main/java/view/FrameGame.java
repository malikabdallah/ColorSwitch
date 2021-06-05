package view;

import javax.swing.*;

public class FrameGame extends JFrame {

    public FrameGame(PanelGame panel) {
        this.setTitle("SWITCH COLOR");
        this.setSize(300, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setContentPane(panel);
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }
}
