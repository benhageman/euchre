import java.util.Vector;

public class Round {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private int suitLed;
    private int trump;
    private int txTrickCount;
    private int tyTrickCount;
    private int targetTrickCount;
    private int bidQ, bidS, numBids = 0;
    Game game;
    public Vector<Card> cardsPlayed = new Vector<Card>();


    public Round(Game g){
        game = g;
        g.x.bidWinner = false;
        g.y.bidWinner = false;
    }

    int getSuitLed(){return suitLed;}
    void setSuitLed(int s){
        suitLed = s;
    }
    int getTrump(){return trump;}
    int getTxTrickCount(){return txTrickCount;}
    int getTyTrickCount(){return tyTrickCount;}
    void add1txTrickCount(){
        txTrickCount++;
    }
    void add1tyTrickCount(){
        tyTrickCount++;
    }
    int getBidQ(){return bidQ;}
    int getBidS(){return bidS;}
    void setTargetTrickCount(int q){targetTrickCount=q;};
    int getTargetTrickCount(){return targetTrickCount;}

    void setCurrentBid(int q, int s){
        bidQ = q;
        bidS = s;
        numBids++;
        if(numBids == 4){
            trump = s;
            targetTrickCount = q;
        }
    }

    void printCurrentBid(){
        System.out.println("Current bid is: " + bidQ + suitToSymbol(bidS));
    }
    void printWinningBid(){
        System.out.println(ANSI_YELLOW + "WINNING BID: " + ANSI_RESET + bidQ + suitToSymbol(bidS));
    }


    void updateScore(){
        if(txTrickCount == 6){
            game.addTXpoint();
            game.addTXpoint();
        }
        else if(tyTrickCount == 6){
            game.addTYpoint();
            game.addTYpoint();
        }

    }
    String suitToSymbol(int suit){
        if(suit == 1)
            return ANSI_RED + "♦" + ANSI_RESET;            //♦♢
        else if(suit == 2)
            return "♣";            //♣♧
        else if(suit == 3)
            return ANSI_RED + "♥" + ANSI_RESET;            //♥♡
        else if(suit == 4)
            return "♠";            //♠♤
        else if(suit == 0)
            return "▼";
        else if(suit == 5)
            return "▲";
        else
            return "Not a suit.";
    }

    String getCardsPlayed(){
        String retString = "";
        for(int i = 0; i < cardsPlayed.size(); i++){
            retString += cardsPlayed.get(i).simpleGetFace() + cardsPlayed.get(i).getSymbol() + "  ";
        }
        return ANSI_YELLOW + "CARDS ON TABLE: " + ANSI_RESET + retString;
    }

}
