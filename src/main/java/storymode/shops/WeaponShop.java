package storymode.shops;

import storymode.Dungeon;
import storymode.MainMenu;
import storymode.PlayerInventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeaponShop {
    Scanner in = new Scanner(System.in);

    public void enter(WeaponShop weaponShop, PlayerInventory playerInventory, MainMenu menu, Dungeon dungeon) {
        //Buy Weapon
        //Sell Weapon
        int weaponStore = weaponShop.display(playerInventory, menu, dungeon);
        switch(weaponStore){
            case 1: playerInventory.setGold(playerInventory.getGold() - 5); break;
            case 2: System.out.println("You Have Sold A Weapon\n"); playerInventory.setGold(playerInventory.getGold() + 5); System.out.println("Thank You Traveler!\n"); break;
        }
        display(playerInventory, menu, dungeon);
}

    public int display(PlayerInventory playerInventory, MainMenu menu, Dungeon dungeon) {
        int input = 0;
        boolean isChoiceValid = false;

        while (!isChoiceValid) {
            System.out.println("Welcome To The Weapon Shop! What Can I do For You?");
            System.out.println("1. Buy Weapon");
            System.out.println("2. Sell Weapon");
            System.out.println("3. Leave");

            try {
                input = in.nextInt();
                isChoiceValid = validateChoice(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Command!");
            } finally {
                in.nextLine();
            }

            if(input == 1 && playerInventory.getGold() == 0){
                System.out.println("Looks like You Do Not Have Enough Gold, Try Adventuring Through The Dungeon To Find More Gold!\n");
                menu.display();
            } else{
                System.out.println("You Have Bought A Weapon\n");
                System.out.println("You Now Have A Sword! Take With Care Traveler.\n");
                dungeon.damage();
            }
        }

        if(input == 3){
            isChoiceValid = true;
        }
        return input;
    }

    private boolean validateChoice(int input) {
        return (input >= 1 && input <= 3);
    }

}
