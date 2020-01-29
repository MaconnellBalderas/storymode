package balderas.maconnell.TextBasedGame.Menus;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;

public class ArmorMenu {
	public static final String MENUBAR = "--------------------------------------------------------";
	public static final String ARMOR_MENU_LINE_1 = "What Armor Piece Would You Like To Buy?";
	public static final String ARMOR_MENU_LINE_2 = "1. Helmet";
	public static final String ARMOR_MENU_LINE_3 = "2. ChestPlate";
	public static final String ARMOR_MENU_LINE_4 = "3. Leggings";
	public static final String ARMOR_MENU_LINE_5 = "4. Boots";
	public static final String INVALID_COMMAND = "Invalid Command!";
	Input scanner;
	Display display;
	MainMenu mainMenu;

	public ArmorMenu(Display display, Input scanner, MainMenu mainMenu){
		this.scanner = scanner;
		this.display = display;
		this.mainMenu = mainMenu;
	}

	public ArmorMenu(){
		this(new Display(), new Input(), new MainMenu());
	}
	
	public int display(PlayerInventory inventory) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			displayMenu();
			input = captureInput();
			isChoiceValid = validateChoice(input);
		}
		processOptions(input, inventory);
		return input;
	}

	protected void processOptions(int input, PlayerInventory inventory){
		if(input >= 1 && input <= 4) {
			inventory.setGold(inventory.getGold() - 10);
			inventory.addItem(decideWeapon(input));
		}
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

	protected void displayMenu(){
		display.println(MENUBAR);
		display.println(ARMOR_MENU_LINE_1);
		display.println(ARMOR_MENU_LINE_2);
		display.println(ARMOR_MENU_LINE_3);
		display.println(ARMOR_MENU_LINE_4);
		display.println(ARMOR_MENU_LINE_5);
	}
	
	protected boolean validateChoice(int input) {
		return (input >= 1 && input <= 4);
	}
	
	protected String decideWeapon(int input) {
		String weapon = "";
		if(input == 1) {
			weapon = "Helmet";
		} else if(input == 2) {
			weapon = "Chestplate";
		} else if(input == 3) {
			weapon = "Leggings";
		} else if(input == 4) {
			weapon = "Boots";
		}
		return weapon;
	}
}
