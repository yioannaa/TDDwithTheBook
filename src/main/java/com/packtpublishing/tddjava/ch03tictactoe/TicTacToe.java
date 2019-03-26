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
        } else if (Draw()){
            return "It is a draw";
        }
        return "No winner";
    }

    public char nextPlayer(){
        if (lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }

    public void check(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("Is outside the board");
        }
    }

    public void setBoard(int x, int y, char lastPlayer) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Is already occupied");
        } else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }


    private boolean Win(int x, int y){
        int playerMoves = lastPlayer * SIZE;

        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < SIZE; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];
        }
        if (horizontal == playerMoves
                || vertical == playerMoves
                || diagonal1 == playerMoves
                || diagonal2 == playerMoves) {
            return true;
        }
        return false;
    }



    private boolean Draw(){
        for (int x = 0; x <SIZE ; x++) {
            for (int y = 0; y <SIZE ; y++) {
                if (board [x][y] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }




}
