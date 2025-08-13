package tictactoe;

import java.util.Objects;

public class Game {
    String firstPlayer = "X";
    String secondPlayer = "O";
    String emptySpace = " ";
    private final int countOfFirstPlayer;
    private final int countOfSecondPlayer;
    private final int countOfEmptySpace;


    Game(String[][] input) {

        this.countOfFirstPlayer = countTheDraw(firstPlayer, input);
        this.countOfSecondPlayer = countTheDraw(secondPlayer, input);
        this.countOfEmptySpace = countTheDraw(emptySpace, input);
    }


    private int countTheDraw(String player, String[][] input) {
        int counter = 0;
        for (int i = 0; i <= input.length - 1; i++) {
            for (int y = 0; y <= input[0].length - 1 ; y++) {
                if (input[i][y].equals(player)) {
                    counter += 1;
                }
            }
        }
        return counter;
    }


    protected boolean checkResult(String[][] input) {
        if (Math.abs(countOfFirstPlayer - countOfSecondPlayer) > 1) {
            System.out.println("Impossible");
        } else {

            boolean player1 = (topRow(input,firstPlayer ) || LeftColumn(input,firstPlayer )
                    || leftDiagonal(input,firstPlayer ) || rightColumn(input, firstPlayer)
                    || rightDiagonal( input, firstPlayer) || bottomRow(input, firstPlayer)
                    || topMiddle(input,  firstPlayer) || sideMiddle(input, firstPlayer));

            boolean player2 = (topRow(input,secondPlayer) || LeftColumn(input,secondPlayer )
                    || leftDiagonal(input,secondPlayer) || rightColumn(input, secondPlayer)
                    || rightDiagonal( input, secondPlayer) || bottomRow(input, secondPlayer)
                    || topMiddle(input, secondPlayer) || sideMiddle(input,secondPlayer));

            if (player1 && player2){
                System.out.println("Impossible");
                return false;
            }else if (!player1 && !player2 &&  countOfEmptySpace != 0){
                System.out.println("Game not finished");
            } else if (player1){
                System.out.println("X wins");
                return true;
            }else if (player2){
                System.out.println("O wins");
                return true;
            }else {
                System.out.println("Draw");
                return true;
            }


        }
        return false;

    }

    private boolean topRow(String[][] input, String draw){
        int counter = 0;
        for(int column = 0; column <= input[0].length - 1; column++){
            if( Objects.equals(input[0][column], draw)) {
                counter++;}
        }
        return counter == 3;
    }
    private boolean LeftColumn(String[][] input, String draw){
        int counter = 0;
        for(int row = 0; row <= input[0].length - 1; row++){
            if (Objects.equals(input[row][0], draw)){ counter++;}
        }
        return counter == 3;
    }
    private boolean leftDiagonal(String[][] input, String draw){
        int counter = 0;
        int row = 0;
        for(int column = 0; column <= input[0].length - 1; column++){
            if (Objects.equals(input[row][column], draw)){
                counter++;
                row++;
            }
        }
        return counter == 3;
    }

    private boolean rightColumn(String[][] input, String draw){
        int counter = 0;
        for(int row = 0; row <= input[0].length - 1; row++){
            if (Objects.equals(input[row][2], draw)){counter++;}
        }
        return counter == 3;
    }
    private boolean rightDiagonal(String[][] input, String draw){
        int counter = 0;
        int row = 0;
        for(int column = input[0].length - 1; column >= 0 ; column--){
            if (Objects.equals(input[row ][column ], draw)) {
                counter++;
                row++;
            }
        }
        return counter == 3;
    }
    private boolean bottomRow(String[][] input, String draw){
       int counter = 0;
        for(int column = 0; column <= input[0].length - 1; column++){
            if(Objects.equals(input[2][column], draw)){
               counter++;
            }
        }
        return counter == 3;
    }

    private boolean topMiddle(String[][] input, String draw){
        int counter = 0;
        int column = 1;
        for(int row = 0; row <= input[0].length - 1; row++){
            if (Objects.equals(input[row][column], draw)) {
                counter++;}
        }
        return counter == 3;
    }
    private boolean sideMiddle(String[][] input, String draw){
        int counter = 0;
        int row = 1;
        for(int column = 0; column <= input[0].length - 1; column++){
            if(Objects.equals(input[row][column], draw)) {
                counter++;
            }
        }
        return counter == 3;
    }


}

