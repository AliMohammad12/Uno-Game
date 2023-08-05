package UnoGameDriver.Game.Card.Action;

import UnoGameDriver.Game.Collections.CardActions;
import UnoGameDriver.Game.Game;
import UnoGameDriver.Game.GameConfiguration.GameDirection;

public class Reverse implements CardAction {
    @Override
    public void activateAction(Game game) {
        if (game.getNumberOfPlayers() == 2) {
            CardActions.skipAction.activateAction(game);
        } else {
          System.out.println("GAME DIRECTION CHANGED");
          GameDirection currentGameDirection = game.getCurrentGameDirection();
          if (currentGameDirection == GameDirection.CLOCKWISE) {
            game.setCurrentGameDirection(GameDirection.COUNTER_CLOCKWISE);
          } else {
            game.setCurrentGameDirection(GameDirection.CLOCKWISE);
          }
        }
    }

    @Override
    public String toString() {
        return "Reverse";
    }
}
