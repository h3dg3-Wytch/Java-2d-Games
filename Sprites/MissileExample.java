package Sprites;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class MissileExample extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int DELAY = 10;
    private Timer timer;
    private Craft craft;

    public MissileExample(){
        initBoard();
    }

    private void initBoard() {

        addKeyListener( new MissileAdapter());
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);

        craft = new Craft(ICRAFT_X, ICRAFT_Y);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        ArrayList<Missile> list = craft.getMissiles();
        for(Missile missile : list){
            g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);

        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        updateMissiles();
        updateCraft();

        repaint();


    }

    private void updateCraft() {

        craft.move();

    }

    private void updateMissiles() {

        ArrayList<Missile> list = craft.getMissiles();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isVisible()){
                list.get(i).move();
            }else{
                list.remove(i);
            }
        }


    }


    private class MissileAdapter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            //Do nothing

        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);

        }
    }
}
