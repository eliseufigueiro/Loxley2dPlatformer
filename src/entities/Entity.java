package entities;

public class Entity {

    protected float x, y, playerSpeed;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Entity(float x, float y, float playerSpeed) {
        this.x = x;
        this.y = y;
        this.playerSpeed = playerSpeed;
    }


}
