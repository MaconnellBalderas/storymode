package shops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeaponShop {
    Scanner in = new Scanner(System.in);
    public void enter() {
        //Buy Weapon
        //Sell Weapon
        display();
    }

    private int display() {
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
