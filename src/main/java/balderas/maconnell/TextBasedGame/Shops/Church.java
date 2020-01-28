package balderas.maconnell.TextBasedGame.Shops;

import java.util.InputMismatchException;
import java.util.Scanner;

import balderas.maconnell.TextBasedGame.Menus.UpgradeStats;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;
import balderas.maconnell.TextBasedGame.io.Display;
import balderas.maconnell.TextBasedGame.io.Input;

public class Church {

	public static final String MenuBar = "--------------------------------------------------------";
	public static final String CHURCH_SHOP_LINE_1 = "You Have Entered The Church. ";
	public static final String CHURCH_SHOP_LINE_2 = "Welcome To The Church! How May I Serve You?";
	public static final String CHURCH_SHOP_LINE_3 = "1. Heal Player";
	public static final String CHURCH_SHOP_LINE_4 = "2. Upgrade Stats";
	public static final String CHURCH_SHOP_LINE_5 = "3. Leave";
	public static final String INVALID_COMMAND = "Invalid Command!";
	Input scanner;
	Display display;
	
	UpgradeStats upgradeStats;
	PlayerStats playerStats;

	public Church(Display display, Input scanner, UpgradeStats upgradeStats, PlayerStats playerStats){
		this.scanner = scanner;
		this.display = display;
		this.upgradeStats = upgradeStats;
		this.playerStats = playerStats;
	}

	public Church(){
		this( new Display(), new Input(), new UpgradeStats(), new PlayerStats());
	}
	
	public void enter(PlayerStats stats) {
		display(stats);
	}
	
	public int display(PlayerStats stats) {
		int input = 0;
		boolean isChoiceValid = false;
		
		while (!isChoiceValid) {
			displayMenu();
			input = captureInput();
			isChoiceValid = validateChoice(input);
		}
		processOptions(stats, input);
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
		display.println(MenuBar);
		display.println(CHURCH_SHOP_LINE_1);
		display.println(CHURCH_SHOP_LINE_2);
		display.println(CHURCH_SHOP_LINE_3);
		display.println(CHURCH_SHOP_LINE_4);
		display.println(CHURCH_SHOP_LINE_5);
	}

	protected void processOptions(PlayerStats stats, int input){
		int health = 100;
		if(input == 1) {
			stats.setHealth(health);
		}else if(input == 2) {
			upgradeStats.display(stats);
		}
	}

}
