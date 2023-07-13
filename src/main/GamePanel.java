package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
    private int playerX, playerY, playerSpeed = 2;
    private int playerDir = -1;
    private boolean moving = false;

    // ANIMATION SETTINGS
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 7;
    private int playerAction = IDLE;

    public GamePanel() {
        keybordInputs = new KeybordInputs(this);
        mouseInputs = new MouseInputs(this);

        addKeyListener(keybordInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGTH));
        this.setDoubleBuffered(true);

        loadAnimationHero();
    }

    // CONTROLS
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

    // ANIMATIONS
    private void loadAnimationHero() {
        // Inicia o array para aminação
        animations = new BufferedImage[20][20];

        // Importa as imagens do Heroi
        try {
            // Idle
            animations[0][0] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_0.png"));
            animations[0][1] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_1.png"));
            animations[0][2] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_2.png"));
            animations[0][3] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_3.png"));
            animations[0][4] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_4.png"));
            animations[0][5] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_5.png"));
            animations[0][6] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_6.png"));
            animations[0][7] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/idle/HeroKnight_Idle_7.png"));

            // Running
            animations[1][0] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_0.png"));
            animations[1][1] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_1.png"));
            animations[1][2] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_2.png"));
            animations[1][3] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_3.png"));
            animations[1][4] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_4.png"));
            animations[1][5] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_5.png"));
            animations[1][6] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_6.png"));
            animations[1][7] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_7.png"));
            animations[1][8] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_8.png"));
            animations[1][9] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/run/HeroKnight_Run_9.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAnimationHero() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= GetSpriteAmount(playerAction)) {
                animationIndex = 0;
            }
        }
    }

    public void setAnimationHero() {
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }

    private void updateMovingAnimationHero() {
        if (moving) {
            switch (playerDir) {
                case LEFT:
                    playerX -= playerSpeed;
                    break;
                case UP:
                    playerY -= playerSpeed;
                    break;
                case RIGHT:
                    playerX += playerSpeed;
                    break;
                case DOWN:
                    playerY += playerSpeed;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        updateAnimationHero();
        setAnimationHero();
        updateMovingAnimationHero();

        g2.drawImage(animations[playerAction][animationIndex], playerX, playerY, 256, 160, null);
        g2.dispose();
    }

    // GETTERS AND SETTERS
    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public int getPlayerSpeed() {
        return playerSpeed;
    }

    public int getPlayerDir() {
        return playerDir;
    }

    public void setPlayerDir(int playerDir) {
        this.playerDir = playerDir;
        setMoving(true);
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
