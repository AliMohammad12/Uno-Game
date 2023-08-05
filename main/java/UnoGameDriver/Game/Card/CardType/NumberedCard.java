package UnoGameDriver.Game.Card.CardType;

import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;
import UnoGameDriver.Game.Collections.ThrowRules;

public class NumberedCard extends Card {
    public NumberedCard(CardNumber cardNumber, CardColor cardColor, CardAction cardAction) {
        super(cardNumber, cardColor, cardAction);
        addThrowRule(ThrowRules.sameNumberRule);
        addThrowRule(ThrowRules.sameColorRule);
        setCardType(CardType.NUMBERED);
        setCardScore(cardNumber.getValue());
    }

    @Override
    public String toString() {
        return "Card: " + cardNumber + " " + cardColor;
    }
}
