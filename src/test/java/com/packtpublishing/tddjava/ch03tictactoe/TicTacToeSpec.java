package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;



public class TicTacToeSpec {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardRuntimeException(){
//        exception.expect(RuntimeException.class);
        //when
//        ticTacToe.play(5,2);
        //then
        assertThatThrownBy(()-> {
            ticTacToe.play(5,2);
        }).isInstanceOf(RuntimeException.class);

    }

    @Test
    public void whenYOutsideBoardRuntimeException(){
        assertThatThrownBy(()->{
            ticTacToe.play(2,5);
        }).isInstanceOf(RuntimeException.class);
//        exception.expect(RuntimeException.class);
//        ticTacToe.play(2,5);
    }
    @Test
    public void whenOccupiedRuntimeException(){
        ticTacToe.play(2,1);
        assertThatThrownBy(()-> {
            ticTacToe.play(2,1);
        }).isInstanceOf(RuntimeException.class);
//        ticTacToe.play(2,1);
//        exception.expect(RuntimeException.class);
//        ticTacToe.play(2,1);
    }

    @Test
    public void XshouldBeGivnFirstTurnAndAfterO(){
//        assertEquals('X', ticTacToe.nextPlayer());
        assertThat(ticTacToe.nextPlayer()).isEqualTo('X');
    }

    @Test
    public void OshouldBeLastAndAfterX(){

        //when
        ticTacToe.play(1,1);

        //then
//        assertEquals('O', ticTacToe.nextPlayer());
        assertThat(ticTacToe.nextPlayer()).isEqualTo('O');
    }

    @Test
    public void NoWinner(){
        String actual = ticTacToe.play(1,1);
        assertThat(actual).isEqualTo("No winner");
    }

    @Test
    public void WinnerWhenWholeHorizontal(){
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,1);
        ticTacToe.play(2,2);
        String actual = ticTacToe.play(3,1);
        assertThat(actual).isEqualTo("X wins");
    }

    @Test
    public void  WinnerWhenWholeVertical(){
        ticTacToe.play(2,2);
        ticTacToe.play(3,1);
        ticTacToe.play(2,1);
        ticTacToe.play(3,2);
        String actual = ticTacToe.play(2,3  );
        assertThat(actual).isEqualTo("X wins");
    }

    @Test
    public void WinnerWhenDiagonalTopBottom(){
        ticTacToe.play(1,1);
        ticTacToe.play(3,1);
        ticTacToe.play(2,2);
        ticTacToe.play(3,2);
        String actual = ticTacToe.play(3,3  );
        assertThat(actual).isEqualTo("X wins");
    }

    @Test
    public void WinnerWhenDiagonalaBottomTop(){
        ticTacToe.play(1,3);
        ticTacToe.play(1,1);
        ticTacToe.play(2,2);
        ticTacToe.play(3,2);
        String actual = ticTacToe.play(3,1  );
        assertThat(actual).isEqualTo("X wins");
    }


}
