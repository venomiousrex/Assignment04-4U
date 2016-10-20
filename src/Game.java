
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
        //create board game
        Board board = new Board(12,12);
        Doctor doctor = new Doctor(12,12);
        Dalek dalek = new Dalek(3,3);
        
        
        // put a coloured peg at row,col
        board.putPeg(Color.RED, 1,5);
        board.putPeg(Color.BLACK, 2,5);
        //remove peg
        board.removePeg(1,5);
        
        
        doctor.move(4, 3);
        //displays a message
        board.displayMessage("Please click the board");
        
        while(true){
        //get a click on board
        Coordinate click = board.getClick();
        int row = click.getRow();
        int col = click.getCol();
        board.putPeg(Color.MAGENTA, row,col);
        
        }
    }
}
