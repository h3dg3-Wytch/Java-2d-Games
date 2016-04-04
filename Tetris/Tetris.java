package Tetris;

import Basics.Board;

import javax.swing.*;
import java.awt.*;

/**
 * Created by h3dg3wytch on 4/3/16.
 */
public class Tetris extends JFrame {

    private JLabel statusBar;

    public Tetris(){

        statusBar = new JLabel(" 0");
        add(statusBar, BorderLayout.SOUTH);
        Board board = new Board();

    }

    public JLabel getStatusBar() {
        return statusBar;
    }
}
