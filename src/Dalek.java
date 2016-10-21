/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hadik9595
 */
public class Dalek {

    private int col;
    private int row;
    private boolean crash;
    
        
    public Dalek(int row, int col){
        this.col = col;
        this.row = row;
    }
    
     public void advanceTowards(Doctor doc){
         int row = doc.getRow();
         int col = doc.getCol();
         
         
         int rowMove = this.row - row;
        int colMove = this.col - col;
        
         System.out.println("Row for DALEK " + rowMove + " colMove " + colMove);
         if(!crash){
             if(rowMove <= 0){
                 this.row++;
             }
             
              if(rowMove >= 0){
                 this.row--;
             }
             
              if(colMove <= 0){
                 this.col++;
             }
              if(colMove >= 0){
                 this.col--;
             }
         }
         
     }
   
    
     public int getRow(){
        return this.row;
    }
     
     public int getCol(){
         return this.col;
     }
     
     
     public void crash(){
         crash = true;
         System.out.println("BOOOM CRASHED");
     }
     
       public boolean hasCrashed(Dalek d){
         int row = d.getRow();
         int col = d.getCol();
        
        
        if(this.col == col && this.row == row){
            return true;
        }else{
            return false;
        }
    }
     
}
