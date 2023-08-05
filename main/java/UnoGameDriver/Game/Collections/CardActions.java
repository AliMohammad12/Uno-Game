package UnoGameDriver.Game.Collections;

import UnoGameDriver.Game.Card.Action.ActionType;
import UnoGameDriver.Game.Card.Action.CardAction;
import UnoGameDriver.Game.Card.Action.ActionFactory;

public class CardActions {
    private static ActionFactory actionFactory = new ActionFactory();
    public static CardAction noAction = actionFactory.createAction(ActionType.NOACTION);
    public static CardAction drawTwoCardsAction = actionFactory.createAction(ActionType.DRAWTWO);
    public static CardAction skipAction = actionFactory.createAction(ActionType.SKIP);
    public static CardAction reverseAction = actionFactory.createAction(ActionType.REVERSE);
    public static CardAction changeColorAction = actionFactory.createAction(ActionType.CHANGE_COLOR);
}
