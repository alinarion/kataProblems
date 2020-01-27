package com.cgm.poker;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TexasHoldEmGame {

    private Map<CardColor, List<Card>> colorCardMap;
    private Map<CardValue, List<Card>> valueCardMap;

    private Hand hand;

    public TexasHoldEmGame(Hand hand) {
        this.hand = hand;
        colorCardMap = hand.cards.stream().sorted(new CardComparator()).collect(Collectors.groupingBy(Card::getCardColor));
        valueCardMap = hand.cards.stream().sorted(new CardComparator()).collect(Collectors.groupingBy(Card::getCardValue));
    }

    public HandRanking rankTheHand() {

        if (royalFlush())
            return HandRanking.ROYAL_FLUSH;
        if (straightFlush()) {
            return HandRanking.STRAIGHT_FLUSH;
        }
        if (fourOfAKind()) {
            return HandRanking.FOUR_OF_A_KIND;
        }
        if (straight(hand.cards))
            return HandRanking.STRAIGHT;
        if (flush())
            return HandRanking.FLUSH;
        return HandRanking.HIGH_CARD;
    }

    private boolean fourOfAKind() {
        return valueCardMap.values().stream().anyMatch(cards -> cards.size() == 4);
    }

    private boolean straightFlush() {
        Set<CardColor> keySet = colorCardMap.keySet();
        //                cards.forEach(card -> {
//                    int index = cards.indexOf(card);
//                    if (cards.get(i + 1).isGreaterThen(cards.get(i), 1)) {
//                        dist++;
//                    } else {
//                        dist = 1;
//                    }
//                    if (dist == 5) {
//                        return true;
//                    }
//                });

        for (CardColor key : keySet) {
            List<Card> cards = colorCardMap.get(key);
            if (straight(cards)) {
                return true;
            }
        }
        return false;
    }

    private boolean straight(List<Card> cards) {
        if (cards.size() >= 5) {
            cards.sort(new CardComparator());
            int dist = 1;
            for (int i = 0; i < cards.size() - 1; i++) {
                if (cards.get(i + 1).isGreaterThen(cards.get(i), 1)) {
                    dist++;
                } else {
                    dist = 1;
                }
                if (dist == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean flush() {
        Set<CardColor> keySet = colorCardMap.keySet();
        for (CardColor key : keySet) {
            List<Card> cards = colorCardMap.get(key);
            if (cards.size() >= 5) {
                return true;
            }
        }
        return false;
    }


    private boolean royalFlush() {
        Set<CardColor> keySet = colorCardMap.keySet();
        for (CardColor key : keySet) {
            List<Card> cards = colorCardMap.get(key);
            if (cards.size() >= 5) {
                return cards.stream().filter(card -> card.getCardValue().getNumber() >= 10).count() == 5;
            }
        }
        return false;
    }

    private List<Integer> getCardsAsNumbers(Hand hand) {
        ArrayList<Integer> cardsAsNumbers = new ArrayList<>();
        hand.cards.forEach(card -> cardsAsNumbers.add(CardValue.getCardValueByPrint(card.getCardValue().getPrint()).getNumber()));

        return cardsAsNumbers;
    }

    private Hand orderDesc(Hand hand) {
        List<Card> orederedCards = new ArrayList<>(hand.cards);
        Collections.sort(orederedCards, new CardComparator());
        hand.cards = orederedCards;
        return hand;
    }
}
