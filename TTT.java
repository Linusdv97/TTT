/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTT;

import static TTT.Game.board;

import java.util.Scanner;

/**
 *
 * @author Linus
 */
public class TTT {
    
    public static void main(String[]args){
       
        Scanner in =new Scanner(System.in); 
        Game myGame = new Game();
         for(int i = 0; i < 3; i++){
           for(int j = 0; j < 3;j++){       //Adds _ to the board.
               board[i][j]='_';
        }    
        }

        myGame.play(); //Starts a new game.
    }
    
}
