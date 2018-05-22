package cardGame.controller;

import cardGame.game.Draw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * Represents an action made to shuffle all cards back into the deck. Although
 * useless on an empty discard pile, this action is always available.
 */
public class StayAction extends AbstractAction {
	
	private Draw draw;
	public StayAction(Draw draw) {
        super("Stay");
        this.draw = draw;
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		while (draw.getPCPile().getSum()<17){
			draw.move2();
		}
		 if (draw.getPCPile().getSum()>21) {
	        	JOptionPane.showMessageDialog(null,String.format("PC is busted"));
	        	draw.reset();
	        }else if (draw.getPlayerPile().getSum()==draw.getPCPile().getSum()) {
	        	JOptionPane.showMessageDialog(null,String.format("Draw"));
	        	draw.reset();
	        }else if (draw.getPlayerPile().getSum()<draw.getPCPile().getSum()) {
	        	JOptionPane.showMessageDialog(null,String.format("You lost"));
	        	draw.reset();
	        }else if (draw.getPlayerPile().getSum()>draw.getPCPile().getSum()) {
	        	JOptionPane.showMessageDialog(null,String.format("You won"));
	        	draw.reset();
	        }
	}

    
    
}
