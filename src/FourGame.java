import java.awt.geom.RectangularShape;
import java.util.Collections;
import java.util.Vector;
import java.util.Scanner;

public class FourGame {
    public static void main(String[] args) {

        final String ANSI_YELLOW = "\u001B[33m";
        Scanner input = new Scanner(System.in);
        int quant=0, suit=0;
        final String ANSI_RESET = "\u001B[0m";

        // Create player objects
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");
        Player p3 = new Player("Player 3");
        Player p4 = new Player("Player 4");

        // Create Vector of Player List

        Vector<Player> playerList = new Vector<>();
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);

        Vector<Player> playerBidOrder = playerList;
        Vector<Player> playerOrder = playerList;

        /*Player temp = playerOrder.get(0);
        playerOrder.remove(0);
        playerOrder.add(temp);*/



        Team team1 = new Team(p1,p3,"PURPLE");
        Team team2 = new Team(p2,p4,"BLUE");
        Game game1 = new Game(team1, team2, 10);
        p1.setGame(game1);
        p1.setTeam(team1);
        p2.setGame(game1);
        p2.setTeam(team2);
        p3.setGame(game1);
        p3.setTeam(team1);
        p4.setGame(game1);
        p4.setTeam(team2);

        int roundCount = 0;
        // For loop for rounds
        for(int i = 0; i < 1; i++) {
            roundCount++;
            System.out.println(ANSI_YELLOW + "ROUND " + roundCount + ANSI_RESET);
            System.out.println(team1.getColor() + "TEAM 1: " + team1.getScore() + ANSI_RESET);
            System.out.println(team2.getColor() + "TEAM 2: " + team2.getScore() + ANSI_RESET + "\n" + "\n" + "\n");


            Deck deck1 = new Deck();
            deck1.generateDeck();

            for(int x = 0; x < 4; x++){
                // Deal hands
                playerOrder.get(x).dealHand(deck1.deckVec);
                // Prints sorted first hand for each player
                playerOrder.get(x).printHandWithName(playerOrder.get(x).name);
            }

            System.out.println("\n");

            Round r = new Round(game1);
            game1.setCurRound(r);


            for(int x = 0; x < 4; x++){
                System.out.println("Make a bid, enter bid quantity, then suit (|0▼|1♦|2♣|3♥|4♠|5▲|)");
                System.out.println("Enter '0 0' to pass.");
                quant = input.nextInt();    //FIXME
                suit = input.nextInt();     //FIXME
                //quant = x;                  //FIXME
                //suit = 5;                   //FIXME
                int thisTeam = (x+2)%2;
                int otherTeam = (x+1)%2;

                playerBidOrder.get(x).makeBid(quant, suit, playerBidOrder.get(thisTeam).team,playerBidOrder.get(otherTeam).team);
                r.printCurrentBid();
            }

            if(team1.bidWinner){
                System.out.println(team1.getColor() + "TEAM 1 WON BID!" + ANSI_RESET);
            }
            else if(team2.bidWinner){
                System.out.println(team2.getColor() + "TEAM 2 WON BID!" + ANSI_RESET);
            }
            r.printWinningBid();
            System.out.println("\n" + "\n" + "\n");

            for(int x = 0; x < 4; x++){
                playerOrder.get(x).playCard(r.cardsPlayed, r);
                System.out.println("\n" + "\n");
            }

            // Move bid order
            Player temp = playerBidOrder.get(0);
            playerBidOrder.remove(0);
            playerBidOrder.add(temp);
        }
    }
}
