package UnoGameDriver.Game.Card.Action;

import UnoGameDriver.Game.Game;

public class DrawTwoCards implements CardAction {
    @Override
    public void activateAction(Game game) {
        int cardPlayerIndex = game.getCurrentPlayerIndex();
        game.selectNextPlayerIndex();
        System.out.println(game.getCurrentPlayer().getName() + " IS DRAWING 2 CARDS");
        for (int i = 0; i < 2; i++) {
            game.getCurrentPlayer().drawCard(game.getDrawPile());
        }
        game.setCurrentPlayerIndex(cardPlayerIndex);
    }
    @Override
    public String toString() {
        return "DrawTwoCards";
    }
}
