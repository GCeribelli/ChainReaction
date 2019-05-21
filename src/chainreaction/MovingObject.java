/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

/**
 *
 * @author ceribellig8098
 */
public interface MovingObject {

    public void setPos(int x, int y);

    public void setX(int x);

    public void setY(int y);

    public int getX();

    public int getY();

    public int getRadius();

    public void setRadius(int w);

    public void setXSpeed(int s);

    public int getXSpeed();

    public void setYSpeed(int s);

    public int getYSpeed();
}
