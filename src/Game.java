
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
        //state of the game
        boolean done = false;
        int counter = 0;

        int randomnumber = (int) (Math.random() * 12);
     

        //create board game
        Board board = new Board(12, 12);

        //creation of doctor
        Doctor doctor = new Doctor(randomDoc,0);

        //creation of daleks
        Dalek dalek = new Dalek(dalekRandom, 11);
        Dalek dalek2 = new Dalek(dalekRandom, 5);
        Dalek dalek3 = new Dalek(dalekRandom,10);

     
        //display message on screen
        board.displayMessage("Please press the board");

        //while loop that runs the game as long as doctor is alive, or all daleks are EXTERMINATED 
        while (!done) {

            //get a click on board 
            Coordinate click = board.getClick();
            counter++;
            System.out.println(counter);
            //removes the old position of peg for doctor 
            board.removePeg(doctor.getRow(), doctor.getCol());

            //removes the old position of peg for dalek 
            board.removePeg(dalek.getRow(), dalek.getCol());
            board.removePeg(dalek2.getRow(), dalek2.getCol());
            board.removePeg(dalek3.getRow(), dalek3.getCol());

            //get coordinates for ze doctor (row,col)
            int row = click.getRow();
            int col = click.getCol();

            //Sends the coords(row,col) to the Doctor class, (UPDATES WHERE HE IS)
            doctor.move(row, col);

            //draws where the doctor is now
            board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());

            //movement of daleks 
            dalek.advanceTowards(doctor);
            dalek2.advanceTowards(doctor);
            dalek3.advanceTowards(doctor);

            //draws the daleks
            board.putPeg(Color.yellow, dalek.getRow(), dalek.getCol());
            board.putPeg(Color.yellow, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.yellow, dalek3.getRow(), dalek3.getCol());

            //if dalek collides with dalek2, crash both, and mark it red (Ask Lamont if we should remove yellow pegs)
            if (dalek.hasCrashed(dalek2)) {
                dalek.crash();
                dalek2.crash();
                //doesn't matter who becomes red flagged as crashed, as long as it's either dalek involved in accident
                board.putPeg(Color.red, dalek.getRow(), dalek.getCol());

            }

            //if dalek collides with dalek3, crash both, and mark it red
            if (dalek.hasCrashed(dalek3)) {
                dalek.crash();
                dalek3.crash();
                //doesn't matter who becomes red flagged as crashed, as long as it's either dalek involved in accident
                board.putPeg(Color.red, dalek3.getRow(), dalek3.getCol());
            }

            //if dalek2 collides with dalek3, crash both, and mark it red
            if (dalek2.hasCrashed(dalek3)) {
                dalek2.crash();
                dalek3.crash();
                //doesn't matter who becomes red flagged as crashed, as long as it's either dalek involved in accident
                board.putPeg(Color.red, dalek2.getRow(), dalek2.getCol());
            }

            //checks if all the daleks have crashed, if so, end the game and print YOU WIN!
            if (dalek2.hasCrashed(dalek3) && dalek.hasCrashed(dalek3) && dalek.hasCrashed(dalek2)) {
                board.displayMessage("YOU WIN!");
                //Draws a "W" symbolizing VICTORY!
                board.drawLine(3, 2, 7, 3);
                board.drawLine(3, 5, 7, 3);
                board.drawLine(7, 7, 3, 8);
                board.drawLine(3, 5, 7, 7);
                done = true;
            }

            //checks if the doctor has encountered a dalek, if so, end the game and print YOU LOST!
            if (doctor.captureCheck(dalek) || doctor.captureCheck(dalek2) || doctor.captureCheck(dalek3)) {
                board.displayMessage("Unfortunately, you have been EXTERMINATED!");
                //Draws a "L" symbolizing LOSS!
                board.drawLine(3, 4, 7, 4);
                board.drawLine(7, 4, 7, 7);
                done = true;
            }


        }

    }
}
