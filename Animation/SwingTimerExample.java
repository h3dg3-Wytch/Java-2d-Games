package Animation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class SwingTimerExample extends JFrame {

    public SwingTimerExample(){
        initUI();
    }

    private void initUI() {

        add(new SwingTimerBoard());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new SwingTimerExample();
                ex.setVisible(true);
            }
        });
    }
}
