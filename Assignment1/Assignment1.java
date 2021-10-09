import java.util.*;
class Vaccine{
    private String name;
    private int dose;
    private int gap;

    public Vaccine(String naam, int doze, int gaap) {
        name = naam;
        dose = doze;
        gap = gaap;
    }

    public String getname() {
        return name;
    }

    public int getdose() {
        return dose;
    }

    public int gap() {
        return gap;
    }       
}

class Hospital{
    private String name;
    private int pincode;
    private int uid;

    public Hospital(String naam, int num, int id) {
        name = naam;
        pincode = num;
        uid = id;
    }

    public String getname() {
        return name;
    }

    public int getpincode() {
        return pincode;
    }

    public int uid() {
        return uid;
    }       
}

class Citizen{
    private String name;
    private int age;
    private long uid;

    public Citizen(String naam, int num, long id) {
        name = naam;
        age = num;
        uid = id;
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public long uid() {
        return uid;
    }       
}




public class Assignment1 {
    ArrayList<Vaccine> vaclist = new ArrayList<Vaccine>();
    ArrayList<Hospital> hoslist = new ArrayList<Hospital>();
    ArrayList<Citizen> janhit = new ArrayList<Citizen>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Assignment1 as = new Assignment1();
        Vaccine vc;
        Hospital ho;
        Citizen ct;
        System.out.println("-------------------CoWin Portal------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("1. Add Vaccine");
        System.out.println("2. Register Hospital");
        System.out.println("3. Register Citizen");
        System.out.println("4. Add slot for vaccination");
        System.out.println("5. Book slot for vaccination");
        System.out.println("6. List all slots for hospital");
        System.out.println("7. Check vaccination status");
        System.out.println("8. Exit");
        System.out.println("-------------------------------------------------");
        int counth = 100000;
        long countp = 100000000000L;
        while(true) {
            System.out.print("Enter your option: ");
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 1) {
                System.out.print("Vaccine Name: ");
                String name = sc.next();
                System.out.print("Number of doses: ");
                int num = sc.nextInt();
                System.out.print("Gap between doses: ");
                int gap = sc.nextInt();
                sc.nextLine();
                vc = new Vaccine(name, num, gap);
                as.vaclist.add(vc);
                System.out.println("Vaccine Name: "+ name + " ,Number of doses: " + num + " ,Gap between doses: " + gap);
            }
            else if (n == 2) {
                System.out.print("Hospital Name: ");
                String name = sc.next();
                System.out.print("Pincode: ");
                int num = sc.nextInt();
                sc.nextLine();
                int uid = ++counth;
                ho = new Hospital(name, num, uid);
                as.hoslist.add(ho);
                System.out.println("Hospital Name: "+ name + " ,Pincode: " + num + " ,Unique ID: " + uid);
            }
            else if (n == 3) {
                System.out.print("Citizen Name: ");
                String name = sc.next();
                System.out.print("Age: ");
                int num = sc.nextInt();
                sc.nextLine();
                long uid = ++countp;
                System.out.println("Citizen Name: "+ name + " ,Age: " + num + " ,Unique ID: " + uid);
                if (num <= 18) {
                    System.out.println("Only above 18 are allowed.");
                }
                else {
                    ct = new Citizen(name, num, uid);
                    as.janhit.add(ct);
                }
            }
            else if (n == 4) {
                System.out.print("Enter Hospital ID: ");
                int uid = sc.nextInt();
                System.out.print("Enter Number of slots: ");
                int num = sc.nextInt();
                for (int i = 0; i <= num; ++i) {
                    System.out.print("Enter Day Number: ");
                    int day = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int quant = sc.nextInt();
                    System.out.print("Select Vaccine: "); 
                    for (int j = 0; j < as.vaclist.size(); ++j) {
                        System.out.println(j + " " + as.vaclist.get(j).getname());
                    }
                    int selection = sc.nextInt();
                    System.out.println("Slot added by Hospital "+ uid + " for Day: " + day + " ,Available Quantity: " + quant + " of Vaccine " + 
                                        as.vaclist.get(selection).getname());
                }
            }

            else if (n == 5) {
                System.out.print("Enter patient Unique ID: ");
                int uid = sc.nextInt();
                System.out.println("1. Search by Pincode");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter option: ");
                int num = sc.nextInt();
                System.out.print("Enter Day Number: ");
                int day = sc.nextInt();
                System.out.print("Enter quantity: ");
                int quant = sc.nextInt();
                System.out.print("Select Vaccine: ");
                int selection = sc.nextInt();
                System.out.println("Slot added by Hospital "+ uid + " for Day " + day + " ,Available Quantity: " + quant + " Vaccine ");
                
            }

            


        }


    }
}