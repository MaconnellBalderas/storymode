package shops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackSmith {
    Scanner in = new Scanner(System.in);

    public void enter() {
        //Upgrade Weapon/Armor
        //Fix Weapon/Armor
        display();
    }

    private int display() {
        int input = 0;
        boolean isChoiceValid = false;

        while (!isChoiceValid) {
            System.out.println("Welcome To The BlackSmith! What Can I do For You?");
            System.out.println("1. Upgrade Weapon");
            System.out.println("2. Fix Weapon");
            System.out.println("3. Upgrade Armor");
            System.out.println("4. Fix Armor");
            System.out.println("5. Leave");

            try {
                input = in.nextInt();
                isChoiceValid = validateChoice(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Command!");
            } finally {
                in.nextLine();
            }
        }
        if(input == 5){
            isChoiceValid = true;
        }
        return input;
    }

    private boolean validateChoice(int input) {
        return (input >= 1 && input <= 5);
    }

}
