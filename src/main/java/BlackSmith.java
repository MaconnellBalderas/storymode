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
            System.out.println("Welcome To The Weapon Shop! What Can I do For You?");
            System.out.println("1. Upgrade Weapon");
            System.out.println("2. Fix Weapon");
            System.out.println("3. Upgrade Armor");
            System.out.println("4. Fix Armor");

            try {
                input = in.nextInt();
                isChoiceValid = validateChoice(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Command!");
            } finally {
                in.nextLine();
            }
        }
        return input;
    }

    private boolean validateChoice(int input) {
        return (input >= 1 && input <= 4);
    }

}
