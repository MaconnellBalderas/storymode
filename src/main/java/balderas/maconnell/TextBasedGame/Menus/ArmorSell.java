package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;

public class ArmorSell {
	Scanner in = new Scanner(System.in);
	
	public String display(PlayerInventory inventory) {
		String input = "";
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Armor Would You Like To Sell?");

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
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("Helmet");
			isChoiceValid = true;
		}
		if(input.equals("ChestPlate")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("ChestPlate");
			isChoiceValid = true;
		}
		if(input.equals("Leggings")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("leggings");
			isChoiceValid = true;
		}
		if(input.equals("Boots")) {
			inventory.setGold(inventory.getGold() + 10);
			inventory.removeItem("Boots");
			isChoiceValid = true;
		}
		return input;
	}

	private boolean validateChoice(String input) {
		if(input.equals("Helmet")) {
			return true;
		} else if(input.equals("ChestPlate")) {
			return true;
		} else if(input.equals("Leggings")) {
			return true;
		} else if(input.equals("Boots")) {
			return true;
		}
		return false;
	}
}
