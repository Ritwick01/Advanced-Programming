import java.util.*;

class Floor {
    protected Player p;
    private boolean flag;

    public Floor(Player player, boolean flg) {
        p = player;
        flag = flg;
    }

    public void usefloor() {   
        if (flag == true) {
            p.setfloor(p.getfloor()+2);    
        }     
        else {
            p.setfloor(p.getfloor()+1);
        }
        p.setpoints(p.getpoints()+1);
        System.out.println("Player position: Floor " + p.getfloor());
        System.out.println(p.getname() + " has reached an empty floor.");
        System.out.println("Total points: " + p.getpoints());
    }
}

class Snake extends Floor {

    public Snake(Player player) {
        super(player, false);
    }

    @Override
    public void usefloor() {
        p.setpoints(p.getpoints()-2);
        System.out.println("Player position: Floor " + p.getfloor());
        p.setfloor(0);
        System.out.println(p.getname() + " has reached the Snake floor.");
        System.out.println("Total points: " + p.getpoints());
        super.usefloor();
    }
    
}

class KingCobra extends Floor {

    public KingCobra(Player player) {
        super(player, false);
    }

    @Override
    public void usefloor() {
        p.setpoints(p.getpoints()-4);
        System.out.println("Player position: Floor " + p.getfloor());
        p.setfloor(2);
        System.out.println(p.getname() + " has reached the KingCobra floor.");
        System.out.println("Total points: " + p.getpoints());
        super.usefloor();
    }
    
}

class Elevator extends Floor {

    public Elevator(Player player) {
        super(player, false);
    }

    @Override
    public void usefloor() {
        p.setpoints(p.getpoints()+4);
        System.out.println("Player position: Floor " + p.getfloor());
        p.setfloor(9);
        System.out.println(p.getname() + " has reached the Elevator floor.");
        System.out.println("Total points: " + p.getpoints());
        super.usefloor();
    }
    
}

class Ladder extends Floor {

    public Ladder(Player player) {
        super(player, false);
    }

    @Override
    public void usefloor() {
        p.setpoints(p.getpoints()+2);
        System.out.println("Player position: Floor " + p.getfloor());
        p.setfloor(11);
        System.out.println(p.getname() + " has reached the Ladder floor.");
        System.out.println("Total points: " + p.getpoints());
        super.usefloor();
    }
    
}

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
    private Scanner sc = new Scanner(System.in);
    private String name;
    private Snake sk;
    private KingCobra kc;
    private Ladder ld;
    private Elevator elv;
    private Floor flr;

    public Game() {
        System.out.println("Enter the player name and hit enter");
        name = sc.nextLine();
        sc.nextLine();
        System.out.println("The game setup is ready.");
        p1 = new Player(name);
        dc = new Dice();
    }

    public void gamestart() {
        int start = dc.gettrow();
        System.out.print("Hit enter to roll the dice");
        sc.nextLine();
        System.out.println("Dice gave " + start);
        
        while (start != 1) {
            System.out.println("Game cannot start until you get 1");
            System.out.println("Hit enter to roll the dice");
            sc.nextLine();
            start = dc.gettrow();
            System.out.println("Dice gave " + start);
        }

        p1.setfloor(p1.getfloor()+start);
        p1.setpoints(p1.getpoints() + 1);
        System.out.println("Player position: Floor " + p1.getfloor());
        System.out.println(name + " has reached an empty floor.");
        System.out.println("Total points: " + p1.getpoints());


        while (true) {
            if (p1.getfloor() == 12) {
                break;
            }
            System.out.println("Hit enter to roll the dice");
            sc.nextLine();
            int n = dc.gettrow();
            System.out.println("Dice gave " + n);
            if (p1.getfloor() + n == 2) {
                elv = new Elevator(p1);
                p1.setfloor(2);
                elv.usefloor();
            }
            else if (p1.getfloor() + n == 8) {
                ld = new Ladder(p1);
                p1.setfloor(8);
                ld.usefloor();
            }
            else if (p1.getfloor() + n == 5) {
                sk = new Snake(p1);
                p1.setfloor(5);
                sk.usefloor();
            }
            else if (p1.getfloor() + n == 11) {
                kc = new KingCobra(p1);
                p1.setfloor(11);
                kc.usefloor();
            }
            else {
                Boolean flag;
                if (n == 1) {
                    flag = false;
                }
                else {
                    flag = true;
                }
                flr = new Floor(p1, flag);
                flr.usefloor();
            }

        }
        System.out.println("Hit enter to roll the dice");
        sc.nextLine();
        start = dc.gettrow();
        System.out.println("Dice gave " + start);
        while (start != 1) {
            System.out.println("Player cannot move.");
            System.out.println("Hit enter to roll the dice");
            sc.nextLine();
            start = dc.gettrow();
            System.out.println("Dice gave " + start);
        }
        flr = new Floor(p1, false);
        System.out.println("Game Over");
        System.out.println(p1.getname() + " accumulated " + p1.getpoints() + " points.");


    }

}


public class init {
    private Game gm = new Game();
    public static void main(String[] args) {
        init it = new init();
        it.gm.gamestart();
    }
}
