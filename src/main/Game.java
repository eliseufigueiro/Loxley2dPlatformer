package main;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {

        System.out.println("Hello Loxley!");
        gameWindow = new GameWindow();
        gamePanel = new GamePanel();
    }
}
