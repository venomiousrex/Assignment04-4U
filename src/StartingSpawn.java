/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hadik9595
 */
public class StartingSpawn {

    /**
     * Method that compares 2 row coordinates
     *
     * @param randomCoord takes in the first random coordinate of doctor's, and
     * the 3 daleks (coord can be row or col)
     * @param randomCoord2 takes in the second random coordinate of doctor's,
     * and the 3 daleks (coord can be row or col)
     * @return another randomized number if 2 coordinates match, otherwise
     * return the number itself
     */
    public static int compareCoords(int randomCoord, int randomCoord2) {

        //formula for a random value
        int randomize = (int) (Math.random() * 12);
        //compares 2 coords, if they're equal, return a new random value
        if (randomCoord == randomCoord2) {

            System.out.println("Uh oh, collision upon spawn?? here's your new coordinate " + randomize);
            return randomize;

        }//if not, return either one of the coord  
        else {
            return randomCoord;
        }
    }
}
