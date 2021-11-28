import java.util.*;

class Softtoys {

    public void list() {
        Softtoys teddy = new Softtoys();
    }
}

class Player {
    private int chances;
    private ArrayList<Softtoys> bucket;

    public Player() {
        chances = 5;
        bucket = new ArrayList<Softtoys>();
    }

    public void decrementer() {
        chances -= 1;
    }

    public int getchances() {
        return chances;
    }

    public void addtoys(Softtoys toy) {
        bucket.add(toy);
    }

    public ArrayList<Softtoys> returnbuck() {
        return bucket;
    }   

    public int jump() {
        Random rd = new Random();
        return rd.nextInt(21) + 1;
    }
}

class Game {
    private Player p1;
    private Scanner sc = new Scanner(System.in);
    private String[] arr = {"first", "second", "third", "fourth", "fifth"};

    public Game() {
        p1 = new Player();
    }

    public void decrementchances() {
        p1.decrementer();
    }

    public void start() {
        System.out.println("Game is ready");
        while(p1.getchances() > 0) {
            System.out.println("Hit enter for your " + arr[5 - p1.getchances()] + "try");
            sc.nextLine();
            int n = p1.jump();
            if (n == 21) {
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                this.decrementchances();
                continue;
            }
            System.out.println("You landed on tile " + n);
            if (n % 2 == 0) {

            }
        }
    }
}

public class hiphop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit Enter to initialise the game.");
        sc.nextLine();
        Game gm = new Game();
        gm.start();
        sc.nextLine();
        sc.close();
    }
}
