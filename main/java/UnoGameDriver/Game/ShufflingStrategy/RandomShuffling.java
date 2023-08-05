package UnoGameDriver.Game.ShufflingStrategy;

import UnoGameDriver.Game.CardDeck.CardDeck;

import java.util.Collections;

public class RandomShuffling implements ShufflingStrategy {
    @Override
    public void shuffle(CardDeck deck) {
        Collections.shuffle(deck.getCards());
    }
}
