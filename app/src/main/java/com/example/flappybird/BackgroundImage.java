package com.example.flappybird;

public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, backgroundImageVelocity;

    public BackgroundImage() {
        backgroundImageX = 0;
        backgroundImageY = 0;
        backgroundImageVelocity = 5;
    }

    public int getX(){
        return backgroundImageX;
    }

    public  int getY(){
        return backgroundImageY;
    }

    public void setX(int backgroundImageX) {
        this.backgroundImageX = backgroundImageX;
    }

    public void setY(int backgroundImageY) {
        this.backgroundImageY = backgroundImageY;
    }

    public int getVelocity() {
        return backgroundImageVelocity;
    }
}
