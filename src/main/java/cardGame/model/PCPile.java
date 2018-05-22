package cardGame.model;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

import javax.swing.JOptionPane;

import cardGame.util.Emptiable;
import cardGame.util.Sized;

public class PCPile implements Emptiable, Sized, Iterable<Card> {

    private Stack<Card> pile;
    private int sum = 0;
    private int acesInPile = 0;
    

	/**
     * Create a new empty discard pile
     */
    public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
    public PCPile() {
        pile = new Stack<>();
    }
    
    /**
     * Put a card on the discard pile
     */
    public void aces() {
    	
    	if ((this.getSum()>21)&&(acesInPile>0)) {
			   this.setSum(this.getSum()-10);
			   acesInPile--;
			   
		   }
    }
    public void put(Card card) {
        pile.push(card);
        
        switch (card.getFace()) {
            case ACE:  this.setSum(this.getSum()+11);
            			acesInPile++;
            			
	            		aces();
                     break;
            case TWO:  this.setSum(this.getSum()+2);
            		   aces();
                     break;
            case THREE: this.setSum(this.getSum()+3);
            			aces();
                     break;
            case FOUR:  this.setSum(this.getSum()+4);
            			aces();
                     break;
            case FIVE:  this.setSum(this.getSum()+5);
            			aces();
            			break;
            case SIX:  this.setSum(this.getSum()+6);aces();
                     break;
            case SEVEN:  this.setSum(this.getSum()+7);aces();
                     break;
            case EIGHT:  this.setSum(this.getSum()+8);aces();
                     break;
            case NINE:  this.setSum(this.getSum()+9);aces();
                     break;
            case TEN: this.setSum(this.getSum()+10);aces();
                     break;
            case JACK: this.setSum(this.getSum()+10);aces();
                     break;
            case QUEEN: this.setSum(this.getSum()+10);aces();
                     break;
            case KING: this.setSum(this.getSum()+10);aces();
            break;
            default: break;
        }
    }
    
    /**
     * Remove all cards from this discard pile
     */
    public Stack<Card> emptyPile() {
        Stack<Card> retVal = pile;
        pile = new Stack<>();
        return retVal;
    }
    
    /**
     * Returns the top card of the discard pile, or null if none is present
     */
    public Card top() {
        if(!isEmpty())
            return pile.peek();
        return null;
    }
    
    /**
     * Allows iterating over this discard pile without changing it
     * Does not support remove, so will throw an UnsuportedOperationException
     */
    private class ConcretePCPileIterator implements Iterator<Card> {
        
        private ListIterator<Card> backing;
        
        /**
         * Create an iterator for this immutable discard pile using the 
         * iterator of the DiscardPile it protects
         */
        public ConcretePCPileIterator() {
            backing = pile.listIterator(0);
        }
        
        /**
         * Find the next card in this discard pile
         */
        @Override
        public Card next() {
            return backing.next();
        }
        
        /**
         * Check if all cards have been looked at.
         */
        @Override
        public boolean hasNext() {
            return backing.hasNext();
        }
        
        /**
         * Removes a card from this discard pile
         */
        @Override
        public void remove() {
            backing.remove();
        }
    }
    
    /**
     * Returns an iterator which visits the cards in this discard pile
     * from BOTTOM to TOP, not from top to bottom.
     */
    @Override
    public Iterator<Card> iterator() {
        return new ConcretePCPileIterator();
    }
    
    /**
     * Check the number of cards in this pile
     */
    @Override
    public int size() {
        return pile.size();
    }
    
    /**
     * Check if there are any cards left in this pile.
     */
    @Override
    public boolean isEmpty() {
        return pile.isEmpty();
    }
    
    /**
     * Remove all the cards in this pile
     */
    @Override
    public void empty() {
        pile.clear();
    }

}
