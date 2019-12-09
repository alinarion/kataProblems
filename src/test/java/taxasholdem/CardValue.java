package taxasholdem;

public enum CardValue {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private String print;

    CardValue(String print) {
        this.print = print;
    }

    public String getPrint(){
        return print;
    }

    public static CardValue getCardValueByPrint(String print){
        for(CardValue cardValue : values()){
            if(cardValue.getPrint().equals(print)){
                return cardValue;
            }
        }
        throw new IllegalArgumentException("bad argument " + print);
    }
}
