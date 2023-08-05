package UnoGameDriver.Game.Card.ThrowRule;

import UnoGameDriver.Game.Card.Card;

public class SameColor implements ThrowRule {
    @Override
    public boolean canThrow(Card topCard, Card myCard) {
        return topCard.getCardColor() == myCard.getCardColor();
    }

    @Override
    public String toString() {
        return "SameColor";
    }
}
