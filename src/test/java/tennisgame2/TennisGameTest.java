package tennisgame2;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for TennisGame
 */
public class TennisGameTest {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("p1");
        player2 = new Player("p2");
    }

    @Test
    public void GivenTwoPlayersWithTheSamePoints_WhenScoreIsQueried_ThenDeuceIsReturned() {
        String expectedScore = TennisGame.DEUCE;
        TennisGame tennisGame = new TennisGame(player1, player2);

        TestCommonHelpers.increaseScore(player1, 3);
        TestCommonHelpers.increaseScore(player2, 3);

        checkResult(expectedScore, tennisGame);
    }

    @Test
    public void GivenTwoPlayersWithTheSamePointsAndLessThanForty_WhenScoreIsQueried_ThenResultIsGonnaUsedFromLoveToFifteen() {
        String expectedScore = "love, love";
        TennisGame tennisGame = new TennisGame(player1, player2);


        checkResult(expectedScore, tennisGame);
    }

    @Test
    public void GivenTwoPlayersWithTheSamePointsAndLessThanFortyButNotTheSamePointsBoth_WhenScoreIsQueried_ThenResultIsGonnaUsedFromLoveToFifteen() {
        String expectedScore = "thirty, love";
        TennisGame tennisGame = new TennisGame(player1, player2);

        TestCommonHelpers.increaseScore(player1, 2);
        checkResult(expectedScore, tennisGame);
    }

    @Test
    public void GivenTwoPlayersWithTheSamePoints_WhenScoreIsQueried_ThenDeuceIsReturned2() {
        String expectedScore = "fifteen, love";
        TennisGame tennisGame = new TennisGame(player1, player2);
        TestCommonHelpers.increaseScore(player1, 1);

        checkResult(expectedScore, tennisGame);
    }

    @Test
    public void GivenPlayer1With1PointMoreThanTheOther_WhenScoreIsQueried_ThenAdvantageForPlayer1IsReturned() {
        String expectedScore = TennisGame.ADVANTAGE + " " + player1.getName();
        TennisGame tennisGame = new TennisGame(player1, player2);

        TestCommonHelpers.increaseScore(player1, 4);
        TestCommonHelpers.increaseScore(player2, 3);
        checkResult(expectedScore, tennisGame);
    }


    @Test
    public void GivenPlayer2With1PointMoreThanTheOther_WhenScoreIsQueried_ThenAdvantageForPlayer2IsReturned() {
        String expectedScore = TennisGame.ADVANTAGE + " " + player2.getName();
        TennisGame tennisGame = new TennisGame(player1, player2);

        TestCommonHelpers.increaseScore(player1, 3);
        TestCommonHelpers.increaseScore(player2, 4);
        checkResult(expectedScore, tennisGame);
    }


    @Test
    public void GivenPlayer1With2PointMoreThanTheOther_WhenScoreIsQueried_ThenWinForPlayer1IsReturned() {
        String expectedScore = TennisGame.WINNER + " " + player1.getName();
        TennisGame tennisGame = new TennisGame(player1, player2);

        TestCommonHelpers.increaseScore(player1, 5);
        checkResult(expectedScore, tennisGame);
    }

    @Test
    public void GivenPlayer2With2PointMoreThanTheOther_WhenScoreIsQueried_ThenWinForPlayer2IsReturned() {
        String expectedScore = TennisGame.WINNER + " " + player2.getName();
        TennisGame tennisGame = new TennisGame(player1, player2);

        TestCommonHelpers.increaseScore(player2, 5);
        checkResult(expectedScore, tennisGame);
    }

    private void checkResult(String expectedScore, TennisGame tennisGame) {
        assertEquals(expectedScore, tennisGame.getScore());
    }

}