package Sprites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class SpaceCraft {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public SpaceCraft(){
        initCraft();
    }

    private void initCraft(){
        ImageIcon ii = new ImageIcon("spaceship.png");
        image = ii.getImage();

        x = 40;
        y = 60;
    }

    //Whether the sprite is moving.
    //It changes the coordinates of the sprite.
    public void move(){

        x += dx;
        y += dy;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage(){
        return image;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

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
