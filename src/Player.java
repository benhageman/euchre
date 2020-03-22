import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Player {
    Vector<Card> hand = new Vector<Card>();
    Integer numCardsPerHand = 6, numCards = 0;
    String name;
    Vector<Player> playerListVec = new Vector<Player>();
    Game game;
    Team team;
    boolean bidWon = false;
    int dCount = 0, cCount = 0, hCount = 0, sCount = 0;
    Scanner input = new Scanner(System.in);
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";



    public Player(String nameIn){
        name = nameIn;
    }
    Void setName(String nameIn){
        name = nameIn;
        return null;
    }

    String getName(){return name;}
    void setGame(Game g){game = g;}
    Game getGame(){return game;}
    void setTeam(Team t){team = t;}
    Team getTeam(){return team;}
    int getdCount(){return dCount;}
    void addMyDcount(){dCount++;}
    void subMyDcount(){dCount--;}
    int getcCount(){return cCount;}
    void addMyCcount(){cCount++;}
    void subMyCcount(){cCount--;}
    int gethCount(){return hCount;}
    void addMyHcount(){hCount++;}
    void subMyHcount(){hCount--;}
    int getsCount(){return sCount;}
    void addMyScount(){sCount++;}
    void subMyScount(){sCount--;}
    void setBidWon(){bidWon = true;}





    Void dealHand(Vector<Card> deck) {

        for (int i = 0; i < numCardsPerHand; i++) {
            Card temp = deck.get(0);
            if(temp.getSuit()==1){addMyDcount();}
            else if(temp.getSuit()==2){addMyCcount();}
            else if(temp.getSuit()==3){addMyHcount();}
            else if(temp.getSuit()==4){addMyScount();}
            hand.add(temp);
            numCards++;
            deck.remove(0);
        }
        Vector temp1 = hand;         // Sets temp vector to Player hand
        Collections.sort(temp1);        // Sort by suit, then value
        Collections.reverse(temp1);     // Reverse temp so high cards are to left
        hand = temp1;                // Set temp to hand
        return null;
    }

    void printHand() {
        //System.out.println("------------------------------");
        if (numCards == 6) {
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol() + ", " + hand.get(3).simpleGetFace() + hand.get(3).getSymbol() + ", " + hand.get(4).simpleGetFace() + hand.get(4).getSymbol() + ", " + hand.get(5).simpleGetFace() + hand.get(5).getSymbol());
        } else if (numCards == 5) {
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol() + ", " + hand.get(3).simpleGetFace() + hand.get(3).getSymbol() + ", " + hand.get(4).simpleGetFace() + hand.get(4).getSymbol());
        } else if (numCards == 4) {
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol() + ", " + hand.get(3).simpleGetFace() + hand.get(3).getSymbol());
        } else if (numCards == 3) {
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol());
        } else if (numCards == 2) {
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol());
        } else if (numCards == 1) {
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol());
        } else {
            System.out.println("Hand is empty.");
        }
    }

    void printHandWithName(String nameIn) {
        //System.out.println("------------------------------");

        if (numCards == 6) {
            System.out.println(getTeam().getColor() + nameIn + ANSI_RESET);
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol() + ", " + hand.get(3).simpleGetFace() + hand.get(3).getSymbol() + ", " + hand.get(4).simpleGetFace() + hand.get(4).getSymbol() + ", " + hand.get(5).simpleGetFace() + hand.get(5).getSymbol());
        } else if (numCards == 5) {
            System.out.println(nameIn);
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol() + ", " + hand.get(3).simpleGetFace() + hand.get(3).getSymbol() + ", " + hand.get(4).simpleGetFace() + hand.get(4).getSymbol());
        } else if (numCards == 4) {
            System.out.println(nameIn);
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol() + ", " + hand.get(3).simpleGetFace() + hand.get(3).getSymbol());
        } else if (numCards == 3) {
            System.out.println(nameIn);
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol() + ", " + hand.get(2).simpleGetFace() + hand.get(2).getSymbol());
        } else if (numCards == 2) {
            System.out.println(nameIn);
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol() + ", " + hand.get(1).simpleGetFace() + hand.get(1).getSymbol());
        } else if (numCards == 1) {
            System.out.println(nameIn);
            System.out.println(hand.get(0).simpleGetFace() + hand.get(0).getSymbol());
        } else {
            System.out.println(nameIn);
            System.out.println("Hand is empty.");
        }
    }

    void makeBid(int q, int s, Team thisTeam, Team otherTeam){
        if(game.checkBid(q,s,game.getCurRound().getBidQ(),game.getCurRound().getBidS(),thisTeam,otherTeam))
        {
            game.getCurRound().setCurrentBid(q,s);
        }
    }

    // Removes one from the count of suit in hand
    void updateCounts(int s) {
        if (s == 1)
            dCount--;
        else if (s == 2)
            cCount--;
        else if (s == 3)
            hCount--;
        else // if suitIn == 4
            sCount--;
    }

    void playCard(Vector cards, Round r){
        printHandWithName(name);
        System.out.println(ANSI_YELLOW + "Enter card to be played (1-6)." + ANSI_RESET);
        int cardNum = input.nextInt();
        cards.add(hand.get(cardNum-1));
        hand.remove(cardNum-1);
        System.out.println(r.getCardsPlayed());
    }
}