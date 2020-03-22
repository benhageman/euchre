public class Game {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    Integer pointsTo = 0;
    Team x, y;
    Round curRound;

    public Game(Team x, Team y, int points){
        System.out.println("Welcome to the game!");
        //System.out.println(x.roster.get(0).getName() + " & " + x.roster.get(1).getName() + " vs. " + y.roster.get(0).getName() + " & " + y.roster.get(1).getName());
        this.x = x;
        this.y = y;
        System.out.println(x.getColor()+ x.roster.get(0).getName() + " & " + x.roster.get(1).getName() + " are Team 1." + ANSI_RESET);
        System.out.println(y.getColor()+ y.roster.get(0).getName() + " & " + y.roster.get(1).getName() + " are Team 2." + ANSI_RESET);
        pointsTo = points;
        System.out.println("First to " + pointsTo + " wins!" + "\n");
    }

    // checkBid checks to see if the players bid was valid
    // Must cannot bid same number of tricks without changing suit, can bid same number if they go high, can bid same number in suit if upbidding low
    // Quant (0 = pass, 1-6)
    // Suit (0 = low, 1 = diamond, 2 = club, 3 = heart, 4 = spade, 5 = high)
    boolean checkBid(int quant, int suit, int exQuant, int exSuit, Team thisTeam, Team otherTeam){
        if(quant > 6 | quant < 0){return false;}
        if(suit < 0 | suit > 5){return false;}

        if(quant > exQuant){
            thisTeam.bidWinner = true;
            otherTeam.bidWinner = false;
            return true;}                   // Bid q is larger than exBid q
        if(quant == exQuant & exSuit == 0 & suit != 0){
            thisTeam.bidWinner = true;
            otherTeam.bidWinner = false;
            return true;}                   // Bid q is same but existing bid was low, new bid is not low
        if(quant == exQuant & exSuit != 5 & suit == 5){
            thisTeam.bidWinner = true;
            otherTeam.bidWinner = false;
            return true;}                   // Bid q is same, but new bid is high, existing bid was not high

        //thisTeam.bidWinner = false;
        return false;
    }
    void addTXpoint(){x.currentPoints++;}
    void addTYpoint(){y.currentPoints++;}
    void setCurRound(Round r){curRound = r;}
    Round getCurRound(){return curRound;}

}
