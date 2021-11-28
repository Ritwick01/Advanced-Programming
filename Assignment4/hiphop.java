import java.util.*;

class TileMap {
    private HashMap<Integer, Softtoys> tilemap = new HashMap<>();
    private Player p1;

    public TileMap() {
        tilemap.put(1, new Softtoys("Teddy"));
        tilemap.put(2, new Softtoys("Donald Duck"));
        tilemap.put(3, new Softtoys("Mickey Mouse"));
        tilemap.put(4, new Softtoys("Goofy"));
        tilemap.put(5, new Softtoys("Minnie Mouse"));
        tilemap.put(6, new Softtoys("Chotta Bheem"));
        tilemap.put(7, new Softtoys("Penguin"));
        tilemap.put(8, new Softtoys("Elephant"));
        tilemap.put(9, new Softtoys("Fox"));
        tilemap.put(10, new Softtoys("Lion"));
        tilemap.put(11, new Softtoys("Tiger"));
        tilemap.put(12, new Softtoys("Turtle"));
        tilemap.put(13, new Softtoys("Snorlax"));
        tilemap.put(14, new Softtoys("Jigglypuff"));
        tilemap.put(15, new Softtoys("Chimchar"));
        tilemap.put(16, new Softtoys("Snivy"));
        tilemap.put(17, new Softtoys("Squirtle"));
        tilemap.put(18, new Softtoys("Pikachu"));
        tilemap.put(19, new Softtoys("Gru"));
        tilemap.put(20, new Softtoys("Minion"));
    }


}

class Softtoys {
    private String name;
    
    public Softtoys(String naam) {
        name = naam;
    }

    public String getname() {
        return name;
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
