import java.util.InputMismatchException;
import java.util.Scanner;

public class ArmorShop {
    Scanner in = new Scanner(System.in);
    public void enter() {
        //Buy Armor
        //Sell Armor
        display();
    }

    private int display() {
        int input = 0;
        boolean isChoiceValid = false;

        while (!isChoiceValid) {
            System.out.println("Welcome To The Armor Shop! How May You Find Protection Today?");
            System.out.println("1. Buy Armor");
            System.out.println("2. Sell Armor");

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
        return (input >= 1 && input <= 2);
    }
}
