package UnoGameDriver.Game.DealingStrategy;

import UnoGameDriver.Game.CardDeck.CardDeck;
import UnoGameDriver.Game.Player;

import java.util.List;

public interface DealingStrategy {
    void dealCards(List<Player> players, CardDeck deck);
}
