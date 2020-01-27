package com.cgm.poker;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    public CardComparator() {
    }

    @Override
    public int compare(Card card1, Card card2) {
        return CardValue.getCardValueByPrint(card2.getCardValue().getPrint()).getNumber().compareTo(CardValue.getCardValueByPrint(card1.getCardValue().getPrint()).getNumber());
    }

}
