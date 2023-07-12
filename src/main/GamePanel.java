package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    // SCREEN SETTINGS
    private final int ORIGINAL_TILE_SIZE = 16; // 16x16 tile
    private final int SCALE = 3;
    private final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE; // 48x48 tile
    private final int SCREEN_WIDTH = 1280; // 1280 pixels
    private final int SCREEN_HEIGTH = 720; // 720 pixels

    // CONTROLS SETTINGS
    private KeybordInputs keybordInputs;
    private MouseInputs mouseInputs;
    private int playerX, playerY, playerSpeed = 5;

    private BufferedImage img;

    public GamePanel() {
        keybordInputs = new KeybordInputs(this);
        mouseInputs = new MouseInputs(this);

        addKeyListener(keybordInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGTH));
        this.setDoubleBuffered(true);

        importImg();
    }

    private void importImg() {
        //TODO: importa IMG
        InputStream is = getClass().getResourceAsStream("/resources/img.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePlayerX(int value) {
        this.playerX += value;
    }

    public void changePlayerY(int value) {
        this.playerY += value;
    }

    public void changePlayerMouse(int x, int y) {
        this.playerX = x;
        this.playerY = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(img, playerX, playerY, null);
        g2.fillRect(playerX, playerY, TILE_SIZE, TILE_SIZE);
        g2.dispose();
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }
}
