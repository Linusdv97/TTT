/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTT;





import java.util.Scanner;


/**
 *
 * @author Linus
 */
public class Game {
   
    public static int row, col;
    public static Scanner scan = new Scanner(System.in);
    public static char[][] board = new char[3][3];
    public static char turn = 'O';
  
 
  
        public static void play(){
            boolean playing = true;
            printBoard();
            while(playing){ //Runs when playing is true.
               System.out.println("");
               System.out.printf("Player "+turn+" please enter a row (1-3): ");
               row = scan.nextInt()-1; 
               System.out.printf("Player "+turn+" please enter a column (1-3): ");
               col = scan.nextInt()-1;
             
               if (board[row][col] != '_') {    //If a square is not equal to _.
                        boolean wrong = true;
                  while (wrong) {
                         System.out.println("\nSpace is already used!");    
                         System.out.printf("\nPlayer "+turn+" please enter a row (1-3): ");
                         row = scan.nextInt() - 1;
                         System.out.printf("Player "+turn+" please enter a column (1-3): ");
                         col = scan.nextInt() - 1;
                    if (board[row][col] == '_') {
                         wrong = false;
                     }
                  }
                        board[row][col] = turn;
              }
               
              
                  else{
               board[row][col] = turn;
                  }
                if(gameOver(row, col)){  //If GameOver returns true.
                    playing = false;
                    System.out.println("\nGame over! Player "+turn+" wins!");
                }
                printBoard();
                
               if(turn == 'X'){
                  turn = 'O';
               }
               else{
                  turn ='X'; 
               }
            }
           
            System.out.println("Do you wanna play again(1 = yes & 2 = no)?");  //Ask the players for another round.
            int replay = scan.nextInt();
            if(replay == 1){
              clearBoard();   //Clears the board before starting a new game.
               play();
            }
          }
            
        //Adds | to the board.
          public static void printBoard(){
            for(int i = 0; i < 3 ; i++){
                System.out.println(); 
              for (int j = 0; j < 3; j++) {
                  if(j==0){
                      System.out.print("| ");
                  }
                 System.out.print(board[i][j] +" | ");     
            }
          }
            System.out.println();
        }
          
          //Replaces O and X with _.
         public static void clearBoard(){
           for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {      
				board[row][col] = '_';
			}
            }
        }
          
        public static boolean gameOver(int rowMove, int colMove){
            
            if(board[0][colMove] == board[1][colMove] && board[0][colMove] == board[2][colMove]){    //Horizontal win
            return true;//Game is over.
            }
            if(board[rowMove][0] == board[rowMove][1] && board[rowMove][0] == board[rowMove][2]){   //Vertical win
            return true;//Game is over.
            }
            if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_'){     //Diagonal win 1
            return true;//Game is over.
            }
            if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_'){     //Diagonal win 1
            return true;//Game is over.
            }
            
            return false;  //Game is not over.
        }
}
