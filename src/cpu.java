import java.util.Vector;

public class cpu {
    Vector<Card> hand = new Vector<Card>();
    Integer numCardsPerHand = 6, numCards = 6;
    String name;
    Player inhPlayer;
    Game game;
    Team cpuTeam;
    public cpu(Player p, Game g, Team t){

        inhPlayer = p;
        hand = p.hand;
        game = g;
        cpuTeam = t;
    }

    void firstAutoBid(){    // Bids the quantity of the suit they have the most of
        if(inhPlayer.dCount >= inhPlayer.cCount & inhPlayer.dCount >= inhPlayer.sCount & inhPlayer.dCount >= inhPlayer.hCount){
            game.getCurRound().setCurrentBid(inhPlayer.dCount,1);
        }
        else if(inhPlayer.cCount >= inhPlayer.dCount & inhPlayer.cCount >= inhPlayer.sCount & inhPlayer.cCount >= inhPlayer.hCount){
            game.getCurRound().setCurrentBid(inhPlayer.cCount,2);
        }
        else if(inhPlayer.hCount >= inhPlayer.dCount & inhPlayer.hCount >= inhPlayer.sCount & inhPlayer.hCount >= inhPlayer.cCount){
            game.getCurRound().setCurrentBid(inhPlayer.hCount,3);
        }
        else if(inhPlayer.sCount >= inhPlayer.dCount & inhPlayer.sCount >= inhPlayer.cCount & inhPlayer.sCount >= inhPlayer.hCount){
            game.getCurRound().setCurrentBid(inhPlayer.sCount,4);
        }
    }

    void computerBid(){
        if(inhPlayer.dCount >= inhPlayer.cCount & inhPlayer.dCount >= inhPlayer.sCount & inhPlayer.dCount >= inhPlayer.hCount){
            if(game.checkBid(inhPlayer.dCount,1, game.getCurRound().getBidQ(),game.getCurRound().getBidS(),cpuTeam))
            {
                game.getCurRound().setCurrentBid(inhPlayer.dCount,1);
            }

        }
        else if(inhPlayer.cCount >= inhPlayer.dCount & inhPlayer.cCount >= inhPlayer.sCount & inhPlayer.cCount >= inhPlayer.hCount){
            if(game.checkBid(inhPlayer.cCount,2, game.getCurRound().getBidQ(),game.getCurRound().getBidS(),cpuTeam))
            {
                game.getCurRound().setCurrentBid(inhPlayer.cCount,2);
            }
        }
        else if(inhPlayer.hCount >= inhPlayer.dCount & inhPlayer.hCount >= inhPlayer.sCount & inhPlayer.hCount >= inhPlayer.cCount){
            if(game.checkBid(inhPlayer.hCount,3, game.getCurRound().getBidQ(),game.getCurRound().getBidS(),cpuTeam))
            {
                game.getCurRound().setCurrentBid(inhPlayer.hCount,3);
            }
        }
        else if(inhPlayer.sCount >= inhPlayer.dCount & inhPlayer.sCount >= inhPlayer.cCount & inhPlayer.sCount >= inhPlayer.hCount){
            if(game.checkBid(inhPlayer.sCount,4, game.getCurRound().getBidQ(),game.getCurRound().getBidS(),cpuTeam))
            {
                game.getCurRound().setCurrentBid(inhPlayer.sCount,3);
            }
        }
    }

    // Finds lowest card and removes from hand
    Card findLow(int n){
        int lowVal = 15;
        int tracker = 0;
        for(int i = 0; i < numCards; i++){
            if(hand.get(i).getValue() < lowVal){
                lowVal = hand.get(i).getValue();
                tracker = i;
            }
        }
        Card retCard = new Card((hand.get(tracker).getSuit()),hand.get(tracker).getValue());
        hand.remove(tracker);
        numCards--;
        inhPlayer.numCards--;
        return retCard;
    }

    // Finds highest card and removes from hand
    Card findHigh(int n){
        int highVal = 8;
        int tracker = 0;
        for(int i = 0; i < numCards; i++){
            if(hand.get(i).getValue() > highVal){
                highVal = hand.get(i).getValue();
                tracker = i;
            }
        }
        Card retCard = new Card((hand.get(tracker).getSuit()),hand.get(tracker).getValue());
        hand.remove(tracker);
        numCards--;
        inhPlayer.numCards--;
        return retCard;
    }

    // Follows high
    Card followHigh(int n){
        int highVal = 8;
        int tracker = 0;
        for(int i = 0; i < numCards; i++){
            if(hand.get(i).getSuit() == game.getCurRound().getSuitLed() & hand.get(i).getValue() > highVal){
                highVal = hand.get(i).getValue();
                tracker = i;
            }
        }
        if(highVal == 8){
            Card retCard = findLow(numCards);
            return retCard;
        }
        Card retCard = new Card((hand.get(tracker).getSuit()),hand.get(tracker).getValue());
        hand.remove(tracker);
        numCards--;
        inhPlayer.numCards--;


        return retCard;
    }

    // If low, leads low, else leads highest card
    void lead(){
        System.out.print(inhPlayer.name + ": ");
        int tempS = game.getCurRound().getBidS();
        int cardSuit=0;
        Card tempC;
        if (tempS == 0){                            // LOW
            tempC = findLow(numCards);
            cardSuit = tempC.getSuit();
            tempC.simpleToString();
        }
        else{
            tempC = findHigh(numCards);
            cardSuit = tempC.getSuit();
            tempC.simpleToString();
        }
        game.getCurRound().setSuitLed(cardSuit);
        inhPlayer.updateCounts(tempC.getSuit());
    }

    // Follows the suit led
    void follow(){
        System.out.print(inhPlayer.name + ": ");
        int tempS =  game.getCurRound().getSuitLed();
        Card tempCard = followHigh(numCards);
        tempCard.simpleToString();
        inhPlayer.updateCounts(tempCard.getSuit());
    }

}
