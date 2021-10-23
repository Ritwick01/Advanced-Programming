import java.util.*;

class Player {
    private String p_name;
    private int floor;
    private int points;

    public Player(String name) {
        p_name = name;
        floor = -1;
        points = 0;
    }

    public void setfloor(int n) {
        floor = n;
    }

    public void setpoints(int n) {
        points = n;
    }

    public int getpoints() {
        return points;
    }

    public int getfloor() {
        return floor;
    }

    public String getname() {
        return p_name;
    }
}

class Dice {
    private Random rd = new Random();
    private int trow;

    public int gettrow() {
        trow = rd.nextInt(1000);
        trow = (trow % 2) + 1;
        return trow;
    }
}

class Game {
    private Player p1;
    private Dice dc;

    public Game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player name and hit enter");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("The game setup is ready.");
        p1 = new Player(name);
        dc = new Dice();
    }

    
}


public class init {
    Game gm = new Game();
}
