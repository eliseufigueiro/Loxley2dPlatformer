package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeybordInputs implements KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> System.out.println("Key W!");
            case KeyEvent.VK_A -> System.out.println("Key A!");
            case KeyEvent.VK_S -> System.out.println("Key S!");
            case KeyEvent.VK_D -> System.out.println("Key D!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
