package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private char lastPlayer = '\0';
    private static final int SIZE = 3;

    public String play(int x, int y) {
        check(x);
        check(y);
        lastPlayer = nextPlayer();
        setBoard(x,y, lastPlayer);
        if (Win(x,y)){
            return lastPlayer + " wins";
        }
        return "No winner";
    }

    private boolean Win(int x, int y){
        int playerMoves = lastPlayer * SIZE;
        char diagonal1 = '\0';
        char diagonal2 = '\0';

        for (int i = 0; i < SIZE; i++) {
            diagonal1 += board [i] [i];
            diagonal1 += board [i] [SIZE - i - 1];
            if((board[0][i] + board [1][i] + board [2][i])
                    == playerMoves){
                return true;
            }else if( (board[i][0] +board[i][1]+ board [i][2])
                    == playerMoves ){
                return true;
            }
        }
        if (board[0][0] +board[1][1]+ board [2][2]
            == playerMoves ) {
            return true;
        }else if (board [0][2] + board[1][1] + board [2][0]
                    == playerMoves){
            return true;
        }
        return false;
    }


    public void check(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Is outside the board");
        }
    }

    public void setBoard(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != null) {
            throw new RuntimeException("Is already occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer(){
         if (lastPlayer == 'X'){
             return 'O';
         }
         return 'X';
    }


}
