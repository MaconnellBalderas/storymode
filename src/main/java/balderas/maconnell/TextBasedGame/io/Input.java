package balderas.maconnell.TextBasedGame.io;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int nextInt(){
        return scanner.nextInt();
    }

    public String nextLine(){
        return scanner.nextLine();
    }

}
