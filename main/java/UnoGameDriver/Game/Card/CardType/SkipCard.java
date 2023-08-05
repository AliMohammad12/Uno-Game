package UnoGameDriver.Game.Card.CardType;

import UnoGameDriver.Game.Collections.ThrowRules;
import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;

public class SkipCard extends Card {
    public SkipCard(CardNumber cardNumber, CardColor cardColor, CardAction cardAction) {
        super(cardNumber, cardColor, cardAction);
        addThrowRule(ThrowRules.sameActionRule);
        addThrowRule(ThrowRules.sameColorRule);
        setCardType(CardType.SKIP);
        setCardScore(20);
    }
    @Override
    public String toString() {
        return "SCard: " + cardType + " " + cardColor;
    }
}
