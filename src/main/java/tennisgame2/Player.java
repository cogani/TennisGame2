package tennisgame2;

/**
 * Player for a tennis game
 */
public class Player {
    private String scores[] = {"love", "fifteen", "thirty", "forty"};
    private int scoreIndex;

    public Player() {
        scoreIndex = 0;
    }

    public String getScore() {
        return scores[scoreIndex];
    }

    public void winBall() {
        scoreIndex++;
    }
}

