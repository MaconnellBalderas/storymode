package storymode;

import storymode.shops.*;

public class GameLauncher {

    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();

        WeaponShop weaponShop = new WeaponShop();
        BlackSmith blackSmith = new BlackSmith();
        Church church = new Church();
        WizardCenter wizardCenter = new WizardCenter();
        ArmorShop armorShop = new ArmorShop();

        MainMenu menu = new MainMenu();

        PlayerInventory playerInventory = new PlayerInventory();

        displayWelcomeMessage();
        boolean inGame = true;
        while(inGame) {
            int option = menu.display();
            switch(option){
                case 1: System.out.println("You Have Entered The BlackSmith\n"); blackSmith.enter(); break;
                case 2: System.out.println("You Have Entered The Church\n"); church.enter(); break;
                case 3: System.out.println("You Have Entered The Wizard Center\n"); wizardCenter.enter(); break;
                case 4: System.out.println("You have Entered The Weapon Shop\n"); weaponShop.enter(weaponShop, playerInventory, menu, dungeon); break;
                case 5: System.out.println("You Have Entered The Armor Shop\n"); armorShop.enter(armorShop,playerInventory); break;
                case 6: System.out.println("You have entered the dungeon.\n"); dungeon.enter(playerInventory); break;
                case 7: System.out.println("Inventory:\n" + playerInventory.getGold() + " Gold Coins\n" + playerInventory.inventory(dungeon)); break;
                case 8: inGame = false;
            }

        }
        displayExitMessage();
}

    private static void displayWelcomeMessage() {
        System.out.println("StoryMode Town Defender!\n");
    }

    private static void displayExitMessage(){
        System.out.println("#######################");
        System.out.println("# Thanks For Playing! #");
        System.out.println("#######################");
    }
}
