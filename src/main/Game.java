package main;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {

        System.out.println("Hello Loxley!");

        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }
}
