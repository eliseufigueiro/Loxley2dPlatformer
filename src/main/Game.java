package main;

import entities.Player;

import java.awt.*;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private Player player;

    public Game() {
        System.out.println("Hello Loxley! 2D Adventure.");
        initClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        startGameLoop();
    }

    private void initClasses() {
        player = new Player(0, 0, 5.0f);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void updateGameLogic(double delta) {
        // Atualizar a lógica do jogo com base no delta de tempo
        player.update();

        // Verificar colisões ou outras lógicas do jogo
        //checkCollisions();
        //handleInput();
        // ...
    }

    public void renderGame(Graphics g) {
        // Renderizar o jogo
        player.render(g);
    }


    @Override
    public void run() {
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        long lastLoopTime = System.nanoTime();
        long lastFpsTime = 0;
        int fps = 0;

        while (gameThread != null) {
            long currentTime = System.nanoTime();
            long updateLength = currentTime - lastLoopTime;
            lastLoopTime = currentTime;
            double delta = updateLength / ((double) OPTIMAL_TIME);

            // Atualizar a lógica do jogo com base no delta
            updateGameLogic(delta);

            // Renderizar o jogo
            gamePanel.repaint();

            // Calcular o FPS
            lastFpsTime += updateLength;
            fps++;

            if (lastFpsTime >= 1000000000) {
                System.out.println("FPS: " + fps);
                lastFpsTime = 0;
                fps = 0;
            }

            // Limitar a taxa de quadros
            long sleepTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void windowFocusLost() {
        player.resetDirectBooleans();
    }

    // GETTER AND SETTER
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
