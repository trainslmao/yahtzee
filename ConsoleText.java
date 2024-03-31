/**
 * This class will be used to play the game Yahtzee
 * @author Bryan Zhang
 */
package yahtzeePT2;

import java.util.ArrayList;
public class ConsoleText {
	public static void main(String[] args) {
		Scoring scoring = new Scoring();
		RollingDie turn = new RollingDie();
		YahtzeeHand hand = new YahtzeeHand();
		
		int game = 1;
		int TOTAL_GAMES = 3;
		
		// loop to play all games
		
		for (int j = 0; j < TOTAL_GAMES; j++) {
			
			// play one game
			for (int i = 0; i < 13; i++) {
				turn.turn();
				
				System.out.println();
				
				scoring.printScoreCard();
				
				System.out.println();
				
				scoring.scoreHand(turn.getHand(), game);
				
				scoring.printScoreCard();
			}
			
			// output results
			System.out.println("You finshed game " + game + " with " + scoring.getTotal() + " points");
		}
	}
}
