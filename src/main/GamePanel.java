package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private KeybordInputs keybordInputs;

    private MouseInputs mouseInputs;

    private int x = 100, y = 100;

    public GamePanel() {

        keybordInputs = new KeybordInputs(this); //Aqui passamos o proprio painel
        mouseInputs = new MouseInputs(this); //Aqui passamos o proprio painel

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

    public void SetRectPos(int x, int y) {

        this.x = x;
        this.y = y;
        repaint();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.fillRect(x, y, 50, 50);
    }
}
