package UnoGameDriver.Game.Card.Action;

import UnoGameDriver.Game.Game;

public class NoAction implements CardAction {
    @Override
    public void activateAction(Game game) {}
    @Override
    public String toString() {
      return "NoAction";
    }
}
