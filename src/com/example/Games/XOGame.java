package com.example.Games;

import java.util.Arrays;
import java.util.Scanner;

public class XOGame {
    public static void main(String[] args){
        char[][] board = new char[3][3];
        // taking rows and columns for board
        for(int r=0; r<board.length; r++){
            Arrays.fill(board[r], ' ');
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        

        while(!false) {
            printBoard(board);
            System.out.print(("Player " + player + " enter: "));
            int r = sc.nextInt();
            int c = sc.nextInt();
            System.out.println();
            if (board[r][c] == ' ') {
                board[r][c] = player;
                gameOver = won(board, player);
                if (gameOver) {
                    System.out.println("!! Player " + "'" + player + "'" + " has won !!");
                    printBoard(board);
                    break;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try Again!");
            }





        }



    }



    private static boolean won(char[][] board, char player) {
        //Horizontal factor - checking the rows
        for(int r=0; r<board.length; r++){
            if(board[r][0] == player && board[r][1] == player && board[r][2] == player){
                return true;
            }
        }
        //Vertical factor - checking the columns
        for(int c=0; c<board[0].length; c++){
            if(board[0][c] == player && board[1][c] == player && board[2][c] == player){
                return true;
            }
        }
        //Diagonal factor
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;}

        return false;

    }

    public static void printBoard(char[][] board) {
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
        }
    }
}
