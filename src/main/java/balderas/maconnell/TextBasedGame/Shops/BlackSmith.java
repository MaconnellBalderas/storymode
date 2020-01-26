package balderas.maconnell.TextBasedGame.Shops;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Menus.ArmorFix;
import balderas.maconnell.TextBasedGame.Menus.ArmorUpgrade;
import balderas.maconnell.TextBasedGame.Menus.WeaponFix;
import balderas.maconnell.TextBasedGame.Menus.WeaponUpgrade;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;
import balderas.maconnell.TextBasedGame.Tools.Axe;
import balderas.maconnell.TextBasedGame.Tools.Boots;
import balderas.maconnell.TextBasedGame.Tools.Bow;
import balderas.maconnell.TextBasedGame.Tools.ChestPlate;
import balderas.maconnell.TextBasedGame.Tools.Helmet;
import balderas.maconnell.TextBasedGame.Tools.Leggings;
import balderas.maconnell.TextBasedGame.Tools.Spear;
import balderas.maconnell.TextBasedGame.Tools.Sword;

public class BlackSmith {
	
	Scanner in = new Scanner(System.in);
	WeaponUpgrade weaponUpgrade = new WeaponUpgrade();
	WeaponFix weaponFix = new WeaponFix();
	ArmorUpgrade armorUpgrade = new ArmorUpgrade();
	ArmorFix armorFix = new ArmorFix();
	
	public void enter(PlayerInventory inventory, Axe axe, Spear spear, Bow bow, Sword sword, PlayerStats stats, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots) {
		display(inventory, axe, spear, bow, sword, stats, helmet, chestplate, leggings, boots);
	}
	
	public int display(PlayerInventory inventory, Axe axe, Spear spear, Bow bow, Sword sword, PlayerStats stats, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			System.out.println("--------------------------------------------------------");
			System.out.println("You Have Entered The BlackSmith. \n");
			System.out.println("Welcome To The BlackSmith! How May I Serve You?");
			System.out.println("1. Upgrade Weapon");
			System.out.println("2. Fix Weapon");
			System.out.println("3. Upgrade Armor");
			System.out.println("4. Fix Armor");
			System.out.println("5. Leave");
			
			//add a if money > 10 buy else "not enough money"
			
			try {
				input = in.nextInt();
				isChoiceValid = validateChoice(input);
			} catch (InputMismatchException e) {
				System.out.println("Invalid Command!");
			} finally {
				in.nextLine();
			}
		}
		if(input == 1 && inventory.getGold() > 0) {
			weaponUpgrade.display(inventory, axe, bow, spear, sword);
			isChoiceValid = true;
		} else {
			System.out.println("You Do Not Have Enough Gold");
		}
		if(input == 2 && inventory.getGold() > 0) {
			weaponFix.display(inventory, axe, bow, spear, sword);
			isChoiceValid = true;
		} 
		if(input == 3 && inventory.getGold() > 0) {
			armorUpgrade.display(inventory, stats);
			isChoiceValid = true;
		} 
		if(input == 4 && inventory.getGold() > 0) {
			armorFix.display(inventory, helmet, chestplate, leggings, boots);
			isChoiceValid = true;
		} 
		if(input == 5) {
			isChoiceValid = true;
		}
		return input;
	}
	
	private boolean validateChoice(int input) {
		return (input >= 1 && input <= 5);
	}

}