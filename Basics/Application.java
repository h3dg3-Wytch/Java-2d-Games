package Basics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class Application extends JFrame {

    public Application(){
        initUI();
    }

    private void initUI() {
        //Entry point of the game
        add(new Board());
        //Pu the board in the center of the Jframe container
        setSize(250, 200);

        setTitle("App");
        //Sets the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Centers the window on the screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Application ex = new Application();
                ex.setVisible(true);
            }
        });
    }
}
