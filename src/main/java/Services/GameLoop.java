package Services;

import Models.Pet;
import Services.Time.Time;

public class GameLoop implements Runnable {
    private boolean isRunning = false;
    private Pet pet;
    
    private final int TARGET_FPS = 60;
    private final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

    public GameLoop(Pet pet) {
        this.pet = pet;
    }

    public void start(){
        if (isRunning) return;
        isRunning = true;
        new Thread(this).start();
        System.out.println("Game Loop started.");
    }

    public void stop(){
        isRunning = false;
        System.out.println("Game Loop stopped.");
    }

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();
        while (isRunning) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;

            Time.update(now);
            
            updateGame();

            render();

            try {
                long sleepTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1_000_000;
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
            }
        }
    }
    private void updateGame() {
        pet.update();
    }

    private void render() {
    }
    
}
