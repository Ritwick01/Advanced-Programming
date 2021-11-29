import java.util.*;

class Softtoys implements Cloneable {
    private String name;
    
    public Softtoys(String naam) {
        name = naam;
    }

    public String getname() {
        return name;
    }

    public Softtoys clone() {
        try {
            Softtoys sft = (Softtoys) super.clone();
            return sft;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

class TileMap {
    private HashMap<Integer, Softtoys> tilemap = new HashMap<>();
    private Player p1;

    public TileMap(Player p) {
        p1 = p;
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

    public void pass_a_clone(int n) {
        p1.addtoys(tilemap.get(n).clone());
    }

    public HashMap<Integer, Softtoys> returnmap() {
        return tilemap;
    }

}

class Questionbuilder {
    private Random rd = new Random();

    public int intQ() {
        int n = rd.nextInt();
        if (n == 0) {
            return 5;
        }
        else {
            return n;
        }
    }

    public String strQ() {
        StringBuilder str = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int n = rd.nextInt((122-65) + 1) + 65;
            if (n == 91 || n == 92 || n == 93 || n == 94 || n == 95 || n == 96) {
                n = 97;
            }
            str.append((char) n);
        }
        return str.toString();
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

class Calculator <T> {
 
    public boolean calculDiv(T thing1, T thing2, T result) {
        if (thing1 instanceof Integer && thing2 instanceof Integer) {
            try {
                if (result.equals(Math.floorDiv(((int) thing1),((int) thing2)))) {
                    return true;
                }
                else {
                    return false;
                }
            }
            catch (ArithmeticException e) {
                System.out.println("Division by 0 not supported");
                return false;
            }
        }
        else if (thing1 instanceof String && thing2 instanceof String) {
            if (result.equals((String)thing1 + (String)thing2)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            throw new IllegalArgumentException("Paramaters must be String or Integer.");
        }
    }
}

class Game {
    private Player p1;
    private TileMap tmap;
    private Questionbuilder qb;
    private Scanner sc = new Scanner(System.in);
    private String[] arr = {"first", "second", "third", "fourth", "fifth"};

    public Game() {
        p1 = new Player();
        tmap = new TileMap(p1);
        qb = new Questionbuilder();
    }

    public void decrementchances() {
        p1.decrementer();
    }

    public void start() {
        System.out.println("Game is ready");
        while(p1.getchances() > 0) {
            System.out.println("-------------------------------------------------");
            try {
                System.out.println("Hit enter for your " + arr[5 - p1.getchances()] + " try");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Index exceeded");
            }
            sc.nextLine();
            int n = p1.jump();
            if (n == 21) {
                System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
                this.decrementchances();
                continue;
            }
            System.out.println("You landed on tile " + n);
            if (n % 2 == 0) {
                System.out.println("You won a " + tmap.returnmap().get(n).getname() + " soft toy.");
                tmap.pass_a_clone(n);
            }
            else {
                System.out.println("Question-answer round. Integer or String?");
                String s = sc.nextLine();
                while (!(s.equals("Integer") || s.equals("String"))) {
                    System.out.println("Incorrect Input. Please try again.");
                    s = sc.nextLine();
                }
                if (s.equals("Integer")) {
                    int n1 = qb.intQ();
                    int n2 = qb.intQ();
                    System.out.println("Calculate the result of " + n1 + " divided by " + n2 + " (Round down any floating point results)");
                    int res = Integer.MIN_VALUE;
                    boolean flag = false;
                    do {
                        try {
                            res = sc.nextInt();
                            flag = true;
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Wrong Input type. Try Again.");
                            sc.next();
                        }
                    } while (flag != true);
                    Calculator<Integer> c = new Calculator<Integer>();
                    if (c.calculDiv(n1, n2, res)) {
                        System.out.println("Correct answer!!!");
                        System.out.println("You won a " + tmap.returnmap().get(n).getname() + " soft toy.");
                        tmap.pass_a_clone(n);
                        sc.nextLine();
                    }
                    else {
                        System.out.println("Incorrect answer");
                        System.out.println("You did not win any soft toy");
                        sc.nextLine();
                    }
                }
                else if (s.equals("String")) {
                    String n1 = qb.strQ();
                    String n2 = qb.strQ();
                    System.out.println("Calculate the concantenation of " + n1 + " and " + n2);
                    String res = sc.nextLine();
                    boolean flag = false;
                    do {
                        do {
                            try {
                                if (((int)res.charAt(0) >= 32 && (int)res.charAt(0) <= 64) || ((int)res.charAt(0) >= 91 && (int)res.charAt(0) <= 96)) {
                                    System.out.println("Incorrect Format: String Not Entered");
                                    System.out.println("Calculate the concantenation of " + n1 + " and " + n2);
                                    res = sc.nextLine();
                                }
                                else {
                                    flag = true;
                                }
                            }
                            catch (StringIndexOutOfBoundsException e) {
                                System.out.println("Blank Line not supported");
                                System.out.println("Calculate the concantenation of " + n1 + " and " + n2);
                                res = sc.nextLine();
                            }
                        } while (!flag);
                    } while (!flag);
                    Calculator<String> c = new Calculator<String>();
                    if (c.calculDiv(n1, n2, res)) {
                        System.out.println("Correct answer!!!");
                        System.out.println("You won a " + tmap.returnmap().get(n).getname() + " soft toy.");
                        tmap.pass_a_clone(n);
                    }
                    else {
                        System.out.println("Incorrect answer");
                        System.out.println("You did not win any soft toy");
                    }
                }
            }
            this.decrementchances();
        }
        System.out.println();
        System.out.println("Game Over");
        System.out.println("Soft toys won by you are: ");
        for (Softtoys sft : p1.returnbuck()) {
            System.out.print(sft.getname() + ", ");
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
