package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            //case KeyEvent.VK_W -> gamePanel.changePlayerY(-5);
            case KeyEvent.VK_W -> gamePanel.changePlayerY(-5);
            case KeyEvent.VK_A -> gamePanel.changePlayerX(-5);
            case KeyEvent.VK_S -> gamePanel.changePlayerY(5);
            case KeyEvent.VK_D -> gamePanel.changePlayerX(5);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
