package Basics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class ImageBoard extends JPanel {

    private Image darlene;

    public ImageBoard(){

        initBoard();

    }

    //Loads the image
    public void loadImage(){

        ImageIcon ii = new ImageIcon("spaceship.png");
        System.out.println(ii.getImage().getHeight(this));
        darlene = ii.getImage();

    }

    private void initBoard() {

        loadImage();

        int w = darlene.getWidth(this);
        int h = darlene.getHeight(this);
        setPreferredSize(new Dimension(w,h));

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(darlene, 0, 0, null);
    }
}
