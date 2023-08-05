package UnoGameDriver.Game.Card.Action;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Game;
import UnoGameDriver.Game.Player;

public class PlayExtra implements CardAction {
    @Override
    public void activateAction(Game game) {
        Player player = game.getCurrentPlayer();
        if (game.canPlay()) {
            game.processTurn(player);
        } else {
           game.makePlayerDraw(player);
           if (game.canPlay()) game.processTurn(player);
        }
    }
}
