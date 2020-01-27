package taxasholdem;

import com.cgm.poker.Card;
import com.cgm.poker.CardColor;
import com.cgm.poker.CardValue;
import com.cgm.poker.Hand;
import com.cgm.poker.HandRanking;
import com.cgm.poker.TexasHoldEmGame;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TexasHoldEmTest {
    private TexasHoldEmGame texasHoldEmGame;
    private Card card;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void cardTest() {
        card = new Card(CardValue.KING, CardColor.CLUBS);
        assertEquals(card.print(), "Kc");
    }

    @Test
    public void handTest() {
        String handTestInput = "Kc 9s Ks Kd 9d 3c 6d";
        Hand hand = new Hand(handTestInput);
        assertEquals(hand.toString(), handTestInput);
    }

    @Test
    public void givenHandValidateIsRoyalFlush() {
        String handTestInput = "Ts Ks Qs Js As Ad Ac";
        Hand hand = new Hand(handTestInput);
        texasHoldEmGame = new TexasHoldEmGame(hand);
        assertEquals(HandRanking.ROYAL_FLUSH,texasHoldEmGame.rankTheHand());
    }
    @Test
    public void givenHandValidateIsStraightFlush() {
        String handTestInput = "Tc Ks Qs Js 9s Ts Ac";
        Hand hand =new Hand(handTestInput);
        texasHoldEmGame=new TexasHoldEmGame(hand);
        assertEquals(HandRanking.STRAIGHT_FLUSH,texasHoldEmGame.rankTheHand());
    }

    @Test
    public void givenHandValidateIsStraight() {
        String handTestInput = "Td Kc Qs Js 9s Ad Ac";
        Hand hand = new Hand(handTestInput);
        texasHoldEmGame = new TexasHoldEmGame(hand);
        assertEquals(HandRanking.STRAIGHT, texasHoldEmGame.rankTheHand());
    }
    @Test
    public void givenHandValidateIsFlush() {
        String handTestInput = "Ts Kc 2s Js 9s As Ac";
        Hand hand = new Hand(handTestInput);
        texasHoldEmGame = new TexasHoldEmGame(hand);
        assertEquals(HandRanking.FLUSH, texasHoldEmGame.rankTheHand());
    }
    @Test
    public void givenHandValidateIsFourOfAKind() {
        String handTestInput = "Ad Ac 2s Js 9s As Ah";
        Hand hand = new Hand(handTestInput);
        texasHoldEmGame = new TexasHoldEmGame(hand);
        assertEquals(HandRanking.FOUR_OF_A_KIND, texasHoldEmGame.rankTheHand());
    }
}
