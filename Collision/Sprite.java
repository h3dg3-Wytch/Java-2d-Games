package Collision;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;

    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void getImageDimensions(){
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName){

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();

    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        visible = visible;
    }

    //Returns the bounding rectangle of the sprite image. We need the bounds in collison detection
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }


}
