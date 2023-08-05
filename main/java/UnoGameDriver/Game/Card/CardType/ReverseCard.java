package UnoGameDriver.Game.Card.CardType;

import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;
import UnoGameDriver.Game.Collections.ThrowRules;
import UnoGameDriver.Game.Card.Action.CardAction;
;


public class ReverseCard extends Card {
    public ReverseCard(CardNumber cardNumber, CardColor cardColor, CardAction cardAction) {
        super(cardNumber, cardColor, cardAction);
        addThrowRule(ThrowRules.sameActionRule);
        addThrowRule(ThrowRules.sameColorRule);
        setCardType(CardType.REVERSE);
        setCardScore(20);
    }
    @Override
    public String toString() {
        return "RCard: " + cardType + " " + cardColor;
    }
}
