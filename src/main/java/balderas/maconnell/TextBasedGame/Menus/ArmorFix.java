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
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;

public class ArmorFix {

	public static final String INVALID_COMMAND = "Invalid Command!";
	public static final String ARMORFIX_LINE_1 = "What Weapon Would You Like To Fix?";
	public static final String MENUBAR = "--------------------------------------------------------";
	Input scanner;
	Display display;
	MainMenu mainMenu;

	public ArmorFix(Display display, Input scanner, MainMenu mainMenu){
		this.scanner = scanner;
		this.display = display;
		this.mainMenu = mainMenu;
	}

	public ArmorFix(){
		this(new Display(), new Input(), new MainMenu());
	}
	
	public String display(PlayerInventory inventory, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots) {
		String input = "";
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			displayMenu(inventory);
			input = captureInput();
			isChoiceValid = validateChoice(input);
		}
		processOptions(input, inventory, helmet, chestplate, leggings, boots);
		return input;
	}

	protected String captureInput(){
		String input = "";
		try {
			input = scanner.nextLine();
		} catch (InputMismatchException e) {
			display.println(INVALID_COMMAND);
		}

		return input;
	}

	protected void displayMenu(PlayerInventory inventory){
		display.println(MENUBAR);
		display.println(ARMORFIX_LINE_1);
//		for (String item : inventory.getInventory()) {
//			display.println(item);
//		}
		inventory.getInventory();
	}
	
	protected boolean validateChoice(String input) {
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

	protected void processOptions(String input, PlayerInventory inventory, Helmet helmet, ChestPlate chestplate, Leggings leggings, Boots boots){
		if(input.equals("Helmet")) {
			inventory.setGold(inventory.getGold() - 10);
			helmet.setDurability(helmet.getDurability() + 5);
		}
		if(input.equals("Chestplate")) {
			inventory.setGold(inventory.getGold() - 10);
			chestplate.setDurability(chestplate.getDurability() + 5);
		}
		if(input.equals("Leggings")) {
			inventory.setGold(inventory.getGold() - 10);
			leggings.setDurability(leggings.getDurability() + 5);
		}
		if(input.equals("Boots")) {
			inventory.setGold(inventory.getGold() - 10);
			boots.setDurability(boots.getDurability() + 5);
		}
	}

}
