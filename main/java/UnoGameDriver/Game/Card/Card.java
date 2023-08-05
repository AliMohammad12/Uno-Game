package UnoGameDriver.Game.Card;

import UnoGameDriver.Game.Card.CardType.CardType;
import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.ThrowRule.ThrowRule;

import java.util.ArrayList;
import java.util.List;

public abstract class Card {
    protected List<ThrowRule> throwRules;
    protected CardNumber cardNumber;
    protected CardColor cardColor;
    protected CardAction cardAction;
    protected CardType cardType;
    protected int cardScore;

    public Card(CardNumber cardNumber, CardColor cardColor, CardAction cardAction) {
        this.cardNumber = cardNumber;
        this.cardColor = cardColor;
        this.cardAction = cardAction;
        throwRules = new ArrayList<>();
        cardScore = 0;
    }
    public boolean canThrowAbove(Card topCard) {
        for (ThrowRule rule : throwRules) {
            if (rule.canThrow(topCard, this)) {
                return true;
            }
        }
        return false;
    }

    public CardAction getCardAction() {
        return cardAction;
    }

    public void setCardAction(CardAction cardAction) {
        this.cardAction = cardAction;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    public List<ThrowRule> getDrawRules() {
        return throwRules;
    }

    public void setDrawRules(List<ThrowRule> throwRules) {
        this.throwRules = throwRules;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getCardScore() {
        return cardScore;
    }

    public void setCardScore(int cardScore) {
        this.cardScore = cardScore;
    }

    public void addThrowRule(ThrowRule throwRule) {
        throwRules.add(throwRule);
    }

}
