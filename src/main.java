import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;



public class main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int quant=0, suit=0;
        final String ANSI_RESET = "\u001B[0m";

        Deck deck1 = new Deck();
        deck1.generateDeck();

        // Create player objects
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
        Player p4 = new Player("Player 4");

        //System.out.println("-----Shuffled Deck-----");
        //deck1.printDeck();
        //System.out.println("-----------------------");

        Team team1 = new Team(p1,p3,"RED");
        Team team2 = new Team(p2,p4,"BLUE");
        Game game1 = new Game(team1, team2, 10);
        p1.setGame(game1);
        p1.setTeam(team1);

        /*p1.dealHand(deck1.deckVec);
        p2.dealHand(deck1.deckVec);
        p3.dealHand(deck1.deckVec);
        p4.dealHand(deck1.deckVec);

        // Prints sorted first hand for each player
        p1.printHandWithName(p1.name);
        p2.printHandWithName(p2.name);
        p3.printHandWithName(p3.name);
        p4.printHandWithName(p4.name);
        System.out.println("\n");*/

        cpu cpu1 = new cpu(p2, game1,team1);
        cpu cpu2 = new cpu(p3, game1,team2);
        cpu cpu3 = new cpu(p4, game1,team1);
        ////////////////////////////////////
        cpu cpu4 = new cpu(p1, game1, team2);
        ////////////////////////////////////

/*        Round r = new Round(game1);
        game1.setCurRound(r);
        cpu1.firstAutoBid();
        r.printCurrentBid();
        cpu2.computerBid();
        r.printCurrentBid();
        cpu3.computerBid();
        r.printCurrentBid();*/


        //System.out.println("Make a bid, enter bid quantity, then suit (|0▼|1♦|2♣|3♥|4♠|5▲|)");
        //quant = input.nextInt();
        //suit = input.nextInt();
        //p1.makeBid(quant,suit);
        //r.printCurrentBid();
        //cpu4.inhPlayer.makeBid(6,5);
        //r.printCurrentBid();

        int roundCount = 2;
        int i = 0;

        while(i < roundCount) {
            Deck tempD = new Deck();
            tempD.generateDeck();

            cpu1.inhPlayer.dealHand(tempD.deckVec);
            cpu2.inhPlayer.dealHand(tempD.deckVec);
            cpu3.inhPlayer.dealHand(tempD.deckVec);
            cpu4.inhPlayer.dealHand(tempD.deckVec);

            // Prints sorted first hand for testing.
            cpu1.inhPlayer.printHandWithName(cpu1.inhPlayer.name);
            cpu2.inhPlayer.printHandWithName(cpu2.inhPlayer.name);
            cpu3.inhPlayer.printHandWithName(cpu3.inhPlayer.name);
            cpu4.inhPlayer.printHandWithName(cpu4.inhPlayer.name);
            System.out.println("\n");

            Round tempR = new Round(game1);
            game1.setCurRound(tempR);
            System.out.println("Round " + (i + 1));
            cpu1.firstAutoBid();
            tempR.printCurrentBid();
            cpu2.computerBid();
            tempR.printCurrentBid();
            cpu3.computerBid();
            tempR.printCurrentBid();
            cpu4.computerBid();
            tempR.printCurrentBid();
            tempR.setTargetTrickCount(tempR.getBidQ());
            // Print the team that won bid
            if(team1.bidWinner){
                System.out.println(team1.getColor() + "Team 1 won the bid!" + ANSI_RESET);
                tempR.printCurrentBid();
            }
            else if(team2.bidWinner) {
                System.out.println(team2.getColor() + "Team 2 won the bid!" + ANSI_RESET);
                tempR.printCurrentBid();
            }
            System.out.println();
            for(int x = 0; x < 6; x++) {
                cpu1.lead();
                cpu2.follow();
                cpu3.follow();
                cpu4.follow();
                System.out.println();
            }
            i++;
            /*Deck tempD = new Deck();
            tempD.generateDeck();
            tempD.printDeck();

            // This only runs if there is a round after the current one. Prints hands at "beginning' of round
            if(i < roundCount-1) {
                cpu1.inhPlayer.dealHand(tempD.deckVec);
                cpu2.inhPlayer.dealHand(tempD.deckVec);
                cpu3.inhPlayer.dealHand(tempD.deckVec);
                cpu4.inhPlayer.dealHand(tempD.deckVec);

                // Prints sorted first hand for testing.
                cpu1.inhPlayer.printHandWithName(cpu1.inhPlayer.name);
                cpu2.inhPlayer.printHandWithName(cpu2.inhPlayer.name);
                cpu3.inhPlayer.printHandWithName(cpu3.inhPlayer.name);
                cpu4.inhPlayer.printHandWithName(cpu4.inhPlayer.name);
                System.out.println("\n");
            }*/
        }



    }
}
