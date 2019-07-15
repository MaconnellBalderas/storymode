import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    Scanner in = new Scanner(System.in);

    public int display() {
        int input = 0;
        boolean isChoiceValid = false;

        while (!isChoiceValid) {
            System.out.println("Welcome To The Town! What Would You Like To Do.");
            System.out.println("1. BlackSmith");
            System.out.println("2. Church");
            System.out.println("3. Wizard Center");
            System.out.println("4. Weapon Shop");
            System.out.println("5. Armor Shop");
            System.out.println("6. Dungeon");
            System.out.println("7. Points");
            System.out.println("8. Quit");

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
        return (input >= 1 && input <= 7);
    }
}
