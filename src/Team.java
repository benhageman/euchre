import java.util.Vector;

public class Team {
    Integer currentPoints;
    Vector<Player> roster = new Vector<Player>();
    String tColor;
    boolean bidWinner;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public Team(Player x, Player y, String color){
        roster.add(x);
        roster.add(y);
        currentPoints = 0;
        if(color.equals("RED"))
            tColor = ANSI_RED;
        else if(color.equals("GREEN")){
            tColor = ANSI_GREEN;
        }
        else if(color.equals("YELLOW")){
            tColor = ANSI_YELLOW;
        }
        else if(color.equals("BLUE")){
            tColor = ANSI_BLUE;
        }
        else if(color.equals("PURPLE")){
            tColor = ANSI_PURPLE;
        }
        else if(color.equals("CYAN")){
            tColor = ANSI_CYAN;
        }
        else if(color.equals("BLACK")){
            tColor = ANSI_BLACK;
        }
    }

    String getColor(){return tColor;}

}
