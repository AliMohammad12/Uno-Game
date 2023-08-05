package UnoGameDriver.Game.CardDeck;

public class LuckyDeckFactory implements DeckFactory {
    @Override
    public CardDeck createDeck() {
        CardDeck deck = new LuckyDeck();
        deck.addCards();
        return deck;
    }
}
