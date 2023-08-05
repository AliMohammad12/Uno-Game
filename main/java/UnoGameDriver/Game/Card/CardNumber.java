package UnoGameDriver.Game.Card;

public enum CardNumber {
    ZERO(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),
    SEVEN(7),EIGHT(8),NINE(9),TEN(10),ELEVEN(11),TWELVE(12),THIRTEEN(13),FOURTEEN(14)
    ,FIFTEEN(15),SIXTEEN(16),SEVENTEEN(17),NINETEEN(18),TWENTY(19), NUMBERLESS(20);

    private final int value;
    private static final CardNumber[] values = values();
    public static CardNumber value(int value) {
        if (value < 0 || value > values.length) {
            throw new IllegalArgumentException("Invalid value: " + value);
        }
        return values[value];
    }
    CardNumber(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
