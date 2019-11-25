package balderas.maconnell.TextBasedGame.Shops;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Menus.UpgradeStats;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;

public class Church {
	
	Scanner in = new Scanner(System.in);
	
	UpgradeStats upgradeStats = new UpgradeStats();
	
	public void enter(PlayerStats stats) {
		display(stats);
	}
	
	public int display(PlayerStats stats) {
		int input = 0;
		int health = 100;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("You Have Entered The Church. \n");
			System.out.println("Welcome To The Church! How May I Serve You?");
			System.out.println("1. Heal Player");
			System.out.println("2. Upgrade Stats");
			System.out.println("3. Leave");
			
			try {
				input = in.nextInt();
				isChoiceValid = validateChoice(input);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Command!");
			} finally {
				in.nextLine();
			}
		}
		if(input == 1) {
			stats.setHealth(health);
		}
		if(input == 2) {
			upgradeStats.display(stats);
		}
		if(input == 3) {
			isChoiceValid = true;
		}
		return input;
	}
	
	private boolean validateChoice(int input) {
		return (input >= 1 && input <= 3);
	}

}
