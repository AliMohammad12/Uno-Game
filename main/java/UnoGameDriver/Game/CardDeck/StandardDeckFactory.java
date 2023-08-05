package UnoGameDriver.Game.CardDeck;

public class StandardDeckFactory implements DeckFactory {
    @Override
    public CardDeck createDeck() {
        CardDeck deck = new StandardDeck();
        deck.addCards();
        return deck;
    }
}
