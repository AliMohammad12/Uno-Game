package UnoGameDriver.Game.GameRules;
import UnoGameDriver.Game.Game;

public abstract class GameRule {
    public void applyRule(Game game) {
        if (isViolated(game)) {
            penalty(game);
        }
    }
    protected abstract boolean isViolated(Game game);
    protected abstract void penalty(Game game);
}