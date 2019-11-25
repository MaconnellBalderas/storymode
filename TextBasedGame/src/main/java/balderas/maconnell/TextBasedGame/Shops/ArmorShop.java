package balderas.maconnell.TextBasedGame.Shops;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Menus.ArmorMenu;
import balderas.maconnell.TextBasedGame.Menus.ArmorSell;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;

public class ArmorShop {
	
	ArmorMenu armorMenu = new ArmorMenu();
	ArmorSell armorSell = new ArmorSell();
	
	Scanner in = new Scanner(System.in);
	
	public void enter(PlayerInventory playerInventory) {
		display(playerInventory);
	}
	
	public int display(PlayerInventory playerInventory) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("You Have Entered The Armor Shop. \n");
			System.out.println("Welcome To The Armor Shop! How May I Serve You?");
			System.out.println("1. Buy Armor");
			System.out.println("2. Sell Armor");
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
		if(input == 1 && playerInventory.getGold() > 0) {
			armorMenu.display(playerInventory);
			isChoiceValid = true;
		} else {
			System.out.println("You Do Not Have Enough Gold");
		}
		if(input == 2 && playerInventory.getGold() > 0) {
			armorSell.display(playerInventory);
			isChoiceValid = true;
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