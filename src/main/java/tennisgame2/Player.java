package tennisgame2;

/**
 * Player for a tennis game
 */
public class Player {
    private final String scores[] = {"love", "fifteen", "thirty", "forty"};
    private final String name;

    public int getScoreIndex() {
        return scoreIndex;
    }

    private int scoreIndex;

    public Player(String name) {
        scoreIndex = 0;
        this.name = name;
    }

    public void winBall() {
        scoreIndex++;
    }

    public String getScore() {
        return scores[scoreIndex];
    }

    public String getName() {
        return name;
    }

}

