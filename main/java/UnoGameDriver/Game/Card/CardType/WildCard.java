package UnoGameDriver.Game.Card.CardType;

import UnoGameDriver.Game.Collections.ThrowRules;
import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;

public class WildCard extends Card {
    public WildCard(CardNumber cardNumber, CardColor cardColor, CardAction cardAction) {
        super(cardNumber, cardColor, cardAction);
        addThrowRule(ThrowRules.NoConstraintRule);
        setCardType(CardType.WILD);
        setCardScore(50);
    }

    @Override
    public String toString() {
        return "WCard: " + cardType;
    }
}
