package UnoGameDriver.Game.GameComponents;
import UnoGameDriver.Game.Card.Card;

import java.util.EmptyStackException;
import java.util.Stack;
public class DiscardPile {
    private Stack<Card> cards;
    public DiscardPile(Card card) {
        cards = new Stack<>();
        addCard(card);
    }
    public void addCard(Card card) {
        cards.push(card);
    }
    public Card peekTheTopCard() {
        if (cards.empty()) {
            throw new EmptyStackException();
        }
        return cards.peek();
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}
