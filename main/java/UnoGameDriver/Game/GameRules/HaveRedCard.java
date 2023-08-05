package UnoGameDriver.Game.GameRules;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Game;
import UnoGameDriver.Game.Player;

import java.util.List;

public class HaveRedCard extends GameRule {
    @Override
    protected boolean isViolated(Game game) {
        Player player = game.getCurrentPlayer();
        List<Card> playerCards = player.getPlayerHand();
        for(Card card : playerCards) {
            if (card.getCardColor() == CardColor.RED) return false;
        }
        return true;
    }

    @Override
    protected void penalty(Game game) {
        Player player = game.getCurrentPlayer();
        System.out.println(player.getName() + " is penalized for not having red card by drawing 1 card");
        game.makePlayerDraw(player);
    }
}
