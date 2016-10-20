
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
        int initialCol = 1;
        int initialRow = 1;
       
        //create board game
        Board board = new Board(12,12);
        Doctor doctor = new Doctor(initialCol,initialRow);
        Dalek dalek = new Dalek(3,3);
        Dalek dalek2 = new Dalek(4,4);
        
        
        // put a coloured peg at row,col
        board.putPeg(Color.RED, 1,5);
        board.putPeg(Color.BLACK, 2,5);
        //remove peg
       
        
        
        
        //displays a message
        board.displayMessage("Please click the board");
        
        
        //get a click on board
        while(true){
         Coordinate click = board.getClick();
         board.putPeg(Color.GREEN, initialRow,initialCol);
        int row = click.getRow();
        int col = click.getCol();
        initialCol = col;
        initialRow = row;
       
        doctor.move(row, col);
         int newRow = doctor.getRow();
        int newCol = doctor.getCol();
        board.putPeg(Color.GREEN, newRow,newCol);
   

       
        }
        
    }
}
