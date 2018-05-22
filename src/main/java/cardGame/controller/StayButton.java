package cardGame.controller;

import cardGame.game.Draw;

import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;

/**
 * Button that shuffles all cards into the deck. It uses the Action API to 
 * perform its action which means that this is merely a default configuration 
 * for this button.
 */
public class StayButton extends JButton {
    
    /**
     * Initialise the properties of this button
     */
    private void setButtonProperties() {
        setVerticalTextPosition(AbstractButton.CENTER);
        setHorizontalTextPosition(AbstractButton.CENTER);
        setMnemonic(KeyEvent.VK_S);
        setToolTipText("Compare results");
    }
    
    /**
     * Create a reset button
     */
    public StayButton(Draw draw) {
        super(new StayAction(draw));
        setButtonProperties();
    }

}
