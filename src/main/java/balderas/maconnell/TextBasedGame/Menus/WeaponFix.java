package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.Tools.Axe;
import balderas.maconnell.TextBasedGame.Tools.Bow;
import balderas.maconnell.TextBasedGame.Tools.Spear;
import balderas.maconnell.TextBasedGame.Tools.Sword;

public class WeaponFix {

Scanner in = new Scanner(System.in);
	
	public String display(PlayerInventory inventory, Axe axe, Bow bow, Spear spear, Sword sword) {
		String input = "";
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Weapon Would You Like To Fix?");
//			for (String item : inventory.getInventory()) {
//				System.out.println(item);
//			}
			inventory.getInventory();
			
			try {
				input = in.nextLine();
				isChoiceValid = validateChoice(input);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Command!");
			}
		}
		
		if(input.equals("Axe")) {
			inventory.setGold(inventory.getGold() - 10);
			axe.setDurability(axe.getDurability() + 5);
			isChoiceValid = true;
		}
		if(input.equals("Sword")) {
			inventory.setGold(inventory.getGold() - 10);
			sword.setDurability(sword.getDurability() + 5);
			isChoiceValid = true;
		}
		if(input.equals("Spear")) {
			inventory.setGold(inventory.getGold() - 10);
			spear.setDurability(spear.getDurability() + 5);
			isChoiceValid = true;
		}
		if(input.equals("Bow")) {
			inventory.setGold(inventory.getGold() - 10);
			bow.setDurability(bow.getDurability() + 5);
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
