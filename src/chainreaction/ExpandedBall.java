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

    public ExpandedBall(int X, int Y, int radius1, int radius2) {
        x = X;
        y = Y;
        r1 = radius1;
        r2 = radius2;
        step = 0;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getStep(){
        return step;
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
            window.fillOval(x, y, r1 + ((r2-r1)/(10-step)), r1 + ((r2-r1)/(10-step)));
            step--;
        }else{
            window.fillOval(x, y, r1, r1);
        }
            
    }
    

}
