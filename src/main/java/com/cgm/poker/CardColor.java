package com.cgm.poker;

public enum CardColor {
    CLUBS("c"),
    DIAMONDS("d"),
    HEARTS("h"),
    SPADES("s");

    private String print;

    CardColor(String print) {
        this.print = print;
    }

    public String getPrint(){
        return print;
    }

    public static CardColor getCardColorByPrint(String print){
        for(CardColor cardColor : values()){
            if(cardColor.getPrint().equals(print)){
                return cardColor;
            }
        }
        throw new IllegalArgumentException("bad argument " + print);
    }
}
