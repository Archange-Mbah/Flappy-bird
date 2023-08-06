package logic;

import processing.core.PApplet;

public class Pipe {
    private int  pipeWidth,pipeGap,pipeHeight,xCoordinate;

    public Pipe(int pW, int g,int pH,int x){
        pipeWidth=pW;
        pipeGap=g;
        pipeHeight=pH;
        xCoordinate=x;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }
    public int getPipeWidth(){
        return pipeWidth;
    }
    public int getPipeGap() {
        return pipeGap;
    }
    public int getPipeHeight() {
        return pipeHeight;
    }

    public void setXCoordinate(float v) {
        xCoordinate=(int)v;
    }
}
