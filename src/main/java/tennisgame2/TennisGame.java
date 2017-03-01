package tennisgame2;

/**
 * Main class for the tennis game
 */
public class TennisGame {
    public static final String ADVANTAGE = "advantage";
    public static final String WINNER = "winner";
    public static final String DEUCE = "deuce";
    
    private static final int FORTY = 3;
    private static final int ADVANTAGE_DIFFERENCE = 1;
    private static final int WINNER_DIFFERENCE = 2;
    private final Player player1;
    private final Player player2;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        if (player1.getScoreIndex() < FORTY && player2.getScoreIndex() < FORTY) {
            return player1.getScore() + ", " + player2.getScore();

        } else if (Math.abs(player1.getScoreIndex() - player2.getScoreIndex()) == ADVANTAGE_DIFFERENCE) {
            Player leadPlayer = getLeadPlayer(player1, player2);
            return ADVANTAGE + " " + leadPlayer.getName();
        } else if (Math.abs(player1.getScoreIndex() - player2.getScoreIndex()) >= WINNER_DIFFERENCE) {
            Player getWinningPlayer = getWinner(player1, player2);
            return WINNER + " " + getWinningPlayer.getName();
        }

        return DEUCE;

    }

    private Player getLeadPlayer(Player player1, Player player2) {
        if (hasSameScore(player1, player2)) return null;

        return player1.getScoreIndex() > player2.getScoreIndex() ? player1 : player2;
    }

    private Player getWinner(Player player1, Player player2) {
        if (hasSameScore(player1, player2)) return null;

        return player1.getScoreIndex() > player2.getScoreIndex() ? player1 : player2;
    }

    private boolean hasSameScore(Player player1, Player player2) {
        return player1.getScoreIndex() == player2.getScoreIndex() ? true : false;
    }
}
