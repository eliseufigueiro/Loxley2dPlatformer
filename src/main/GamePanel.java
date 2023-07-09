package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;

    public GamePanel() {

        mouseInputs = new MouseInputs();

        addKeyListener(new KeybordInputs());
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(100, 100, 50, 50);
    }
}
