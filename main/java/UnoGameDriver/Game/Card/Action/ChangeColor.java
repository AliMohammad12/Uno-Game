package UnoGameDriver.Game.Card.Action;

import UnoGameDriver.Game.Card.CardColor;
import UnoGameDriver.Game.Game;

import java.util.Scanner;

public class ChangeColor implements CardAction {
    @Override
    public void activateAction(Game game) {
        System.out.println(game.getCurrentPlayer().getName() + " please select next play color: ");
        Scanner scan = new Scanner(System.in);
        String color = scan.next();
        game.setCurrentColor(CardColor.valueOf(color));
    }
    @Override
    public String toString() {
        return "ChangeColor";
    }
}
