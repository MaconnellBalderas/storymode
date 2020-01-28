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
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;

public class BlackSmith {

	public static final String MenunBar = "--------------------------------------------------------";
	public static final String BLACKSMITH_LINE_1 = "You Have Entered The BlackSmith. ";
	public static final String BLACKSMITH_LINE_2 = "Welcome To The BlackSmith! How May I Serve You?";
	public static final String BLACKSMITH_LINE_3 = "1. Upgrade Weapon";
	public static final String BLACKSMITH_LINE_4 = "2. Fix Weapon";
	public static final String BLACKSMITH_LINE_5 = "3. Upgrade Armor";
	public static final String BLACKSMITH_LINE_6 = "4. Fix Armor";
	public static final String BLACKSMITH_LINE_7 = "5. Leave";
	public static final String INVALID_COMMAND = "Invalid Command!";
	public static final String NOT_ENOUGH_GOLD = "You Do Not Have Enough Gold";
	Input scanner;
	Display display;

	WeaponUpgrade weaponUpgrade;
	WeaponFix weaponFix;
	ArmorUpgrade armorUpgrade;
	ArmorFix armorFix;

	public BlackSmith(Input scanner, Display display, WeaponUpgrade weaponUpgrade, WeaponFix weaponFix, ArmorUpgrade armorUpgrade, ArmorFix armorFix){
		this.scanner = scanner;
		this.display = display;
		this.weaponUpgrade = weaponUpgrade;
		this.weaponFix = weaponFix;
		this.armorUpgrade = armorUpgrade;
		this.armorFix = armorFix;
	}

	public BlackSmith(){
		this(new Input(), new Display(), new WeaponUpgrade(), new WeaponFix(), new ArmorUpgrade(), new ArmorFix());
	}
	
	public void enter(PlayerInventory inventory, Axe axe, Spear spear, Bow bow, Sword sword, PlayerStats stats, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots) {
		display(inventory, axe, spear, bow, sword, stats, helmet, chestplate, leggings, boots);
	}
	
	public int display(PlayerInventory inventory, Axe axe, Spear spear, Bow bow, Sword sword, PlayerStats stats, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			displayMenu();
			input = captureInput();
			isChoiceValid = validateChoice(input);
		}
		processOptions(input, inventory, axe, spear, bow, sword, stats, helmet, chestplate, leggings, boots);
		return input;
	}

	protected int captureInput(){
		int input = 0;
		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			display.println(INVALID_COMMAND);
		} finally {
			scanner.nextLine();
		}
		return input;
	}
	
	protected boolean validateChoice(int input) {
		return (input >= 1 && input <= 5);
	}

	protected void displayMenu(){
		display.println(MenunBar);
		display.println(BLACKSMITH_LINE_1);
		display.println(BLACKSMITH_LINE_2);
		display.println(BLACKSMITH_LINE_3);
		display.println(BLACKSMITH_LINE_4);
		display.println(BLACKSMITH_LINE_5);
		display.println(BLACKSMITH_LINE_6);
		display.println(BLACKSMITH_LINE_7);
	}

	protected void processOptions(int input, PlayerInventory inventory, Axe axe, Spear spear, Bow bow, Sword sword, PlayerStats stats, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots){
		if(input == 1){
			if(inventory.getGold() > 0) {
				weaponUpgrade.display(inventory, axe, bow, spear, sword);
			} else {
				display.println(NOT_ENOUGH_GOLD);
			}
		} else if(input == 2){
			if(inventory.getGold() > 0) {
				weaponFix.display(inventory, axe, bow, spear, sword);
			}
		} else if(input == 3){
			if(inventory.getGold() > 0) {
				armorUpgrade.display(inventory, stats);
			}
		} else if(input == 4){
			if(inventory.getGold() > 0) {
				armorFix.display(inventory, helmet, chestplate, leggings, boots);

			}
		}
	}

}