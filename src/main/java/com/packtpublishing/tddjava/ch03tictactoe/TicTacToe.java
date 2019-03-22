package com.packtpublishing.tddjava.ch03tictactoe;

public class TicTacToe {

    private Character [][] board = {{null, null, null}, {null, null, null}, {null, null, null}};

    public void play(int x, int y){
        if (x<1 || x>3){
            throw new RuntimeException("X is outside board");
        }else if (y<1 || y>3){
            throw new RuntimeException("Y is outside board");
        }

        if (board [x-1][y-1] != null ) {
            throw new RuntimeException("Is already occupied");
        }else {
            board [x-1][y-1] = 'X';
        }

    }

}
