 package balderas.maconnell.TextBasedGame.Shops;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Menus.MainMenu;
import balderas.maconnell.TextBasedGame.Menus.WeaponMenu;
import balderas.maconnell.TextBasedGame.Menus.WeaponSell;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.Tools.Weapon;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;

 public class WeaponShop {

	 public static final String MENUBAR = "--------------------------------------------------------";
	 public static final String WEAPON_SHOP_LINE_1 = "You Have Entered The Weapon Shop. ";
	 public static final String WEAPON_SHOP_LINE_2 = "Welcome To The Weapon Shop! How May I Serve You?";
	 public static final String WEAPON_SHOP_LINE_3 = "1. Buy Weapon";
	 public static final String WEAPON_SHOP_LINE_4 = "2. Sell Weapon";
	 public static final String WEAPON_SHOP_LINE_5 = "3. Leave";
	 public static final String NOT_ENOUGH_GOLD = "You Do Not Have Enough Gold";
	 public static final String INVALID_COMMAND = "Invalid Command!";
	 WeaponMenu weaponMenu;
	 WeaponSell weaponSell;
	 MainMenu mainMenu;
	
	Input scanner;
	Display display;

	public WeaponShop(Display display, Input scanner, WeaponMenu weaponMenu, WeaponSell weaponSell, MainMenu mainMenu){
		this.display = display;
		this.scanner = scanner;
		this.weaponMenu = weaponMenu;
		this.weaponSell = weaponSell;
		this.mainMenu = mainMenu;
	}

	public WeaponShop(){
		this(new Display(), new Input(), new WeaponMenu(), new WeaponSell(), new MainMenu());
	}
	
	public void enter(PlayerInventory playerInventory) {
		display(playerInventory);
	}
	
	public int display(PlayerInventory playerInventory) {
		int input = 0;
		boolean isChoiceValid = false;

		while (!isChoiceValid) {
			displayMenu();
			input = captureInput();
			isChoiceValid = validateChoice(input);
		}
		processOptions(playerInventory, input);
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
		return (input >= 1 && input <= 3);
	}

	protected void displayMenu(){
		display.println(MENUBAR);
		display.println(WEAPON_SHOP_LINE_1);
		display.println(WEAPON_SHOP_LINE_2);
		display.println(WEAPON_SHOP_LINE_3);
		display.println(WEAPON_SHOP_LINE_4);
		display.println(WEAPON_SHOP_LINE_5);
	}

	protected void processOptions(PlayerInventory playerInventory, int input){
		if(input == 1){
			if(playerInventory.getGold() > 0) {
				weaponMenu.display(playerInventory);
			} else {
				display.println(NOT_ENOUGH_GOLD);
			}
		} else if(input == 2){
			weaponSell.display(playerInventory);
		}
	}
}