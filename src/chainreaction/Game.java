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
import java.awt.Font;
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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int c;
    private String name;
    private boolean click;
    private boolean done;
    private File file = null;

    public Game(String n) throws IOException {
        File file = new File("topScore.txt");

        if(file.length() != 0){
                BufferedReader br = new BufferedReader(new FileReader(file));
                Scanner key = new Scanner(file);
                key.useDelimiter("\\Z");
                String str = key.next();
                int oldScore = Integer.parseInt(str);
                topScore = oldScore;
                key.close();
        }else{topScore = 0;}
        
        
        Label l;
        name = n;
        done = false;
        click = false;
        count = 0;
        timer = 0;
        uTime = 0;
        c = 0;
        expanded = new ArrayList<ExpandedBall>();
        addMouseListener(this);
        setSize(800, 600);
        balls = new GameBalls(40);
        user = new ExpandedBall(0, 0, 0, 0, timer);
        setVisible(true);
        new Thread(this).start();
        tS = new FileWriter("topScore.txt");

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
        if (!done) {
            graphToBack.setColor(Color.BLUE);
            graphToBack.drawString(name + "'s Score: " + score + " Top Score: " + topScore, 25, 50);

            balls.drawEm(graphToBack);
            balls.moveEm();
            if (uTime < 300) {
                user.draw(graphToBack);
            } else {
                user.recede(graphToBack);
            }
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
            score = balls.getScore() * 150;
            if (topScore < score) {
                topScore = score;
            }

            for (ExpandedBall b : expanded) {
                if (b.getDone()) {
                    c++;
                }
            }
            if (c == expanded.size() && c > 0) {
                done = true;
            }
            c = 0;

            balls.toString();
            timer++;
            uTime++;
            twoDGraph.drawImage(back, null, 0, 0);
        } else {
            graphToBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
            graphToBack.setColor(Color.red);
            graphToBack.drawString("GAME OVER", 250, 250);
            graphToBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            graphToBack.setColor(Color.blue);
            graphToBack.drawString(name + "'s Score: " + score + " Top Score: " + score, 25, 50);
            twoDGraph.drawImage(back, null, 0, 0);
            try {
                System.out.println(topScore);
                String a = String.valueOf(topScore);
                System.out.println("Topscore:" + a);
                tS.write(a);
                tS.close();
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(click);
        if (!click) {
            user = new ExpandedBall(e.getX(), e.getY(), 10, 60, timer);
            click = true;
        }
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
