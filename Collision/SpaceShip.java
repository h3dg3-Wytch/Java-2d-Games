package Collision;

import Sprites.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class SpaceShip extends Sprite {

    private int dx;
    private int dy;
    private ArrayList<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);
        initSpaceShip();
    }

    private void initSpaceShip() {
        missiles = new ArrayList<Missile>();
        loadImage("spaceship.png");
        //Sets the images width and height
        getImageDimensions();
    }

    public void move(){
        x += dx;
        y += dy;

        if(x < 1){
            x = 1;
        }

        if(y < 1){
            y = 1;
        }

    }

    public ArrayList getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

}
