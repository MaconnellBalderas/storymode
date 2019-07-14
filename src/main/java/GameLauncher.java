public class GameLauncher {

    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        WeaponShop weaponShop = new WeaponShop();
        MainMenu menu = new MainMenu();


        displayWelcomeMessage();
        boolean inGame = true;
        while(inGame) {
            int option = menu.display();
            switch(option){
                case 1: System.out.println("Blacksmith"); break;
                case 2: System.out.println("church"); break;
                case 3: System.out.println("Wizard"); break;
                case 4: System.out.println("You have entered the Weapon Shop"); weaponShop.enter(); break;
                case 5: System.out.println("armor"); break;
                case 6: System.out.println("You have entered the dungeon.\n"); dungeon.enter(); break;
                case 7: inGame=false;
            }


        }
        displayExitMessage();
}

    private static void displayWelcomeMessage() {
        System.out.println("Welcome To The Dungeon!");
        System.out.println("Type 'Controls' for more options");
        System.out.println("You enter out with your bare hands, Good Luck!\n");
    }

    private static void displayExitMessage(){
        System.out.println("#######################");
        System.out.println("# Thanks For Playing! #");
        System.out.println("#######################");
    }
}
