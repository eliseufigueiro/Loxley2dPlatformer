package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static utilz.Constants.Directions.*;
import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity {

    // PIXELS SETTINGS
    private final int SCALE = 3;
    private final int PLAYER_WIDTH_SIZE = 100 * SCALE;
    private final int PLAYER_HEIGHT_SIZE = 55 * SCALE;

    // ANIMATION SETTINGS
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 5;
    private int playerAction = IDLE;

    // CONTROLS SETTINGS
    private boolean moving = false;
    private boolean attacking = false;
    private boolean left, up, right, down;

    public Player(float x, float y, float playerSpeed) {
        super(x, y, playerSpeed);
        loadAnimationHero();
    }

    public void update() {
        updateAnimationHero();
        setAnimationHero();
        updateMovingAnimationHero();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][animationIndex], (int) x, (int) y, PLAYER_WIDTH_SIZE, PLAYER_HEIGHT_SIZE, null);
        g.dispose();
    }

    // CONTROLS
    private void updateMovingAnimationHero() {
        moving = false;

        if (left && !right) {
            x -= playerSpeed;
            moving =true;
        } else if (right && !left) {
            x += playerSpeed;
            moving =true;
        }

        if (up && !down) {
            y -= playerSpeed;
            moving =true;
        } else if (down && !up) {
            y += playerSpeed;
            moving =true;
        }
    }

    public void resetDirectBooleans() {
        up = false;
        left = false;
        down = false;
        right = false;
    }

    // STADE ANIMATIONS
    public void setAnimationHero() {
        int startAnimation = playerAction;
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
        if (attacking) {
            playerAction = ATTACK_1;
        }
        if (startAnimation != playerAction) {
            resetAnimationHero();
        }
    }

    // ANIMATIONS
    public void updateAnimationHero() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= GetSpriteAmount(playerAction)) {
                animationIndex = 0;
                attacking = false;
            }
        }
    }

    private void resetAnimationHero() {
        animationTick = 0;
        animationIndex= 0;
    }

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

            animations[2][0] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/Attack1/HeroKnight_Attack1_0.png"));
            animations[2][1] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/Attack1/HeroKnight_Attack1_1.png"));
            animations[2][2] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/Attack1/HeroKnight_Attack1_2.png"));
            animations[2][3] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/Attack1/HeroKnight_Attack1_3.png"));
            animations[2][4] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/Attack1/HeroKnight_Attack1_4.png"));
            animations[2][5] = ImageIO.read(getClass().getResourceAsStream("/resources/players/hero/Attack1/HeroKnight_Attack1_5.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // GETTER AND SETTER
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
