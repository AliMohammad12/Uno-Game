package UnoGameDriver.Game.GameConfiguration;


public class GameConfigurator {
    private GameConfiguration gameConfiguration;
    public GameConfigurator() {
        gameConfiguration = new GameConfiguration();
    }
    public GameConfigurator setWinningScore(int winningScore) {
        gameConfiguration.setWinningScore(winningScore);
        return this;
    }
    public GameConfigurator setPlayCountPerTurn(int playCountPerTurn) {
        gameConfiguration.setPlayCountPerTurn(playCountPerTurn);
        return this;
    }
    public GameConfigurator setDrawCount(int drawCount) {
        gameConfiguration.setDrawCount(drawCount);
        return this;
    }
    public GameConfigurator setRemainingCardsToWin(int remainingCardsToWin) {
        gameConfiguration.setRemainingCardsToWin(remainingCardsToWin);
        return this;
    }
    public GameConfigurator setNextTurnCount(int nextTurnCount) {
        gameConfiguration.setNextTurnCount(nextTurnCount);
        return this;
    }
    public GameConfigurator setGameDirectionStart(GameDirection gameDirectionStart) {
        gameConfiguration.setGameDirectionStart(gameDirectionStart);
        return this;
    }
    public GameConfigurator setMaxNumOfPlayers(int maxNumOfPlayers) {
        gameConfiguration.setMaxNumOfPlayers(maxNumOfPlayers);
        return this;
    }
    public GameConfigurator setMinNumOfPlayers(int minNumOfPlayers) {
        gameConfiguration.setMinNumOfPlayers(minNumOfPlayers);
        return this;
    }
    public GameConfiguration build() {
        return gameConfiguration;
    }
}
