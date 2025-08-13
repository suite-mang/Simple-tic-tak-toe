package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        int firstDimension = 3;
        int secondDimension = 3;
        Scanner scanner = new Scanner(System.in);
        Convention convention = new Convention(firstDimension, secondDimension);
        Game game = new Game(convention.getInput());

        //get user draw
        String draw;
        do {
            do {
                draw = scanner.nextLine();
            } while (!convention.checkCoordinate(draw));
            game = new Game(convention.getInput());

        }while (!game.checkResult(convention.getInput()));
        scanner.close();

    }
}
