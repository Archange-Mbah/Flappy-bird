package view;

import logic.Bird;
import processing.core.PApplet;
import logic.*;
import processing.core.PImage;

import java.util.ArrayList;

public class GameView extends PApplet {
    private Bird bird;
    PImage background;
    PImage b;
    private ArrayList<Pipe> pipes=new ArrayList<Pipe>();
    int c=0;

    public static void main(String[] args) {
        PApplet.main("view.GameView");
    }

    public void settings() {
        size(800, 1226);
    }

    public void setup() {
        bird = new Bird(100, height / 2); // Create the bird at a fixed X position and centered Y position
        pipes.add(new Pipe(30,100,400,300));
        pipes.add( new Pipe( 30,120,300,600));
        background=loadImage("src/3.jpg");
        b=loadImage("src/p.jpg");

    }

    public void draw() {

          while(!gameOver()) {
              if (c % 10 == 0) {
                  background(background);

                  for (Pipe pipe : pipes) {
                      fill(200);
                      rect(pipe.getXCoordinate(), 0, pipe.getPipeWidth(), pipe.getPipeHeight());
                      rect(pipe.getXCoordinate(), pipe.getPipeGap() + pipe.getPipeHeight(), pipe.getPipeWidth(), 1226 - (pipe.getPipeHeight() + pipe.getPipeGap()));
                  }
                  bird.update();
                  ellipse(bird.getX(), bird.getY(), 30, 40);
                  image(b, bird.getX() - 50, bird.getY() - height / 4);
              }
              c += 2;
          }

    }
    public void keyPressed() {
        if (keyCode ==UP) {
            bird.jump();
        }
    }
    public boolean gameOver(){
        if(bird.collidesWithFloor(1226)) return true;
    for(Pipe pipe:pipes){
        if(bird.collissionWithPipe(pipe)) return true;
    }
    return false;
    }
}
