package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private KeybordInputs keybordInputs;

    private MouseInputs mouseInputs;

    private int x = 0, y = 0;

    public GamePanel() {

        keybordInputs = new KeybordInputs(this); //Aqui passamos o proprio painel
        mouseInputs = new MouseInputs();

        addKeyListener(keybordInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeX(int value) {

        this.x += value;
        repaint();
    }

    public void changeY(int value) {

        this.y += value;
        repaint();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(100 + x, 100 + y, 50, 50);
    }
}
