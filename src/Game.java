
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hadik9595
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tempCol = 1;
        int tempRow = 1;
        
        

        //create board game
        Board board = new Board(12, 12);
        Doctor doctor = new Doctor(tempRow, tempCol);
        
        Dalek dalek = new Dalek(3, 3);
        Dalek dalek2 = new Dalek(6, 4);
        Dalek dalek3 = new Dalek(9,6);
        


        // put a coloured peg at row,col
        board.putPeg(Color.RED, 1, 5);
        board.putPeg(Color.BLACK, 3, 3);
        //remove peg




        //displays a message
        board.displayMessage("Please click the board");



        while (true) {
            //get a click on board 
            Coordinate click = board.getClick();
            //removes the old position of peg for doctor 
            board.removePeg(doctor.getRow(), doctor.getCol());
            
            //removes the old position of peg for dalek 
            board.removePeg(dalek.getRow(), dalek.getCol());
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            board.removePeg(dalek3.getRow(), dalek3.getCol());

            //get coordinates (row,col)
            int row = click.getRow();
            int col = click.getCol();
            
            

            //Sends the coords(row,col) to the Doctor class, (UPDATES WHERE HE IS)
            doctor.move(row, col);
            //takes the new coord we got back from Doctor class and updates it visually
            int newRow = doctor.getRow();
            int newCol = doctor.getCol();

            //draws where the doctor is now
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());
            //takes the new coords and saves them as temporary
            tempCol = newCol;
            tempRow = newRow;

            dalek.advanceTowards(doctor);
            dalek2.advanceTowards(doctor);
            dalek3.advanceTowards(doctor);
            
            board.putPeg(Color.yellow, dalek.getRow(), dalek.getCol());
            board.putPeg(Color.yellow, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.yellow, dalek3.getRow(), dalek3.getCol());
            
           
            if(dalek.hasCrashed(dalek2)){
                dalek.crash();
                dalek2.crash();
                board.putPeg(Color.red, dalek.getRow(), dalek.getCol());
            }
            if(dalek.hasCrashed(dalek3)){
                dalek.crash();
                dalek3.crash();
                board.putPeg(Color.red, dalek.getRow(), dalek.getCol());
            }
            
            

        }

    }
}
