package tennisgame2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for Player
 */
public class PlayerTest {
    private Player player;

    @Before
    public void setup() {
        player = new Player();
    }

    @Test
    public void GivenAPlayerHas0Points_WhenScoreIsQueried_LoveIsReturned() {
        String expectedScore = "love";

        checkResult(expectedScore);
    }

    @Test
    public void GivenAPlayerHas1Points_WhenScoreIsQueried_FifteenIsReturned() {
        String expectedScore = "fifteen";

        player.winBall();

        checkResult(expectedScore);
    }

    @Test
    public void GivenAPlayerHas2Points_WhenScoreIsQueried_ThirtyIsReturned() {
        String expectedScore = "thirty";

        increaseScore(player, 2);

        checkResult(expectedScore);
    }

    @Test
    public void GivenAPlayerHas3Points_WhenScoreIsQueried_FortyIsReturned() {
        String expectedScore = "forty";

        increaseScore(player, 3);

        checkResult(expectedScore);
    }

    private void increaseScore(Player player, int points) {
        for (int i = 0; i < points; i++) {
            player.winBall();
        }
    }

    private void checkResult(String expectedScore) {
        assertEquals(expectedScore, player.getScore());
    }
}