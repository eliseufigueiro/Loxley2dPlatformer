package main;

import javax.swing.*;

public class GameWindow extends JFrame{

    public GameWindow(GamePanel gamePanel) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Hello Loxley! 2D Adventure.");
        // Add game components here
        this.add(gamePanel);

        this.pack();
        this.setVisible(true);
    }
}
