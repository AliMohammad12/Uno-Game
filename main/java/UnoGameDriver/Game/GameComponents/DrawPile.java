package UnoGameDriver.Game.GameComponents;
import UnoGameDriver.Game.Card.Card;

import java.util.List;
import java.util.Stack;

public class DrawPile {
    private Stack<Card> cards;
    public DrawPile(List<Card> cards) {
        this.cards = new Stack<>();
        this.cards.addAll(cards);
    }
    public void addCard(Card card) {
        cards.push(card);
    }
    public void addAll(List<Card> cards) {
        this.cards.addAll(cards);
    }
    public Card getTopCard() {
        return cards.pop();
    }
    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}
