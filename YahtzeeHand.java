/**
 * This class completes the methods given by JHU CTY AP CS Course Final Project.
 * The methods are for managing ones hand of die in yahtzee.
 */
package yahtzeePT2;

import java.util.ArrayList;
/* Starter file for JHU CTY AP CS Course Final Project 
 * Initial code for YahtzeeHand with stub implementations
 */

public class YahtzeeHand {
	// declare variables and objects
	private int[] hand = new int[5];
	Die die;
	
	// constructor
	public YahtzeeHand() {
		die = new Die();
	}
    /*
     * Returns array of integers with current values of the dice
     */
    public int[] getDice() {
    	return hand;
    }
    
    /* Roll all dice */
    public void rollAll() {
    	for (int i = 0; i < hand.length; i++) {
    		hand[i] = die.roll();
    	}
    }

    /* Rolls specific dice */
    public void roll(int number) {
    	hand[number - 1] = die.roll();
    }
    
    /* Allow user to change dice by rolling two
     * more times, user can choose which dice to keep
     */
    public void changeHand(ArrayList<Integer> indxToKeep) {
    	// array for which indxs to keep
    	boolean[] keep = new boolean[hand.length];

    	for (int i = 0; i < indxToKeep.size(); i++) {
    		keep[indxToKeep.get(i) - 1] = true;
    	}
    	
    	// roll those that are not to be kept
    	for (int i = 0; i < hand.length; i++) {
    		if (!keep[i]) {
    			hand[i] = die.roll();
    		}
    	}
    }
    
    /* Returns value of specified dice */
    public int get(int number) {
        return  hand[number-1];
    }

    /* Return string representing current state of the dice in 
     * the following format (or similar):
     * +------+---+---+---+---+---+
     * | Dice | 1 | 2 | 3 | 4 | 5 |
     * +------+---+---+---+---+---+
     * | Face | 4 | 2 | 4 | 6 | 1 | 
     * +------+---+---+---+---+---+
     * 
     */
    public String showDice() {
    	return "      +------+---+---+---+---+---+\r\n"
    			+ "      | Dice | 1 | 2 | 3 | 4 | 5 |\r\n"
    			+ "      +------+---+---+---+---+---+\r\n"
    			+ "      | Face | " + hand[0] + " | " + hand[1] + " | " + hand[2] + " | " + hand[3] + " | " + hand[4] + " | \r\n"
    			+ "      +------+---+---+---+---+---+";
    }
}
