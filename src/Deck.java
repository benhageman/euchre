import java.util.Collections;
import java.util.Vector;

public class Deck {
    Vector<Card> deckVec = new Vector<Card>();
    Integer numCards = 24, cardsLeft = numCards;



    Vector generateDeck()
    {
        // CLUBS
        Card cardC9 = new Card(1,9);    // 9 CLUBS
        Card cardC10 = new Card(1,10);   // 10 CLUBS
        Card cardC11 = new Card(1,11);   // JACK CLUBS
        Card cardC12 = new Card(1,12);   // QUEEN CLUBS
        Card cardC13 = new Card(1,13);   // KING CLUBS
        Card cardC14 = new Card(1,14);   // ACE CLUBS

            deckVec.add(cardC9);
            deckVec.add(cardC10);
            deckVec.add(cardC11);
            deckVec.add(cardC12);
            deckVec.add(cardC13);
            deckVec.add(cardC14);

        // DIAMONDS
        Card cardD9 = new Card(2,9);
        Card cardD10 = new Card(2,10);
        Card cardD11 = new Card(2,11);
        Card cardD12 = new Card(2,12);
        Card cardD13 = new Card(2,13);
        Card cardD14 = new Card(2,14);

            deckVec.add(cardD9);
            deckVec.add(cardD10);
            deckVec.add(cardD11);
            deckVec.add(cardD12);
            deckVec.add(cardD13);
            deckVec.add(cardD14);

        // HEART
        Card cardH9 = new Card(3,9);
        Card cardH10 = new Card(3,10);
        Card cardH11 = new Card(3,11);
        Card cardH12 = new Card(3,12);
        Card cardH13 = new Card(3,13);
        Card cardH14 = new Card(3,14);

            deckVec.add(cardH9);
            deckVec.add(cardH10);
            deckVec.add(cardH11);
            deckVec.add(cardH12);
            deckVec.add(cardH13);
            deckVec.add(cardH14);

        // SPADE
        Card cardS9 = new Card(4,9);
        Card cardS10 = new Card(4,10);
        Card cardS11 = new Card(4,11);
        Card cardS12 = new Card(4,12);
        Card cardS13 = new Card(4,13);
        Card cardS14 = new Card(4,14);

            deckVec.add(cardS9);
            deckVec.add(cardS10);
            deckVec.add(cardS11);
            deckVec.add(cardS12);
            deckVec.add(cardS13);
            deckVec.add(cardS14);

        /*System.out.println("---------------SHUFFLED DECK-------------");
        for(int z = 0; z < deckVec.size(); z++){
            deckVec.get(z).toString(deckVec.get(z));
        }
        */

        Collections.shuffle(deckVec);
        return deckVec;
    }

    Void printDeck(){
        for(int i = 0; i < deckVec.size(); i++){
            deckVec.get(i).toString(deckVec.get(i));
        }
        System.out.println("\n");
        return null;
    }

}