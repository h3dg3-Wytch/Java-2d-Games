package Sprites;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class SpriteExample extends JFrame {

    public SpriteExample(){
        initUI();
    }

    private void initUI() {

        add(new SpriteBoard());

        setSize(500, 400);
        setResizable(false);

        setTitle("Moving sprite");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                SpriteExample ex = new SpriteExample();
                ex.setVisible(true);
            }
        });
    }
}
