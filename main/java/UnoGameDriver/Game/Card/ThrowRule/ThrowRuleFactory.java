package UnoGameDriver.Game.Card.ThrowRule;

public class ThrowRuleFactory {
    public ThrowRule createThrowingRule(ThrowRuleType throwRule) {
        switch (throwRule) {
            case NoConstraints:
                return new NoConstraint();
            case SameAction:
                return new SameAction();
            case SameColor:
                return new SameColor();
            case SameNumber:
                return new SameNumber();
            default:
                throw new IllegalArgumentException("Invalid throwing rule type: " + throwRule);
        }
    }
}

