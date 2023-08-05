package UnoGameDriver.Game.ShufflingStrategy;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.CardDeck.CardDeck;

import java.util.List;

public class FaroShuffling implements ShufflingStrategy {
    @Override
    public void shuffle(CardDeck deck) {
        List<Card> cards = deck.getCards();
        int n = cards.size();
        int half = n / 2;
        List<Card> leftHalf = cards.subList(0, half);
        List<Card> rightHalf = cards.subList(half, n);
        for (int i = 0; i < half; i++) {
            cards.set(2 * i, rightHalf.get(i));
            cards.set(2 * i + 1, leftHalf.get(i));
        }
    }
}