package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    // SCREEN SETTINGS
    private final int SCREEN_WIDTH = 1280; // 1280 pixels
    private final int SCREEN_HEIGTH = 720; // 720 pixels

    // CONTROLS SETTINGS
    private KeybordInputs keybordInputs;
    private MouseInputs mouseInputs;

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        keybordInputs = new KeybordInputs(this);
        mouseInputs = new MouseInputs(this);

        addKeyListener(keybordInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGTH));
        this.setDoubleBuffered(true);
    }

    public void updateGame() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.renderGame(g);
    }

    // GETTER AND SETTER

    public Game getGame() {
        return game;
    }
}
