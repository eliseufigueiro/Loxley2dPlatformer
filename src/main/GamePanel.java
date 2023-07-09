package main;

import inputs.KeybordInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

        addKeyListener(new KeybordInputs());
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(100, 100, 50, 50);
    }
}
