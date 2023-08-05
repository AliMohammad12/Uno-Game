package UnoGameDriver.Game.Card.ThrowRule;

import UnoGameDriver.Game.Card.Card;

public class SameNumber implements ThrowRule {
    @Override
    public boolean canThrow(Card topCard, Card myCard) {
        return topCard.getCardNumber() == myCard.getCardNumber();
    }
    @Override
    public String toString() {
        return "SameNumber";
    }
}

