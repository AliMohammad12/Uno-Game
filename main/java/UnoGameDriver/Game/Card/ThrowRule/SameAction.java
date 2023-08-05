package UnoGameDriver.Game.Card.ThrowRule;

import UnoGameDriver.Game.Card.Card;

public class SameAction implements ThrowRule {
    @Override
    public boolean canThrow(Card topCard, Card myCard) {
        return topCard.getCardAction() == myCard.getCardAction();
    }

    @Override
    public String toString() {
        return "SameAction";
    }
}
