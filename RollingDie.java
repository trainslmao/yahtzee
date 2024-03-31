/**
 * This class will be used to roll the die in one turn.
 * @author Bryan Zhang
 */
package yahtzeePT2;

import java.util.Scanner;
import java.util.ArrayList;

public class RollingDie {
	
	// attributes
	YahtzeeHand hand;
	
	// default constructor
	public RollingDie() {
		YahtzeeHand hand = new YahtzeeHand();
	}
	
	// method to play through one turn of rolling die
	public void turn() {
		// create objects
		hand = new YahtzeeHand();
		
		Scanner scanner = new Scanner(System.in);
		
		// create variables and arraylist
		boolean turn = true;
		int turnsLeft = 3;
		String inputNums;
		
		hand.rollAll();
		
		System.out.println(hand.showDice());
		
		// ask if they want to reroll and make sure valid answers
		while (turn) {
			System.out.println("Would you like to reroll any dice? y/n");
			char reroll = scanner.nextLine().charAt(0);
			
			if (reroll == 'y') {
				System.out.println("Which dice whould you like to keep? seperate by spaces");
				turnsLeft--;
				if (turnsLeft == 0) {
					turn = false;
				}
				inputNums = scanner.nextLine();
				
		        hand.changeHand(splitAndParse(inputNums));
		        System.out.println(hand.showDice());
			}
			
			else if (reroll == 'n') {
				turn = false;
			}
			else {
				System.err.println("invalid");
			}

		}
	}
	
	// method to split string and parse it to integer
	public ArrayList<Integer> splitAndParse(String input) {
		// declare variables and arraylist
		String stringNums;
		int num;
		ArrayList<Integer> numbers = new ArrayList<>();	
		int startOfNum = 0;
		
		 if (input.indexOf(' ') != -1) { // check if more than one word
		        startOfNum = 0;
		        for (int i = 0; i < input.length(); i++) {
		            if (input.charAt(i) == ' ') {
		                stringNums = input.substring(startOfNum, i); 
		                startOfNum = i + 1;
		                
		                num = Integer.parseInt(stringNums);
		                numbers.add(num);
		            }
		        }
		        
		        // last number
		        stringNums = input.substring(startOfNum);
                num = Integer.parseInt(stringNums);
                numbers.add(num);
		        
		    } else { // if it is one word, calculate its score
                num = Integer.parseInt(input);
                numbers.add(num);
		    }
		
		
		return numbers;
	}
	
	public YahtzeeHand getHand() {
		return hand;
	}
}
