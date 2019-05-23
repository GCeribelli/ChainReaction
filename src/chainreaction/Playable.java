/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ceribellig8098
 */
public class Playable {

    private ArrayList<MovingBalls> balls;
    private ArrayList<ExpandedBall> eBalls;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Playable(int size) {
        int rX = 0;
        int rY = 0;
        eBalls = new ArrayList<ExpandedBall>();
        balls = new ArrayList<MovingBalls>();
        for (int i = 0; i < size; i++) {
            rX = (int) (Math.random() * 790);
            rY = (int) (Math.random() * 590);
            balls.add(new MovingBalls(rX, rY, 10, 2,2));
        }
    }

    public void add(MovingBalls al) {
        balls.add(al);
    }

    public void drawEmAll(Graphics window) {
        for (MovingBalls n : balls) {
            n.draw(window);
        }
    }

    public void moveEmAll() {
        for (MovingBalls i : balls) {
            if (i.getX() <= 0) {
                i.setXSpeed(-i.getXSpeed());
            } else if (i.getX() + i.getRadius() >= 800) {
                i.setXSpeed(-i.getXSpeed());
            }
            if (i.getY() + i.getRadius() >= 600) {
                i.setYSpeed(-i.getYSpeed());
            } else if (i.getY() <= 0) {
                i.setYSpeed(-i.getYSpeed());
            }
        }
    }
    public void removeDeadOnes(ExpandedBall b) {
            for(int i = 0; i < balls.size(); i++){
                if((b.getY() <= balls.get(i).getY() + balls.get(i).getRadius()) && (b.getY() >= balls.get(i).getY()) && (b.getX() <= balls.get(i).getX() + balls.get(i).getRadius()) && (b.getX() >= balls.get(i).getX())){
                    eBalls.add(new ExpandedBall(balls.get(i).getX(),balls.get(i).getY(),balls.get(i).getRadius(), 20));
                    balls.remove(i);
                }
        }
    }
}
