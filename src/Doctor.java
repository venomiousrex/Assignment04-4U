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
   

    /**
     * 
     * @param row
     * @param col 
     */
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
        //formula for calculating random coords (row,col)
        int randomRow = (int) (Math.random() * 12);
        int randomCol = (int) (Math.random() * 12);
        //formula used to find difference of new coord(row,col) and old coord(row,col)

        int rowMove = this.row - newRow;
        int colMove = this.col - newCol;

        //if difference is between -1 <= x <= 1 then move accordingly
        if (rowMove <= 1 && rowMove >= -1 && colMove <= 1 && colMove >= -1) {
            this.col = newCol;
            this.row = newRow;
            //if difference happens to be higher than 1 or lower than -1, then teleport randomly
        } else {
            this.col = randomCol;
            this.row = randomRow;

        }

    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
    
  
}
