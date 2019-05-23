/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Graphics;
import java.awt.Color;

/**
 *
 * @author ceribellig8098
 */
public class MovingBalls extends Ball {

    private int speedX;
    private int speedY;

    public MovingBalls(int x, int y, int r, int sX, int sY) {
        super(x, y, r);
        speedX = sX;
        speedY = sY;
    }

    public MovingBalls() {
        this(0, 0, 10, 2, 2);
    }

    public MovingBalls(int x, int y) {
        this(x, y, 10, 2, 2);
    }

    public MovingBalls(int x, int y, int r) {
        this(x, y, r, 2, 2);
    }

    public void setXSpeed(int s) {
        speedX = s;
    }

    public void setYSpeed(int s) {
        speedY = s;
    }

    public int getXSpeed() {
        return speedX;
    }

    public int getYSpeed() {
        return speedY;
    }

    public void move() {
        setX(getX() + getXSpeed());
        setY(getY() + getYSpeed());
    }

    public void draw(Graphics window) {
        window.fillOval(getX(), getY(), getRadius(), getRadius());
    }

    public String toString() {
        return "";
    }

}
