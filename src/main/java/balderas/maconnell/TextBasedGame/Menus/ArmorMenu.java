package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;

public class ArmorMenu {
	Scanner in = new Scanner(System.in);
	
	public int display(PlayerInventory inventory) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("What Armor Piece Would You Like To Buy?");
			System.out.println("1. Helmet");
			System.out.println("2. ChestPlate");
			System.out.println("3. Leggings");
			System.out.println("4. Boots");
			
			try {
				input = in.nextInt();
				isChoiceValid = validateChoice(input);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Command!");
			} finally {
				in.nextLine();
			}
		}
		if(input >= 1 && input <= 4) {
			inventory.setGold(inventory.getGold() - 10);
			inventory.addItem(decideWeapon(input));
			isChoiceValid = true;
		}
		return input;
	}
	
	private boolean validateChoice(int input) {
		return (input >= 1 && input <= 4);
	}
	
	private String decideWeapon(int input) {
		String weapon = "";
		if(input == 1) {
			weapon = "Helmet";
		} else if(input == 2) {
			weapon = "ChestPlate";
		} else if(input == 3) {
			weapon = "Leggings";
		} else if(input == 4) {
			weapon = "Boots";
		}
		return weapon;
	}
}
