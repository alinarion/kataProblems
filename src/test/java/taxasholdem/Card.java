package taxasholdem;

public class Card {

    private final CardValue cardValue;
    private final CardColor cardColor;


    public Card(CardValue cardValue, CardColor cardColor) {
        this.cardValue = cardValue;
        this.cardColor = cardColor;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public String print() {
        return cardValue.getPrint() + cardColor.getPrint();
    }
}
