package view;

import ddf.minim.*;
import logic.Bird;
import logic.Pipe;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class GameView extends PApplet {
    private Minim minim;
    private Bird bird;
    PImage background;
    private int scrolling;
    PImage gO;
    PImage b1;
    PImage b;

    private ArrayList<Pipe> pipes = new ArrayList<Pipe>();
    int c = 0;
    int start = 0;
    int game=0;
public boolean paused=false;
    public static void main(String[] args) {
        PApplet.main("view.GameView");
    }

    public void settings() {
        size(800, 1226);
    }

    public void setup() {
        bird = new Bird(100, 613); // Create the bird at a fixed X position and centered Y position
        pipes.add(new Pipe(30, 100, 400, 300));
        pipes.add(new Pipe(30, 120, 300, 600));
        background = loadImage("src/3.jpg");
        b = loadImage("src/p.jpg");
        gO = loadImage("src/2.jpg");
        scrolling = -3;
        b1 = loadImage("src/b1.jpg");


    }

    public void draw() {
        if(!paused) {
            if (start == 1) {
                if (gameOver()) {
                    game = 0;
                } else game = 1;
                if (game == 1) {
                    resetPipes();
                    if (c % 10 == 0) {
                        background(background);

                        for (Pipe pipe : pipes) {
                            fill(200);
                            pipe.setXCoordinate(pipe.getXCoordinate() + scrolling);
                            rect(pipe.getXCoordinate(), 0, pipe.getPipeWidth(), pipe.getPipeHeight());
                            rect(pipe.getXCoordinate(), pipe.getPipeGap() + pipe.getPipeHeight(), pipe.getPipeWidth(), 1226 - (pipe.getPipeHeight() + pipe.getPipeGap()));

                        }
                        bird.update();
                        image(b, bird.getX() - 50, bird.getY() - height / 4);
                    }
                    c += 2;
                } else {
                    background(gO);
                    fill(255);
                    textSize(40);
                    text(" Press s to restart", 40, 20);
                }
            } else {
                background(b1);
                fill(255);
                textSize(50);
                text("Press Enter to start", 50, 550);
            }
        } else{
            // Draw the paused screen or message
            background(0); // You can replace this with your own pause screen
            fill(255);
            textSize(40);
            text("Game Paused", (float) width / 2 - 100, (float) height / 2);
        }
    }


    public void keyPressed() {
        if (keyCode == UP) bird.jump();
        if (keyCode == ENTER) start = 1;
        if (key == 's' && game == 0) {
            start = 1;
            resetGame(); // Call the method to reset the game
        } else if (key == 'p' || key == 'P') {
            paused = !paused; // Toggle pause state when 'P' key is pressed
        }
    }
    public boolean gameOver() {
        if (bird.collidesWithFloor(1226)) return true;
        for (Pipe pipe : pipes) {
            if (bird.collissionWithPipe(pipe)) return true;
        }
            return false;
    }

    private void resetPipes(){
                for(Pipe pipe:pipes){
                    if(pipe.getXCoordinate()+scrolling<=0) pipe.setXCoordinate(width);
                }
    }
    private void resetGame() {
        // Reset bird position
        bird = new Bird(100, 613);

        // Reset pipes positions
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            int initialX = width + 300 + i * 300; // Adjust the initial position of each pipe as needed
            pipe.setXCoordinate(initialX);
        }

        // Reset scrolling offset
        scrolling = -3;

        // Reset game-over flag
        game = 1;
    }
}



