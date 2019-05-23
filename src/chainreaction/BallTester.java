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

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class BallTester extends Canvas{

    public static void main( String args[] ){
//        JFrame frame = new JFrame("My Drawing");
//        Canvas canvas = new BallTester();
//        canvas.setSize(400, 400);
//        frame.add(canvas);
//        frame.pack();
//        frame.setVisible(true);
        Game game = new Game();
        game.moveEm();
    }

}
