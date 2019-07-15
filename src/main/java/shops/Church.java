package shops;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Church {
    Scanner in = new Scanner(System.in);
    public void enter() {
        //Heal player
        //Upgrade Stats of Player
        //*SpawnPoint*
        display();
    }

    private int display() {
        int input = 0;
        boolean isChoiceValid = false;

        while (!isChoiceValid) {
            System.out.println("Welcome To The shops.Church! How May The Lord Serve You?");
            System.out.println("1. Heal Player");
            System.out.println("2. Upgrade Stats");
            System.out.println("3. Set Spawn Point");
            System.out.println("4. leave");

            try {
                input = in.nextInt();
                isChoiceValid = validateChoice(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Command!");
            } finally {
                in.nextLine();
            }
        }
        if(input == 4){
            isChoiceValid = true;
        }
        return input;
    }

    private boolean validateChoice(int input) {
        return (input >= 1 && input <= 4);
    }
}
