/**
 * This class completes the methods given by JHU CTY AP CS Course Final Project.
 * The methods are to simulate a dice.
 */
package yahtzeePT2;

/* Starter file for JHU CTY AP CS Course Final Project 
 * Initial code for Die with stub implementations
 */

public class Die {
	// declare variables
	private int value;
	
	// default constructor
	public Die() {
		value = 0;
	}
    /* Roll a die and return its numerical value */
    public int roll() {
    	value = (int) (Math.random() * 6 + 1);
    	return value;
    }
    
    /* Return numerical value of the die without re-rolling it */
    public int getValue() {
    	return value;
    }
}