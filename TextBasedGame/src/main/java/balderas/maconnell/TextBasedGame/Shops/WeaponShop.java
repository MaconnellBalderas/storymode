 package balderas.maconnell.TextBasedGame.Shops;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Menus.WeaponMenu;
import balderas.maconnell.TextBasedGame.Menus.WeaponSell;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;

public class WeaponShop {
	
	WeaponMenu weaponMenu = new WeaponMenu();
	WeaponSell weaponSell = new WeaponSell();
	
	Scanner in = new Scanner(System.in);
	
	public void enter(PlayerInventory playerInventory) {
		display(playerInventory);
	}
	
	public int display(PlayerInventory playerInventory) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("You Have Entered The Weapon Shop. \n");
			System.out.println("Welcome To The Weapon Shop! How May I Serve You?");
			System.out.println("1. Buy Weapon");
			System.out.println("2. Sell Weapon");
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
			weaponMenu.display(playerInventory);
			isChoiceValid = true;
		} else {
			System.out.println("You Do Not Have Enough Gold");
		}
		if(input == 2 && playerInventory.getGold() > 0) {
			weaponSell.display(playerInventory);
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