package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;

public class ArmorUpgrade {
	
Scanner in = new Scanner(System.in);
	
	public String display(PlayerInventory inventory, PlayerStats stats) {
		String input = "";
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Weapon Would You Like To Upgrade?");
			for (String item : inventory.getInventory()) {
				System.out.println(item);
			}
			
			try {
				input = in.nextLine();
				isChoiceValid = validateChoice(input);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Command!");
			}
		}
		
		if(input.equals("Helmet")) {
			inventory.setGold(inventory.getGold() - 10);
			stats.setHealth(stats.getHealth() + 10);
			isChoiceValid = true;
		}
		if(input.equals("Chestplate")) {
			inventory.setGold(inventory.getGold() - 10);
			stats.setHealth(stats.getHealth() + 10);
			isChoiceValid = true;
		}
		if(input.equals("Leggings")) {
			inventory.setGold(inventory.getGold() - 10);
			stats.setHealth(stats.getHealth() + 10);
			isChoiceValid = true;
		}
		if(input.equals("Boots")) {
			inventory.setGold(inventory.getGold() - 10);
			stats.setHealth(stats.getHealth() + 10);
			isChoiceValid = true;
		}
		return input;
	}
	
	private boolean validateChoice(String input) {
		if(input.equals("Helmet")) {
			return true;
		} else if(input.equals("Chestplate")) {
			return true;
		} else if(input.equals("Leggings")) {
			return true;
		} else if(input.equals("Boots")) {
			return true;
		}
		return false;
	}


}
