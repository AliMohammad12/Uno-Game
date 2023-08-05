package UnoGameDriver.Game.Card.CardType;

import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.Card;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;
import UnoGameDriver.Game.Collections.ThrowRules;

public class LuckyCard extends Card {
    public LuckyCard(CardNumber cardNumber, CardColor cardColor, CardAction cardAction) {
        super(cardNumber, cardColor, cardAction);
        addThrowRule(ThrowRules.sameColorRule);
        setCardType(CardType.LUCKYCARD);
    }

    @Override
    public String toString() {
        return "Lucky Card";
    }
}
