package UnoGameDriver.Game.Card.Action;

import UnoGameDriver.Game.Game;


public class Skip implements CardAction{
    @Override
    public void activateAction(Game game) {
        System.out.println("SKIPPING TURN");
        game.selectNextPlayerIndex();
    }

    @Override
    public String toString() {
        return "Skip";
    }
}
