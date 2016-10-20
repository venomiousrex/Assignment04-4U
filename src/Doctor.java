/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hadik9595
 */
public class Doctor {

    private int row;
    private int col;

    public Doctor(int row, int col) {
        this.col = col;
        this.row = row;

    }
/**
 * makes the doctor move on the board
 * @param newRow takes the doctor's row number
 * @param newCol takes the doctor's column number
 */
    public void move(int newRow, int newCol) {
        int randomRow = (int) (Math.random() * 12);
        int randomCol = (int) (Math.random() * 12);
        int rowMove = this.row - newRow;
        int colMove = this.col - newCol;
        System.out.println("Row: " + rowMove);
        System.out.println("Col: " + colMove);

        if (rowMove <= 1 && rowMove >= -1 && colMove <= 1 && colMove >= -1) {
            System.out.println("It works!");
            this.col = newCol;
            this.row = newRow;
        }else{
            System.out.println("RANDOMNESS OCCURR!");
            this.col = randomCol;
            this.row = randomRow;
            
        }
        

        System.out.println("Currently " + this.row + " and the col is " + this.col);
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

}
