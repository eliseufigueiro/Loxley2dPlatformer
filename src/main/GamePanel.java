package main;

import inputs.KeyBordInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {

        addKeyListener(new KeyBordInputs());
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(100, 100, 50, 50);
    }
}
