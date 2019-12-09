package taxasholdem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Hand {

    Collection<Card> cards;

    public Hand(String input) {
        cards = new ArrayList<>();
        String[] handStrings = input.split(" ");
        if(handStrings.length > 7){
            throw new IllegalArgumentException("bad");
        }
        for(String handString : handStrings){
            cards.add(parseCardString(handString));
        }
    }

    private Card parseCardString(String cardString){
        CardValue cardValue = CardValue.getCardValueByPrint(cardString.substring(0,1));
        CardColor cardColor = CardColor.getCardColorByPrint(cardString.substring(1));
        return new Card(cardValue,cardColor);
    }

    @Override
    public String toString(){
        return cards.stream().map(entry -> entry.print()).collect(Collectors.joining(" "));
    }
}
