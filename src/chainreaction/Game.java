/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author ceribellig8098
 */
public class Game extends Canvas implements MouseListener, Runnable {

    private int timer;
    private JLabel[] game;
    private boolean[] keys;
    private BufferedImage back;
    private ExpandedBall user;
    private ArrayList<MovingBalls> balls;


    public Game() {
        balls = new ArrayList<MovingBalls>();
        Label l;
        addMouseListener(this);
        for(int i = 0; i < 40; i++)
            balls.add(new MovingBalls(300, 300, 50, 50, 2));
        setSize(800, 600);
        setVisible(true);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }
    public void moveEm(){
        System.out.println(1);
        for(MovingBalls i : balls)
            System.out.println(i.toString());
        for(MovingBalls i : balls)
            i.move();
        System.out.println(2);
        for(MovingBalls i : balls)
            System.out.println(i.toString());
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }
        for(MovingBalls i : balls)
            i.move();
        for(MovingBalls i : balls)
            System.out.println(i.toString());


        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.GRAY);
        graphToBack.fillRect(0, 0, 800, 600);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("Chain Reaction ", 25, 50);
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        user = new ExpandedBall(e.getX(), e.getY(), 10, 40);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
