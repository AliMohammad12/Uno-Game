package UnoGameDriver.Game.CardDeck;
import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.ShufflingStrategy.ShufflingStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class CardDeck {
    protected final List<Card> cards;

    public CardDeck() {
        cards = new ArrayList<>();
    }
    public abstract void addCards();
    public void shuffleDeck(ShufflingStrategy shufflingStrategy) {
        shufflingStrategy.shuffle(this);
    }
    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new RuntimeException("The deck is empty!");
        }
        return cards.remove(0);
    }
    public boolean isDeckEmpty() {
        return cards.isEmpty();
    }
    public List<Card> getCards() { return cards; }


    @Override
    public String toString() {
        return "CardDeck{" +
                "cards=" + cards +
                '}';
    }
}


