package UnoGameDriver.Game.GameConfiguration;

public class GameConfiguration {
    private int winningScore;
    private int playCountPerTurn;
    private int drawCount;
    private int remainingCardsToWin;
    private int nextTurnCount;
    private GameDirection gameDirectionStart;
    private int maxNumOfPlayers;
    private int minNumOfPlayers;
    public int getWinningScore() {
        return winningScore;
    }
    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }
    public int getPlayCountPerTurn() {
        return playCountPerTurn;
    }
    public void setPlayCountPerTurn(int playCountPerTurn) {
        this.playCountPerTurn = playCountPerTurn;
    }
    public int getDrawCount() {
        return drawCount;
    }
    public void setDrawCount(int drawCount) {
        this.drawCount = drawCount;
    }
    public int getRemainingCardsToWin() {
        return remainingCardsToWin;
    }
    public void setRemainingCardsToWin(int remainingCardsToWin) {
        this.remainingCardsToWin = remainingCardsToWin;
    }
    public int getNextTurnCount() {
        return nextTurnCount;
    }
    public void setNextTurnCount(int nextTurnCount) {
        this.nextTurnCount = nextTurnCount;
    }
    public GameDirection getGameDirectionStart() {
        return gameDirectionStart;
    }
    public void setGameDirectionStart(GameDirection gameDirectionStart) {
        this.gameDirectionStart = gameDirectionStart;
    }
    public int getMaxNumOfPlayers() {
        return maxNumOfPlayers;
    }
    public void setMaxNumOfPlayers(int maxNumOfPlayers) {
        this.maxNumOfPlayers = maxNumOfPlayers;
    }
    public int getMinNumOfPlayers() {
        return minNumOfPlayers;
    }
    public void setMinNumOfPlayers(int minNumOfPlayers) {
        this.minNumOfPlayers = minNumOfPlayers;
    }
}