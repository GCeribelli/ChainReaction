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
import java.io.FileWriter;
import javax.swing.JLabel;

/**
 *
 * @author ceribellig8098
 */
public class Game extends Canvas implements MouseListener, Runnable {

    private int timer;
    private int uTime;
    private JLabel[] game;
    private BufferedImage back;
    private ExpandedBall user;
    private ArrayList<ExpandedBall> expanded;
    private GameBalls balls;
    private MovingBalls b;
    private int topScore;
    private int score;
    private FileWriter tS;
    private int count;
    

    public Game() {
        Label l;
        count = 0;
        timer = 0;
        uTime = 0;
        expanded = new ArrayList<ExpandedBall>();
//        expanded.add(new ExpandedBall(0,0,0,0,0));
//        b = new MovingBalls(300, 300, 15, 1, 1);
        addMouseListener(this);
        setSize(800, 600);
        balls = new GameBalls(40);
        user = new ExpandedBall(0, 0, 0, 0, timer);
        setVisible(true);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        Graphics2D twoDGraph = (Graphics2D) window;
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }
        Graphics graphToBack = back.createGraphics();
        graphToBack.setColor(Color.WHITE);
        graphToBack.fillRect(0, 0, 800, 600);
        graphToBack.setColor(Color.BLUE);
        graphToBack.drawString("Chain Reaction Top Score: " + topScore, 25, 50);
        //twoDGraph.drawImage(back, null, 0, 0);

        balls.drawEm(graphToBack);
        balls.moveEm();
        if(uTime < 300)
            user.draw(graphToBack);
        else
            user.recede(graphToBack);
        balls.expand(user, timer, expanded);

        for (int i = 0; i < balls.getSize(); i++) {
            expanded.add(balls.getBallE(i));
        }

        for (ExpandedBall i : expanded) {
            if (timer - i.getTime() > 300) {
                i.recede(graphToBack);
            } else {
                i.draw(graphToBack);
            }
        }

        for (ExpandedBall i : expanded) {
            if (i.getStep() == 0) {
                count++;
            }
        }
        if (count == expanded.size()) {
            score = expanded.size() * 150;
            if (score > topScore) {
                topScore = score;
            }
        }

        balls.toString();
        timer++;
        uTime++;
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        user = new ExpandedBall(e.getX(), e.getY(), 10, 60, timer);
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
                Thread.currentThread().sleep(1);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
