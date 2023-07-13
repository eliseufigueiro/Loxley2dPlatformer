package main;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS = 60;

    public Game() {
        System.out.println("Hello Loxley! 2D Adventure.");

        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
//    public void run() {
//        double timePerFrame = 1000000000.0 / FPS;
//        long lastFrame = System.nanoTime();
//        long now;
//
//        int frames = 0;
//        long lastCheck = System.currentTimeMillis();
//
//        while (gameThread != null) {
//            now = System.nanoTime();
//            if (now - lastFrame >= timePerFrame) {
//                gamePanel.repaint();
//                lastFrame = now;
//                frames++;
//            }
//
//            if (System.currentTimeMillis() - lastCheck >= 1000) {
//                lastCheck = System.currentTimeMillis();
//                System.out.println("FPS: " + frames);
//                frames = 0;
//            }
//        }
//    }

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
            renderGame();

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

    private void updateGameLogic(double delta) {
        // Atualizar a lógica do jogo com base no delta de tempo
        // ...
    }

    private void renderGame() {
        // Renderizar o jogo
        gamePanel.repaint();
    }

}
