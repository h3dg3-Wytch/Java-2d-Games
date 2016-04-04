package Animation;

import javax.rmi.CORBA.Util;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class UtilityTimerBoard extends JPanel {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Image star;
    private int x, y;
    private java.util.Timer timer;

    public UtilityTimerBoard() {
        
        initBoard();
    }



    private void loadImage() {

        ImageIcon ii = new ImageIcon("star.png");
        star = ii.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;

        //Creates a timer and schedule a task with a spefic interval.
        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new UtilityScheduleTask(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStar(g);
    }

    private void drawStar(Graphics g) {
        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private class UtilityScheduleTask extends TimerTask{
        @Override
        public void run() {
            x += 1;
            y += 1;

            if (y > B_HEIGHT) {
                y = INITIAL_Y;
                x = INITIAL_X;
            }

            repaint();

        }
    }
}
