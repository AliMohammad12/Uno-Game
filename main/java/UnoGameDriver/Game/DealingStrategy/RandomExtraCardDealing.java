package UnoGameDriver.Game.DealingStrategy;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.CardDeck.CardDeck;
import UnoGameDriver.Game.Player;

import java.util.List;

public class RandomExtraCardDealing implements DealingStrategy {
    private static final int DEFAULT_HAND_SIZE = 6;
    private static final int NUMBER_OF_LUCKY_CARDS = 2;
    @Override
    public void dealCards(List<Player> players, CardDeck deck)  {
        int extraCardsDealt = 0;
        for (Player player : players) {
            for (int i = 0; i < DEFAULT_HAND_SIZE; i++) {
                Card card = deck.drawCard();
                player.addCardToHand(card);
                if (canPlayerGetExtraCard(extraCardsDealt)) {
                    player.addCardToHand(card);
                    extraCardsDealt++;
                }
            }
        }
    }
    public boolean canPlayerGetExtraCard(int extraCardsDealt) {
        return Math.random() > 0.5 && extraCardsDealt < NUMBER_OF_LUCKY_CARDS;
    }
}
