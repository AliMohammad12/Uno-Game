package UnoGameDriver.Game.Card.Action;

public class ActionFactory {
    public CardAction createAction(ActionType actionType) {
        switch (actionType) {
            case REVERSE:
                return new Reverse();
            case DRAWTWO:
                return new DrawTwoCards();
            case NOACTION:
                return new NoAction();
            case SKIP:
                return new Skip();
            case CHANGE_COLOR:
                return new ChangeColor();
            default:
                throw new IllegalArgumentException("Invalid action type: " + actionType);
        }
    }
}
