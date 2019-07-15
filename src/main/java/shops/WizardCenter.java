package shops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WizardCenter {
    Scanner in = new Scanner(System.in);
    public void enter() {
        //Learn Spells
        //Upgrade Spells
        //Buy/Sell Wizard items *Cloak, potions, wand*
        display();
    }

    private int display() {
        int input = 0;
        boolean isChoiceValid = false;

        while (!isChoiceValid) {
            System.out.println("Welcome To The Wizard Center! What Spells May You Cast Today?");
            System.out.println("1. Learn A New Spell");
            System.out.println("2. Upgrade Spell");
            System.out.println("3. Buy Wizard Item");
            System.out.println("4. Sell Wizard Item");
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
