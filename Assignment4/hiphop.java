import java.util.*;

class Softtoys {

}

class Player {
    private int chances;
    private ArrayList<Softtoys> bucket;

    Player() {
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

    public Game() {
        p1 = new Player();
    }

    public void start() {
        System.out.println("Game is ready");
        while(p1.getchances() > 0) {
            
        }
    }
}

public class hiphop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hit Enter to initialise the game.");
        Game gm = new Game();
        gm.start();
        sc.nextLine();
        sc.close();
    }
}
