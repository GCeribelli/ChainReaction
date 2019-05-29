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
public class ExpandedBall{

    private int x;
    private int y;
    private int r1;
    private int r2;
    private int step;
    private int t;

    public ExpandedBall(int X, int Y, int radius1, int radius2, int time) {
        x = X;
        y = Y;
        r1 = radius1;
        r2 = radius2;
        step = 0;
        t = time;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getRadius(){
        return r2;
    }
    public int getStep(){
        return step;
    }
    public int getTime(){
        return t;
    }
    public void draw(Graphics window){
        if(step < 10){
            window.fillOval(x, y, r1 + ((r2-r1)/(10-step)), r1 + ((r2-r1)/(10-step)));
            step++;
        }else{
            window.fillOval(x, y, r2, r2);
        }
    }
    public void recede(Graphics window){
        if(step > 0){
            window.fillOval(x, y, r2 - (r2/(10-step)), r2 - (r2/(10-step)));
            step--;
        }else{
            window.fillOval(x, y, 0, 0);
        }
            
    }
    

}
