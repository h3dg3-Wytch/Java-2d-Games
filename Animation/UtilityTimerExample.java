package Animation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class UtilityTimerExample extends JFrame {

    public UtilityTimerExample() {

        initUI();
    }

    private void initUI() {

        add(new UtilityTimerBoard());

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
                JFrame ex = new UtilityTimerExample();
                ex.setVisible(true);
            }
        });
    }
}
