/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Graphics;

/**
 *
 * @author ceribellig8098
 */
public abstract class Ball implements MovingObject {

    private int xPos;
    private int yPos;
    private int r;

    public Ball(int x, int y, int w) {
        //add code here
        xPos = x;
        yPos = y;
        r = w;

    }
    public Ball() {
        xPos = 10;
        yPos = 10;
        r = 10;
    }

    public Ball(int x, int y) {
        xPos = x;
        yPos = y;
        r = 10;

    }

    

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void setX(int x) {
        //add code here
        xPos = x;
    }

    public void setY(int y) {
        //add code here
        yPos = y;
    }

    public int getX() {
        return xPos;   //finish this method
    }

    public int getY() {
        return yPos;  //finish this method
    }

    public void setRadius(int w) {
        r = w;//add code here
    }

    public int getRadius() {
        return r;  //finish this method
    }

    public abstract void move();

    public abstract void draw(Graphics window);

    public String toString() {
        return getX() + " " + getY() + " " + getRadius();
    }
}
