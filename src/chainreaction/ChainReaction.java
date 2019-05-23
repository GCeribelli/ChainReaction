/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author ceribellig8098
 */
public class ChainReaction extends JFrame{

    private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public ChainReaction()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		Game game = new Game();
		((Component)game).setFocusable(true);

		getContentPane().add(game);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main( String args[] )
	{
		ChainReaction run = new ChainReaction();
	}
    
}
