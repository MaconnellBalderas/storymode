package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;

public class UpgradeStats {
	
Scanner in = new Scanner(System.in);
	
	public int display(PlayerStats stats) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Stat Would You Like To Update?");
			System.out.println("1. Health");
			System.out.println("2. Damage");
			
			try {
				input = in.nextInt();
				isChoiceValid = validateChoice(input);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Command!");
			}
		}
		if(input == 1) {
			stats.setHealth(stats.getHealth() + 5);
			isChoiceValid = true;
		}
		if(input == 2) {
			stats.setAttackDamage(stats.getAttackDamge() + 5);
		}
		
		return input;
	}
	
	private boolean validateChoice(int input) {
		return (input >= 1 && input <= 4);
	}

}
