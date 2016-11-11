/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hadik9595
 */
public class Dalek {

    //private variables
    //private column coordinate
    private int col;
    //private row coordinate
    private int row;
    //private true/false variable checking if dalek has crashed
    private boolean crash;

    /**
     * Constructor for creation of dalek (robot)
     *
     * @param row the row where the dalek is located at
     * @param col the column where the dalek is located at
     */
    public Dalek(int row, int col) {
        //initializing instance variables for dalek
        this.col = col;
        this.row = row;
    }

    /**
     * tracks down where the doctor is, and advances towards the doctor
     *
     * @param doc takes access of the doctor class where we can track his
     * coordinates
     */
    public void advanceTowards(Doctor doc) {
        //stores the coordinates of the doctor's current location
        int row = doc.getRow();
        int col = doc.getCol();

        //formula used to calculate the distance between doctor's coordinates and dalek's coordinates 
        int rowMove = this.row - row;
        int colMove = this.col - col;

        //as long as the dalek has not crashed
        if (!crash) {
            //adds one to row's coordinate making dalek move towards doctor, that way it is now closer to 0 (tries to reach 0)
            if (rowMove <= 0) {
                this.row++;
            }

            //removes one to row's coordinate making dalek move towards doctor, that way it is now closer to 0 (tries to reach 0)
            if (rowMove >= 0) {
                this.row--;
            }

            //adds one to column's coordinate making dalek move towards doctor, that way it is now closer to 0 (tries to reach 0)
            if (colMove <= 0) {
                this.col++;
            }

            //removes one to column's coordinate making dalek move towards doctor, that way it is now closer to 0 (tries to reach 0)
            if (colMove >= 0) {
                this.col--;
            }
        }

    }

    /**
     * Returns the row of where the dalek is placed at
     *
     * @return the number of row where the dalek is located at
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of where the dalek is located at
     *
     * @return the number of column where the dalek is located at
     */
    public int getCol() {
        return this.col;
    }

    /**
     * a void method that sets a dalek "crashed" once they have collided with
     * another dalek
     */
    public void crash() {
        this.crash = true;

    }

    /**
     * checks if dalek collides with another dalek in terms of coordinates
     *
     * @param d passes in another dalek that we can access its coordinates
     * @return true if the dalek has collided with another dalek, otherwise
     * return false
     */
    public boolean hasCrashed(Dalek d) {

        //checks if coordinate of one dalek is the same as the other (row,col) 
        if (this.col == d.getCol() && this.row == d.getRow()) {
            return true;
        } else {
            return false;
        }
    }

}
