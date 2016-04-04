package Sprites;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class Craft extends Sprite {

    private int dx;
    private int dy;
    private ArrayList<Missile> missiles;

    public Craft(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
         missiles = new ArrayList<Missile>();
        loadImage("spaceship.png");
        getImageDimensions();
    }

    public void move(){
        x += dx;
        y += dy;
    }

    public ArrayList<Missile> getMissiles(){
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

    //Takes the current x and y coordinates, then fires a missile.
    //THe missiles are added to an arraylist
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
