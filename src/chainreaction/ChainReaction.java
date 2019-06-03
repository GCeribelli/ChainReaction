/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainreaction;

import java.awt.Component;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author ceribellig8098
 */
public class ChainReaction extends JFrame{

    private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
        public static  boolean start = false;
        public static String name = "";

	public ChainReaction() throws IOException
	{
		super("Chain Reaction");
		setSize(WIDTH,HEIGHT);
                
		Game game = new Game(name);
		((Component)game).setFocusable(true);

		getContentPane().add(game);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

    /**
     *
     * @param args
     */
    public static void main( String args[] ) throws IOException
	{
            Background.main(args);
            while(!start){System.out.print("");}
		ChainReaction run = new ChainReaction();
	}
    
}
