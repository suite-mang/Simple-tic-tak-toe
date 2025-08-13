package tictactoe;

import java.util.Objects;

public class Convention{
    final String[][] Input;
    static String flag = "X";

    Convention(int row , int column){
        this.Input = new String[row][column];
        addInitail();
        printGameField();
    }

    public String[][] getInput() {
        return Input;
    }

    protected void addInitail(){

        for(int i = 0; i <= Input.length - 1; i++) {
            for (int y = 0; y < Input[0].length; y++){
              Input[i][y] = " ";


            }

        }
    }

    protected void printGameField(){
        System.out.println("---------");
        for (String[] seat : Input) {
            System.out.print("| ");
            for (int column = 0; column < Input[0].length; column++) {
                System.out.print(seat[column]);
                if (column != Input[0].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("---------");
    }
    protected boolean checkCoordinate(String draw){

         try {
             int firstCoordinate =Integer.parseInt(String.valueOf(draw.charAt(0)));
             int secondCoordinate =Integer.parseInt(String.valueOf(draw.charAt(2)));
             if(firstCoordinate >= 1 && firstCoordinate <= 3
                     && secondCoordinate >= 1 && secondCoordinate <= 3) {
                 if(isCellNotOccupied(firstCoordinate,secondCoordinate)){

                     this.Input[firstCoordinate - 1][secondCoordinate - 1] = flag;
                     if(Objects.equals(flag, "X")){
                         flag = "O";
                     }else {
                         flag = "X";
                     }
                     printGameField();
                     return true;
                 }else{
                     System.out.println("This cell is occupied! Choose another one!");
                     return false;
                 }


             }else{
                 System.out.println("Coordinates should be from 1 to 3!");
                 return false;
             }
         } catch (NumberFormatException e){
             System.out.println("You should enter numbers!");
             return false;
         }

    }
    protected boolean isCellNotOccupied(int firstCoordinate,int secondCoordinate){
        return Objects.equals(Input[firstCoordinate - 1][secondCoordinate - 1], " ");
    }



}
