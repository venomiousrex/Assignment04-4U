/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hadik9595
 */
public class Doctor {

     //private variables
    //private row coordinate
    private int row;
    //private column coordinate
    private int col;
    //private true/false variable checking if doctor is captured
    private boolean captured;

    /**
     * A constructor to create a doctor!
     *
     * @param row the row where the doctor is located at
     * @param col the column where the doctor is located at
     */
    public Doctor(int row, int col) {
        //initializing instance variables for doctor
        this.col = col;
        this.row = row;
    }

    /**
     * makes the doctor move on the board
     *
     * @param newRow takes the NEW coordinate of row of where the doctor desires
     * to move to
     * @param newCol takes the NEW coordinate of column of where the doctor
     * desires to move to
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

    /**
     * Returns the row of where the doctor is located at
     * @return the number of row where the doctor is located at
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Return the column of where the doctor is located at
     *
     * @return the number of column where the doctor is located at
     */
    public int getCol() {
        return this.col;
    }

    /**
     * checks if the doctor has collided with a dalek
     *
     * @param a specifically which dalek (e.g dalek2)
     * @return true if the doctor has collided with a dalek, otherwise return
     * false
     */
    public boolean captureCheck(Dalek a) {
        //checks doctor's coordinates with dalek's
        if (this.getCol() == a.getCol() && this.getRow() == a.getRow()) {
            return captured = true;
        } else {
            return captured = false;
        }

    }

}
