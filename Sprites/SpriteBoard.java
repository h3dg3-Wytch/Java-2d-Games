package Sprites;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class SpriteBoard extends JPanel implements ActionListener {

    private Timer timer;
    private SpaceCraft spaceCraft;
    private final int DELAY = 10;

    public SpriteBoard(){
        initBoard();
    }


    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        spaceCraft = new SpaceCraft();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceCraft.getImage(), spaceCraft.getX(), spaceCraft.getY(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        spaceCraft.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceCraft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceCraft.keyPressed(e);
        }
    }
}
