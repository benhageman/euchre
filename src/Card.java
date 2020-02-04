import com.sun.jdi.IntegerValue;
import com.sun.jdi.TypeComponent;

import java.util.Comparator;

public class Card implements Comparable<Card>{
    private final Integer suit;      // 1 = diamond, 2 = club, 3 = heart, 4 = spade
    private final Integer value;
    private Integer power;



    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Card(int suitIn, int valueIn){
        suit = suitIn;
        value = valueIn;
        power = 0;
    }
    public int compareTo(Card other){
        //return suit.compareTo(other.suit);
        return Comparator.comparing(Card::getSuit).thenComparing(Card::getValue).thenComparing(Card::getPower).compare(this,other);
    }

    Integer getSuit(){
        return suit;
    }
    Integer getValue(){
        return value;
    }
    Integer getPower(){return power;}
    Void setPower(Integer p){
        power = p;
        return null;
    }

    String getFace(){
        if(value == 11)
            return "jack";
        else if(value == 12)
            return "queen";
        else if(value == 13)
            return "king";
        else if(value == 14)
            return "ace";
        else
            return String.valueOf(value);
    }
    String simpleGetFace(){
        String tColor;
        if(suit==1 | suit == 3){
            tColor = ANSI_RED;
        }else{tColor = "";}

        if(value == 11)
            return tColor + "J" + ANSI_RESET;
        else if(value == 12)
            return tColor + "Q" + ANSI_RESET;
        else if(value == 13)
            return tColor + "K" + ANSI_RESET;
        else if(value == 14)
            return tColor + "A" + ANSI_RESET;
        else
            return String.valueOf(value);
    }
    String suitToString(){
        if(suit == 1)
            return "diamond";
        else if(suit == 2)
            return "club";
        else if(suit == 3)
            return "heart";
        else // if suitIn == 4
            return "spade";
    }

    // Return symbol for card's suit
    String getSymbol(){
        if(suit == 1)
            return ANSI_RED + "♦" + ANSI_RESET;            //♦♢
        else if(suit == 2)
            return "♣";            //♣♧
        else if(suit == 3)
            return ANSI_RED + "♥" + ANSI_RESET;            //♥♡
        else // if suitIn == 4
            return "♠";            //♠♤

    }

    Integer toString(Card tempCard){
        System.out.println(tempCard.getFace()+ " " + tempCard.suitToString() + " " + tempCard.getSymbol());
        return 0;
    }

    void simpleToString(){
        System.out.println(simpleGetFace() + getSymbol());
    }

}
