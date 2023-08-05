package UnoGameDriver.Game.DealingStrategy;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.CardDeck.CardDeck;
import UnoGameDriver.Game.Player;

import java.util.List;

public class StandardDealing implements DealingStrategy {
    private static final int DEFAULT_HAND_SIZE = 7;
    @Override
    public void dealCards(List<Player> players, CardDeck deck)  {
        for (Player player : players) {
            for (int i = 0; i < DEFAULT_HAND_SIZE; i++) {
                Card card = deck.drawCard();
                player.addCardToHand(card);
            }
        }
    }
}