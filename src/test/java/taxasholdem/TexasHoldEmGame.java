package taxasholdem;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TexasHoldEmGame {

    private Map<CardColor, List<Card>> colorCardMap;
    private Hand hand;

    public TexasHoldEmGame(Hand hand) {
        this.hand = hand;
        colorCardMap = hand.cards.stream().sorted(new CardComparator()).collect(Collectors.groupingBy(Card::getCardColor));
    }

    public HandRanking rankTheHand() {

        if (royalFlush())
            return HandRanking.ROYAL_FLUSH;
        if (straight())
            return HandRanking.STRAIGHT;
        if (flush())
            return HandRanking.FLUSH;
        return HandRanking.HIGH_CARD;
    }

    private boolean flush() {
        return false;
    }


    private boolean straight() {
        return false;
    }

    private boolean royalFlush() {
        List<Integer> royalFlushHand = Arrays.asList(10, 11, 12, 13, 14);
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
