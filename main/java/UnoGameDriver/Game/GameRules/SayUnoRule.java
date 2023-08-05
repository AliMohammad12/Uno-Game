package UnoGameDriver.Game.GameRules;

import UnoGameDriver.Game.Game;
import UnoGameDriver.Game.Player;

public class SayUnoRule extends GameRule {
    @Override
    protected boolean isViolated(Game game) {
        Player player = game.getCurrentPlayer();
        return !player.shoutUno() && player.getHandSize() == 1;
    }

    @Override
    protected void penalty(Game game) {
        Player player = game.getCurrentPlayer();
        System.out.println(player.getName() + " is penalized for not say UNO");
        game.makePlayerDraw(player);
    }
}
