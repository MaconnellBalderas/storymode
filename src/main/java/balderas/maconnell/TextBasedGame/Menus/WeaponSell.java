package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;

public class WeaponSell {
	Scanner in = new Scanner(System.in);
	
	public String display(PlayerInventory inventory) {
		String input = "";
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Weapon Would You Like To Sell?");

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
		
		if(input.equals("Axe")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("Axe");
			isChoiceValid = true;
		}
		if(input.equals("Sword")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("Sword");
			isChoiceValid = true;
		}
		if(input.equals("Spear")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("Spear");
			isChoiceValid = true;
		}
		if(input.equals("Bow")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("Bow");
			isChoiceValid = true;
		}
		return input;
	}

	private boolean validateChoice(String input) {
		if(input.equals("Axe")) {
			return true;
		} else if(input.equals("Sword")) {
			return true;
		} else if(input.equals("Spear")) {
			return true;
		} else if(input.equals("Bow")) {
			return true;
		}
		return false;
	}
	
}
