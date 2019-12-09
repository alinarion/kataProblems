package taxasholdem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TexasHoldEmTest {
    private TexasHoldEmGame texasHoldEmGame;
    private Card card;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void cardTest() {
        card = new Card(CardValue.KING,CardColor.CLUBS);
        assertEquals(card.print(),"Kc");
    }

    @Test
    public void handTest() {
        String handTestInput = "Kc 9s Ks Kd 9d 3c 6d";
        Hand hand = new Hand(handTestInput);
        assertEquals(hand.toString(),handTestInput);
    }


}
