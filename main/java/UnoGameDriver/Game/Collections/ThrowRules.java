package UnoGameDriver.Game.Collections;

import UnoGameDriver.Game.Card.ThrowRule.ThrowRuleType;
import UnoGameDriver.Game.Card.ThrowRule.ThrowRule;
import UnoGameDriver.Game.Card.ThrowRule.ThrowRuleFactory;

public class ThrowRules {
    private static ThrowRuleFactory throwRuleFactory = new ThrowRuleFactory();
    public static ThrowRule NoConstraintRule = throwRuleFactory.createThrowingRule(ThrowRuleType.NoConstraints);
    public static ThrowRule sameActionRule = throwRuleFactory.createThrowingRule(ThrowRuleType.SameAction);
    public static ThrowRule sameNumberRule = throwRuleFactory.createThrowingRule(ThrowRuleType.SameNumber);
    public static ThrowRule sameColorRule = throwRuleFactory.createThrowingRule(ThrowRuleType.SameColor);
}
