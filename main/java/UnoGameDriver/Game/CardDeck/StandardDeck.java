package UnoGameDriver.Game.CardDeck;

import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Card.CardNumber;
import UnoGameDriver.Game.Card.CardType.*;
import UnoGameDriver.Game.Collections.CardActions;
public class StandardDeck extends CardDeck {
    @Override
    public void addCards() {
        addActionCards();
        addNumberedCards();
        addWildCards();
    }
    private void addNumberedCards() {
        for (int cardNumber = 0; cardNumber <= 10; cardNumber++) {
          for (int count = 0; count < 2 - (cardNumber == 0?1:0); count++) {
              cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.RED, CardActions.noAction));
              cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.BLUE, CardActions.noAction));
              cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.YELLOW, CardActions.noAction));
              cards.add(new NumberedCard(CardNumber.value(cardNumber), CardColor.GREEN, CardActions.noAction));
          }
        }
    }
    private void addActionCards() {
        for (int count = 0; count < 2; count++) {
            cards.add(new ReverseCard(CardNumber.NUMBERLESS, CardColor.RED, CardActions.reverseAction));
            cards.add(new ReverseCard(CardNumber.NUMBERLESS, CardColor.BLUE, CardActions.reverseAction));
            cards.add(new ReverseCard(CardNumber.NUMBERLESS, CardColor.YELLOW, CardActions.reverseAction));
            cards.add(new ReverseCard(CardNumber.NUMBERLESS, CardColor.GREEN, CardActions.reverseAction));

            cards.add(new SkipCard(CardNumber.NUMBERLESS, CardColor.RED, CardActions.skipAction));
            cards.add(new SkipCard(CardNumber.NUMBERLESS, CardColor.BLUE, CardActions.skipAction));
            cards.add(new SkipCard(CardNumber.NUMBERLESS, CardColor.YELLOW, CardActions.skipAction));
            cards.add(new SkipCard(CardNumber.NUMBERLESS, CardColor.GREEN, CardActions.skipAction));

            cards.add(new DrawTwoCard(CardNumber.NUMBERLESS, CardColor.RED, CardActions.drawTwoCardsAction));
            cards.add(new DrawTwoCard(CardNumber.NUMBERLESS, CardColor.BLUE, CardActions.drawTwoCardsAction));
            cards.add(new DrawTwoCard(CardNumber.NUMBERLESS, CardColor.YELLOW, CardActions.drawTwoCardsAction));
            cards.add(new DrawTwoCard(CardNumber.NUMBERLESS, CardColor.GREEN, CardActions.drawTwoCardsAction));
        }
    }

    private void addWildCards() {
        for (int count = 0; count < 4; count++) {
            cards.add(new WildCard(CardNumber.NUMBERLESS, CardColor.COLORLESS, CardActions.changeColorAction));
        }
    }

}
