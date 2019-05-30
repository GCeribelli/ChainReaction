/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Graphics;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ceribellig8098
 */
public class GameBalls {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private ArrayList<MovingBalls> balls;
    private ArrayList<ExpandedBall> ballE;

    public GameBalls(int size) {
        balls = new ArrayList<MovingBalls>();
        ballE = new ArrayList<ExpandedBall>();
        int rX = 0;
        int rY = 0;
        int rXS = 0;
        int rYS = 0;
        for (int i = 0; i < size; i++) {
            rX = (int) (Math.random() * 760);
            rY = (int) (Math.random() * 540);
            rXS = (int) (Math.random() * 1);
            rYS = (int) (Math.random() * 1);
            if (rXS % 2 == 1) {
                rXS = 1;
            }
            if (rXS % 2 == 0) {
                rXS = -1;
            }
            if (rYS % 2 == 1) {
                rYS = 1;
            }
            if (rYS % 2 == 0) {
                rYS = -1;
            }
            balls.add(new MovingBalls(rX, rY, 15, rXS, rYS));
        }
    }

    public void add(MovingBalls al) {
        balls.add(al);
    }

    public void moveEm() {
        for (MovingBalls i : balls) {
            i.move();
            if (i.getX() <= 0 || i.getX() >= 760) {
                i.setXSpeed(-i.getXSpeed());
                i.setYSpeed(-i.getYSpeed());
            } else if (i.getY() <= 0 || i.getY() >= 540) {
                i.setYSpeed(-i.getYSpeed());
            }
        }

    }

    public void drawEm(Graphics window) {
        for (MovingBalls i : balls) {
            i.draw(window);
        }
    }

    public void expand(ExpandedBall b, int time, ArrayList<ExpandedBall> y) {
        for (int a = 0; a < balls.size(); a++) {
            if ((balls.get(a).getY() <= b.getY() + b.getRadius()) && (balls.get(a).getY() >= b.getY()) && (balls.get(a).getX() <= b.getX() + b.getRadius()) && (balls.get(a).getX() >= b.getX())) {
                ballE.add(new ExpandedBall(balls.get(a).getX(), balls.get(a).getY(), 15, 60, time));
                balls.remove(a);
            }else{
            for (ExpandedBall i : y) {
                if (i.getStep() > 0) {
                    if ((balls.get(a).getY() <= i.getY() + i.getRadius()) && (balls.get(a).getY() >= i.getY()) && (balls.get(a).getX() <= i.getX() + i.getRadius()) && (balls.get(a).getX() >= i.getX())) {
                        ballE.add(new ExpandedBall(balls.get(a).getX(), balls.get(a).getY(), 15, 60, time));
                        balls.remove(a);
                    }
                }
            }}

        }
    }

    public int getSize() {
        return ballE.size();
    }

    public ExpandedBall getBallE(int i) {
        return ballE.get(i);
    }

    public String toString() {
        String s = "";
        for (MovingBalls i : balls) {
            s += i.toString() + "\n";
        }
        return s;
    }
}
