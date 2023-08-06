package logic;

import processing.core.PApplet;

public class Bird {
    private float x, y;
    private float velocityY;
    private final float gravity = 0.4f;
    private final float jumpStrength = -4.0f;

    public Bird(float x, float y) {
        this.x = x;
        this.y = y;
        this.velocityY = 0;
    }

    public void update() {
        velocityY += gravity;
        y += velocityY;
    }

    public void jump() {
        velocityY = jumpStrength;
    }

    public float getY() {
        return y;
    }

    public float getX(){
        return x;
    }

    public boolean collidesWithFloor(int floorY) {
        return y >= 1226;
    }
    public boolean collissionWithPipe(Pipe p){
        return (p.getXCoordinate() < x - 50) && (x - 50 < p.getXCoordinate() + p.getPipeWidth()) && (y - 306 < p.getPipeHeight() || (y - 306 > (p.getPipeHeight() + p.getPipeGap())));
    }




}