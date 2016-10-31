
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

        //a random row coordinate for each doctor and daleks
        int[] randomRow = new int[4];
        int[] randomCol = new int[4];

        //for loop assigning random values to characters (doc, daleks)
        for (int i = 0; i < randomRow.length; i++) {
            //random formula
            int random = (int) (Math.random() * 12);
            int random2 = (int) (Math.random() * 12);
            //assigns randome number to the slot, (you can play around with this and set both array[i] to equal 0 and see yourself)
            randomRow[i] = random;
            randomCol[i] = random2;
        }

        //a for loop that goes through and checks if any coords are the same (i.e 5 and 5) 
        for (int i = 0; i < randomRow.length - 1; i++) {

            //assigns another random value if 2 of the coordinates ARE THE SAME, sends both coords to check if they're the same 
            randomRow[i] = StartingSpawn.compareCoords(randomRow[i], randomRow[i + 1]);
            randomCol[i] = StartingSpawn.compareCoords(randomCol[i], randomCol[i + 1]);

        }
        //create board game
        Board board = new Board(12, 12);

        //creation of doctor
        Doctor doctor = new Doctor(randomRow[0], randomCol[0]);

        //creation of daleks
        Dalek dalek = new Dalek(randomRow[1], randomCol[1]);
        Dalek dalek2 = new Dalek(randomRow[2], randomCol[2]);
        Dalek dalek3 = new Dalek(randomRow[3], randomCol[3]);

        //draws the doctor
        board.putPeg(Color.GREEN, doctor.getRow(), doctor.getCol());

        //draws the daleks
        board.putPeg(Color.BLACK, dalek.getRow(), dalek.getCol());
        board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
        board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

        //displays a message
        board.displayMessage("Please click the board");

        //while loop that runs the game as long as doctor is alive, or all daleks are EXTERMINATED 
        while (!done) {
            //get a click on board 
            Coordinate click = board.getClick();
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

            //draws the updated daleks 
            board.putPeg(Color.BLACK, dalek.getRow(), dalek.getCol());
            board.putPeg(Color.BLACK, dalek2.getRow(), dalek2.getCol());
            board.putPeg(Color.BLACK, dalek3.getRow(), dalek3.getCol());

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
                //ends the game by toggling done
                done = true;
            }

            //checks if the doctor has encountered a dalek, if so, end the game and print YOU LOST!
            if (doctor.captureCheck(dalek) || doctor.captureCheck(dalek2) || doctor.captureCheck(dalek3)) {
                board.putPeg(Color.yellow, doctor.getRow(), doctor.getCol());
                board.displayMessage("Unfortunately, you have been EXTERMINATED!");
                //Draws a "L" symbolizing LOSS!
                board.drawLine(3, 4, 7, 4);
                board.drawLine(7, 4, 7, 7);
                //ends game by toggling done 
                done = true;
            }

        }

    }
}
