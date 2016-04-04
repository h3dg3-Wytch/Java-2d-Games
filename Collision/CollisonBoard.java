package Collision;

import Sprites.Craft;
import Sprites.Missile;

import javax.accessibility.AccessibleIcon;
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
public class CollisonBoard extends JPanel implements ActionListener {

    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 400;
    private final int B_HEIGHT = 300;
    private final int DELAY = 15;
    
    private Timer timer;
    private SpaceShip spaceShip;
    private ArrayList<Alien> aliens;
    private boolean ingame;
    

    private final int[][] pos = {
            {2380, 29}, {2500, 59}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239},
            {790, 259}, {760, 50}, {790, 150},
            {980, 209}, {560, 45}, {510, 70},
            {930, 159}, {590, 80}, {530, 60},
            {940, 59}, {990, 30}, {920, 200},
            {900, 259}, {660, 50}, {540, 90},
            {810, 220}, {860, 20}, {740, 180},
            {820, 128}, {490, 170}, {700, 30}
    };
    
    public CollisonBoard(){
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new CollisonAdapter());
        setFocusable(true);
        setBackground(Color.black);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        spaceShip = new SpaceShip(ICRAFT_X, ICRAFT_Y);

        initAliens();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initAliens() {
        aliens = new ArrayList<Alien>();
        for(int[] p : pos){
            aliens.add(new Alien(p[0], p[1]));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(ingame){
            drawObjects(g);
        }else{
            drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawGameOver(Graphics g) {
        String message = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(message, (B_WIDTH - fm.stringWidth(message)) / 2, B_HEIGHT / 2);

    }

    private void drawObjects(Graphics g) {

        if(spaceShip.isVisible()){
            g.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);
        }

        ArrayList<Missile> missiles = spaceShip.getMissiles();
        for(Missile m: missiles){
            if(m.isVisible()){
                g.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
        }

        for(Alien a : aliens){
            if(a.isVisible()){
                g.drawImage(a.getImage(), a.getX(), a.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Aliens left: "  + aliens.size(), 5, 15);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateSpaceship();
        updateMissiles();
        updateAliens();

        checkCollisions();

        repaint();

    }

    private void inGame() {

        if(!ingame){
            timer.stop();
        }
    }

    private void updateSpaceship() {
        if(spaceShip.isVisible()){
            spaceShip.move();
        }
    }

    private void updateMissiles(){

        ArrayList<Missile> list = spaceShip.getMissiles();

        for(int i = 0; i < list.size(); i++){
            Missile m = list.get(i);
            if(m.isVisible()){
                m.move();
            }else{
                list.remove(i);
            }
        }

    }
    private void updateAliens() {
    }

    private void checkCollisions() {
    }

    private class CollisonAdapter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            //Nothing to see here, keep it moving
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
