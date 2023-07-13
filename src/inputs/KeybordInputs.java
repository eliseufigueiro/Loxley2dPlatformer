package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Directions.*;

public class KeybordInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeybordInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.setPlayerDir(UP);
            case KeyEvent.VK_A -> gamePanel.setPlayerDir(LEFT);
            case KeyEvent.VK_S -> gamePanel.setPlayerDir(DOWN);
            case KeyEvent.VK_D -> gamePanel.setPlayerDir(RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.setMoving(false);
                break;
        }
    }
}
