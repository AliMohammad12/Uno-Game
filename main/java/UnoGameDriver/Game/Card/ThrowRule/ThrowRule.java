package UnoGameDriver.Game.Card.ThrowRule;

import UnoGameDriver.Game.Card.Card;

public interface ThrowRule {
    boolean canThrow(Card topCard, Card myCard);
}
