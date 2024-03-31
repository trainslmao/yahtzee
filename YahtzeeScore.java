/**
 * This class completes the methods given by JHU CTY AP CS Course Final Project.
 * The methods are for scoring Yahtzee
 * @author Bryan Zhang
 */

package yahtzeePT2;

import java.util.Arrays;
/* Starter file for JHU CTY AP CS Course Final Project 
 * Initial code for YahtzeeScore with stub implementations
 */

public class YahtzeeScore {
	// array for die value and array without duplicates
	private int[] die = new int[5];
	private int[] unique;
	
	/* Constructor, parameter dice contains values of dice to be scored 
	 * */
	public YahtzeeScore(int[] dice) {
		for (int i = 0; i < die.length; i++) {
			die[i] = dice[i];
		}
		removeDuplicates();
	}

	// remove duplicates and sort array
	public int[] removeDuplicates() {
		// create a copy and copy with only unique numbers
    	int copy[] = new int[die.length];
    	
    	// create helper variables to remove duplicates
    	int uniqueAmount = 0;
    	int indx = 1;
    	
    	for (int i = 0; i < die.length; i++) {
    		copy[i] = die[i];
    	}
    	
    	Arrays.sort(copy);
    	
    	// remove duplicates
    	for (int i = 0; i < copy.length - 1; i++) {
    		if (copy[i] != copy[i + 1]) {
    			uniqueAmount++;
    		}
    	}
    	
    	uniqueAmount++;
    	
    	unique = new int[uniqueAmount];
    	unique[0] = copy[0];
    	
    	for (int i = 1; i < copy.length; i++) {
    		if (copy[i] != copy[i - 1]) {
    			unique[indx] = copy[i];
    			indx++;
    		}
    	}
    	
    	return unique;
	}
	
	/* For a given hand calculate the lower score; if value is 1 score ones, etc. */
    public int getUpperScore(int value) {
    	// loop to find values that are equal to value
    	int score = 0;
    	for (int x: die) {
    		if (x == value) {
    			score += value;
    		}
    	}
        return score;
    }
    
    public int scoreThreeOfAKind() {
    	// create array to help find 3 of kind
    	int[] count = new int[7];
    	for (int x = 0; x < die.length; x++) {
    		count[die[x]]++;
    	}
    	
    	for (int i = 0; i < count.length; i++) {
    		if (count[i] >= 3) {
    			int sum = 0;
    			for (int j: die) {
    				sum += j;
    			}
    			return sum;
    		}
    	}
    	return 0;
    }

    public int scoreFourOfAKind() {
       	// create array to help find 4 of kind
    	int[] count = new int[7];
    	for (int x = 0; x < die.length; x++) {
    		count[die[x]]++;
    	}
    	
    	for (int i = 0; i < count.length; i++) {
    		if (count[i] >= 4) {
    			int sum = 0;
    			for (int j: die) {
    				sum += j;
    			}
    			return sum;
    		}
    	}
    	return 0;
    }

    public int scoreFullHouse() {
    	// declare variables to verify full house
    	boolean threeOfKind = false;
    	boolean twoOfKind = false;
    	
       	// create array to help find 3 of kind and 2 of a kind
    	int[] count = new int[7];
    	for (int x = 0; x < die.length; x++) {
    		count[die[x]]++;
    	}
    	
    	// check if there are three and two of kind
    	for (int i = 0; i < count.length; i++) {
    		if (count[i] == 3) {
    			threeOfKind = true;
    		}
    		else if(count[i] == 2) {
    			twoOfKind = true;
    		}
    	}
    	
    	if (twoOfKind && threeOfKind) {
    		return 25;
    	}
    	return 0;
    }

    public int scoreSmallStraight() {
    	// initialize helper variables
    	int amountInRow = 1;
    	for (int i = 0; i < unique.length - 1; i++) {
    		if (unique[i] == unique[i + 1] - 1) {
    			amountInRow++;
    		}
    		
    		else {
    			amountInRow = 1;
    		}
    	}
		if (amountInRow >= 4) {
			return 40;
		}
    	return 0;
    }

    
    public int scoreLargeStraight() {
    	// initialize helper variables
    	int amountInRow = 1;
    	for (int i = 0; i < unique.length - 1; i++) {
    		if (unique[i] == unique[i + 1] - 1) {
    			amountInRow++;
    		}
    		
    		else {
    			amountInRow = 1;
    		}
    	}
		if (amountInRow >= 5) {
			return 40;
		}
    	return 0;
    }

    public int scoreChance() {
    	int sum = 0;
		for (int x: die) {
			sum += x;
		}
    	return sum;
    }


    public int scoreYahtzee() {
    	// create array to help find 5 of kind
    	int[] count = new int[7];
    	for (int x = 0; x < die.length; x++) {
    		count[die[x]]++;
    	}
    	
    	for (int i = 0; i < count.length; i++) {
    		if (count[i] == 5) {
    			return 50;
    		}
    	}
    	return 0;
    }

    public int scoreBonusYahtzee() {
    	// create array to help find 5 of kind
    	int[] count = new int[7];
    	for (int x = 0; x < die.length; x++) {
    		count[die[x]]++;
    	}
    	
    	for (int i = 0; i < count.length; i++) {
    		if (count[i] == 5) {
    			return 50;
    		}
    	}
    	return 0;
    }
}
