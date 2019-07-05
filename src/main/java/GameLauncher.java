import monsters.*;

import java.util.Random;
import java.util.Scanner;

public class GameLauncher {



    public static void main(String[] args) {
        Battle battle = new Battle();

        displayWelcomeMessage();
        boolean inDungeon = true;
        while(inDungeon) {
            battle.start();
            inDungeon = battle.doesPlayerWantToStay();
        }
        displayExitMessage();
}

    private static void displayWelcomeMessage() {
        System.out.println("Welcome To The Dungeon!");
        System.out.println("Type 'Controls' for more options");
        System.out.println("You start out with your bare hands, Good Luck!\n");
    }

    private static void displayExitMessage(){
        System.out.println("#######################");
        System.out.println("# Thanks For Playing! #");
        System.out.println("#######################");
    }
}
