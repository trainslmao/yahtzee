/**
 * This class will output the score card and score a users hand based off their choice
 * @author Bryan Zhang
 */
package yahtzeePT2;

import java.util.Scanner;

public class Scoring implements YahtzeeScoreCard{
	// attributes
	int[] upperScores;
	int[] lowerScores;
	int upperTotal;
	int lowerTotal;
	boolean askForScoring;
	
	// default constructor
	public Scoring() {
		upperScores = new int[7];
		lowerScores = new int[8];
		askForScoring = true;
		for (int i = 0; i < lowerScores.length; i++) {
			if (i < 6) {
				upperScores[i] = -1;
			}
			lowerScores[i] = -1;
		}
		
	}
	
	// score the hand
	@Override
	public void scoreHand(YahtzeeHand hand, int game) {
		// create object
		Scanner scanner = new Scanner(System.in);
		YahtzeeScore scoring = new YahtzeeScore(hand.getDice());
		
		// set ask for scoring to true
		boolean askForScoring = true;

		// ask for their choice until they give a valid one
		while (askForScoring) {
			System.out.println("Which scoring method would you like to use? (use 1, 2, 3, etc)");
			int choice = scanner.nextInt();
			
			// switch for each case they give
			switch (choice) {
			
			case 1:
				if (validScoring(choice)) {
					askForScoring = false;
					upperScores[0] = scoring.getUpperScore(1);
					upperTotal += upperScores[choice - 1];
					if (upperTotal >= 63 && upperScores[6] != 35) {
						upperScores[6] = 35;
					}
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			case 2:
				if (validScoring(choice)) {
					askForScoring = false;
					upperScores[1] = scoring.getUpperScore(2);
					upperTotal += upperScores[choice - 1];
					if (upperTotal >= 63 && upperScores[6] != 35) {
						upperScores[6] = 35;
					}
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			case 3:
				if (validScoring(choice)) {
					askForScoring = false;
					upperScores[2] = scoring.getUpperScore(3);
					upperTotal += upperScores[choice - 1];
					if (upperTotal >= 63 && upperScores[6] != 35) {
						upperScores[6] = 35;
					}
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			case 4:
				if (validScoring(choice)) {
					askForScoring = false;
					upperScores[3] = scoring.getUpperScore(4);
					upperTotal += upperScores[choice - 1];
					if (upperTotal >= 63 && upperScores[6] != 35) {
						upperScores[6] = 35;
					}
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			case 5:
				if (validScoring(choice)) {
					askForScoring = false;
					upperScores[4] = scoring.getUpperScore(5);
					upperTotal += upperScores[choice - 1];
					if (upperTotal >= 63 && upperScores[6] != 35) {
						upperScores[6] = 35;
					}
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			case 6:
				if (validScoring(choice)) {
					askForScoring = false;
					upperScores[5] = scoring.getUpperScore(6);
					upperTotal += upperScores[choice - 1];
					if (upperTotal >= 63 && upperScores[6] != 35) {
						upperScores[6] = 35;
					}
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			// score 3 of kind
			case 7:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[0] = scoring.scoreThreeOfAKind();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					System.err.println("invalid choice");
				}
				break;
			
			// score four of kind
			case 8:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[1] = scoring.scoreFourOfAKind();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			// score full house
			case 9:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[2] = scoring.scoreFullHouse();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			// small straight
			case 10:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[3] = scoring.scoreSmallStraight();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			// score large straight
			case 11:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[4] = scoring.scoreLargeStraight();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					System.err.println("invalid choice");
				}
				break;
				
			// score Chance
			case 12:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[5] = scoring.scoreChance();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					System.err.println("invalid choice");
				}
				break;
			
			// score yahtzee
			case 13:
				if (validScoring(choice)) {
					askForScoring = false;
					lowerScores[6] = scoring.scoreYahtzee();
					lowerTotal += lowerScores[choice - 7];
				}
				else {
					lowerScores[7] = scoring.scoreBonusYahtzee();
				}
				break;
				
			default:
				System.err.println("invalid choice");
			}
		}
	}
	
	// method to make sure that score method is still usable
	public boolean validScoring(int choice) {
		if (choice < 7) {
			if (upperScores[choice - 1] == -1) {
				return true;
			}
		}
		
		else {
			if (lowerScores[choice - 7] == -1) {
				return true;
			}
		}
		return false;
	}
		
	
	public void printScoreCard() {
		// upper
		System.out.println("-- Upper Section --");
		System.out.println("1.  1s" + (upperScores[0] != -1 ? "  " + upperScores[0] : ""));
	    System.out.println("2.  2s" + (upperScores[1] != -1 ? "  " + upperScores[1] : ""));
	    System.out.println("3.  3s" + (upperScores[2] != -1 ? "  " + upperScores[2] : ""));
	    System.out.println("4.  4s" + (upperScores[3] != -1 ? "  " + upperScores[3] : ""));
	    System.out.println("5.  5s" + (upperScores[4] != -1 ? "  " + upperScores[4] : ""));
	    System.out.println("6.  6s" + (upperScores[5] != -1 ? "  " + upperScores[5] : ""));
	    System.out.println("Upper Total   " + upperTotal);
	    System.out.println("Upper Bonus   " + upperScores[6]);
	    // lower
	    System.out.println("-- Lower Section --");
	    System.out.println("7.  Three of a Kind" + (lowerScores[0] != -1 ? "  " + lowerScores[0] : ""));
	    System.out.println("8.  Four of a Kind " + (lowerScores[1] != -1 ? "  " + lowerScores[1] : ""));
	    System.out.println("9.  Full House     " + (lowerScores[2] != -1 ? "  " + lowerScores[2] : ""));
	    System.out.println("10. Small Straight " + (lowerScores[3] != -1 ? "  " + lowerScores[3] : ""));
	    System.out.println("11. Large Straight " + (lowerScores[4] != -1 ? "  " + lowerScores[4] : ""));
	    System.out.println("12. Chance         " + (lowerScores[5] != -1 ? "  " + lowerScores[5] : ""));
	    System.out.println("13. Yahtzee        " + (lowerScores[6] != -1 ? "  " + lowerScores[6] : ""));
	    System.out.println("    Yahtzee Bonus  " + (lowerScores[7] != -1 ? "  " + lowerScores[7] : ""));
	    
	    System.out.println("Lower Total   " + lowerTotal);
	    
	    System.out.println("Total         " + (lowerTotal + upperTotal));
	}
	
	// getters
	public int[] getUpperScores() {
		return upperScores;
	}
	
	public int getUpperInt(int indx) {
		return upperScores[indx];
	}
	
	public int[] getLowerScores() {
		return lowerScores;
	}
	
	public int getLowerInt(int indx) {
		return lowerScores[indx];
	}
	
	public int getTotal() {
		return lowerTotal + upperTotal;
	}
	
	// setters
	public void setUpperInt(int value, int indx) {
		upperScores[indx] = value;
	}
	
	public void setLowerInt(int value, int indx) {
		lowerScores[indx] = value;
	}
}
