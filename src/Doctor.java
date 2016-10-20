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
    
    public Doctor(int row, int col){
        this.col = col;
        this.row = row;
        
    }
    
    public void move(int newRow, int newCol){
        int rowMove = this.row - newRow;
        int colMove = this.col - newCol;
        System.out.println(rowMove);
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    
    
}
