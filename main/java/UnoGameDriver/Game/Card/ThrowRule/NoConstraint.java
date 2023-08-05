package UnoGameDriver.Game.Card.ThrowRule;

import UnoGameDriver.Game.Card.Card;

public class NoConstraint implements ThrowRule {
    @Override
    public boolean canThrow(Card topCard, Card myCard){
        return true;
    }
    @Override
    public String toString() {
        return "NoConstraint";
    }
}
