import java.io.*;
import java.util.*;
public class Nqueen
{
    public static void main(String []args)throws Exception
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();   //intput n suppose 2
        int [][]chess=new int[n][n];  //chess 2d array created indexes are (00,01,10,11)
        printnqueen(chess, "",0);  //call function this fuction is haveing chess array, ans , row
    }
    public static void printnqueen(int [][]chess,String ans,int row)  //haveing chess,ans,row (row is level)
    {
     if(row==chess.length) //base case when row reached to maximum length of chees array
     {
      System.out.println(ans);  //it will print ans in form (row-col)
      return;
     }
     for(int col=0;col< chess.length;col++)  // loop on col because it is optional(means 0th row have two option either goto 0col or 1 col)
       {
         if(isQueenIsatSafeplace(chess,row,col)==true)  // this function will check is this index is safe if we place our queen here it Should not die.
          {
             chess[row][col] = 1;  // then when it has been checked it will place by makeing it 1
             printnqueen(chess, ans + row + "-" + col + ",", row + 1);  //recursion called for checking every block of chess board
             chess[row][col] = 0;    //if we have placed and then we have to backtrack then removed the placed queen by makeing it 0
          }
       }
    }
    public static boolean isQueenIsatSafeplace(int [][]chess,int row,int col)
    {
        //vertical move
        for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }
        //diagonal where col decrease direction
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        //diagonal where col incerease direction
        for(int i=row-1,j=col+1; i>=0 && j< chess.length ; i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }
     return  true;
    }
}
