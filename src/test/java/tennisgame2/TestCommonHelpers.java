package tennisgame2;

/**
 * Common helpers for testing
 */
public class TestCommonHelpers {

    public static void increaseScore(Player player, int points) {
        for (int i = 0; i < points; i++) {
            player.winBall();
        }
    }
}
