package taxasholdem;

public enum CardValue {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    private String print;
    private Integer number;

    CardValue(String print, Integer number) {
        this.print = print;
        this.number = number;
    }

    public String getPrint() {
        return print;
    }

    public Integer getNumber() {
        return number;
    }

    public static CardValue getCardValueByPrint(String print) {
        for (CardValue cardValue : values()) {
            if (cardValue.getPrint().equals(print)) {
                return cardValue;
            }
        }
        throw new IllegalArgumentException("bad argument " + print);
    }
}
