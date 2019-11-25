package balderas.maconnell.TextBasedGame;

import balderas.maconnell.TextBasedGame.Menus.MainMenu;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerInventory;
import balderas.maconnell.TextBasedGame.PlayerDetail.PlayerStats;
import balderas.maconnell.TextBasedGame.Shops.ArmorShop;
import balderas.maconnell.TextBasedGame.Shops.BlackSmith;
import balderas.maconnell.TextBasedGame.Shops.Church;
import balderas.maconnell.TextBasedGame.Shops.WeaponShop;
import balderas.maconnell.TextBasedGame.Tools.Axe;
import balderas.maconnell.TextBasedGame.Tools.Boots;
import balderas.maconnell.TextBasedGame.Tools.Bow;
import balderas.maconnell.TextBasedGame.Tools.ChestPlate;
import balderas.maconnell.TextBasedGame.Tools.Helmet;
import balderas.maconnell.TextBasedGame.Tools.Leggings;
import balderas.maconnell.TextBasedGame.Tools.Spear;
import balderas.maconnell.TextBasedGame.Tools.Sword;

public class GameLauncher {
	
	public static void main(String[] args) {
		MainMenu menu = new MainMenu();
		
		Dungeon dungeon = new Dungeon();
		Church church = new Church();
		BlackSmith blackSmith = new BlackSmith();
		WeaponShop weaponShop = new WeaponShop();
		ArmorShop armorShop = new ArmorShop();
		
		PlayerInventory playerInventory = new PlayerInventory();
        PlayerStats stats = new PlayerStats();
        
        Axe axe = new Axe();
        Spear spear = new Spear();
        Sword sword = new Sword();
        Bow bow = new Bow();
        
        Helmet helmet = new Helmet();
        ChestPlate chestplate = new ChestPlate();
        Leggings leggings = new Leggings();
        Boots boots = new Boots();
		
		displayWelcomeMessage();
		boolean inGame = true;
		while(inGame) {
			int option = menu.Display();
			switch(option) {
				case 1: System.out.println("You Have Entered The Dungeon.\n"); dungeon.enter(playerInventory, stats, axe, spear, sword, bow); break;
				case 2: church.enter(stats); break;
				case 3: blackSmith.enter(playerInventory, axe, spear, bow , sword, stats, helmet, chestplate, leggings, boots); break;
				case 4: weaponShop.enter(playerInventory); break;
				case 5: armorShop.enter(playerInventory); break;
				case 6: playerInventory.display(); break;
				case 7: inGame = false;
			}
		}
		displayExitMessage();
	}
	
	private static void displayWelcomeMessage() {
		System.out.println("StoryMode Town Defender!\n");
	}
	private static void displayExitMessage() {
		System.out.println("#######################");
        System.out.println("# Thanks For Playing! #");
        System.out.println("#######################");
	}
	

}
