package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    private Character[][] board = {{null, null, null}, {null, null, null}, {null, null, null}};
    private char lastPlayer = '\0';

    public void play(int x, int y) {
        check(x);
        check(y);
        setBoard(x,y);
        lastPlayer = nextPlayer();
    }


    public void check(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Is outside the board");
        }
    }

    public void setBoard(int x, int y) {
        if (board[x - 1][y - 1] != null) {
            throw new RuntimeException("Is already occupied");
        } else {
            board[x - 1][y - 1] = 'X';
        }
    }

    public char nextPlayer(){
         if (lastPlayer == 'X'){
             return 'O';
         }
         return 'X';
    }


}
