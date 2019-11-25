package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.Tools.Axe;
import balderas.maconnell.TextBasedGame.Tools.Boots;
import balderas.maconnell.TextBasedGame.Tools.Bow;
import balderas.maconnell.TextBasedGame.Tools.ChestPlate;
import balderas.maconnell.TextBasedGame.Tools.Helmet;
import balderas.maconnell.TextBasedGame.Tools.Leggings;
import balderas.maconnell.TextBasedGame.Tools.Spear;
import balderas.maconnell.TextBasedGame.Tools.Sword;

public class ArmorFix {
	
Scanner in = new Scanner(System.in);
	
	public String display(PlayerInventory inventory, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots) {
		String input = "";
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Weapon Would You Like To Fix?");
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
			helmet.setDurability(helmet.getDurability() + 5);
			isChoiceValid = true;
		}
		if(input.equals("Chestplate")) {
			inventory.setGold(inventory.getGold() - 10);
			chestplate.setDurability(chestplate.getDurability() + 5);
			isChoiceValid = true;
		}
		if(input.equals("Leggings")) {
			inventory.setGold(inventory.getGold() - 10);
			leggings.setDurability(leggings.getDurability() + 5);
			isChoiceValid = true;
		}
		if(input.equals("Boots")) {
			inventory.setGold(inventory.getGold() - 10);
			boots.setDurability(boots.getDurability() + 5);
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
