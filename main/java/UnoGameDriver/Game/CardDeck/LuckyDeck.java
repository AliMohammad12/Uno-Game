package UnoGameDriver.Game.CardDeck;

import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.Action.PlayExtra;
import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;
import UnoGameDriver.Game.Card.CardType.LuckyCard;
import UnoGameDriver.Game.Card.CardType.NumberedCard;
import UnoGameDriver.Game.Collections.CardActions;

public class LuckyDeck extends CardDeck {
    @Override
    public void addCards() {
        addLuckyCards();
        addNumberedCards();
    }
    void addLuckyCards() {
        CardAction playExtra = new PlayExtra();
        for (int i = 0; i < 10; i++) {
            cards.add(new LuckyCard(CardNumber.NUMBERLESS, CardColor.RED, playExtra));
        }
    }

    private void addNumberedCards() {
        for (int cardNumber = 0; cardNumber <= 2; cardNumber++) {
            cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.RED, CardActions.noAction));
            cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.BLUE, CardActions.noAction));
            cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.YELLOW, CardActions.noAction));
            cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.GREEN, CardActions.noAction));
        }
    }
}
