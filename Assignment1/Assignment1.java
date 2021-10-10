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

    public int getgap() {
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

    public int getuid() {
        return uid;
    }       
}

class Citizen{
    private String name;
    private String vacname;
    private int age;
    private int doze;
    private int stdate;
    private int vacgap;
    private String uid;
    private String status;
    private int setstat = 0;

    public Citizen(String naam, int num, String id) {
        name = naam;
        age = num;
        uid = id;
        status = "REGISTERED";
    }

    public String getname() {
        return name;
    }

    public int getage() {
        return age;
    }

    public String getuid() {
        return uid;
    }

    public void addvac(String vcname, int dose, int gap, int date) {
        vacname = vcname;
        doze = dose;
        vacgap = gap;
        stdate = date;
    }

    public void setstatus() {
        setstat++;
        stdate = vacgap + 1;
        if (setstat < doze) {
            status = "PARTIALLY VACCINATED";
        }
        if (setstat >= doze) {
            status = "FULLY VACCINATED";
        }
    }

    public String getstatus() {
        if (status == "REGISTERED") {
            return "Citizen REGISTERED";
        }
        if (status == "PARTIALLY VACCINATED") {
            return "Vaccine given: " + vacname + "\n" + "Number of doses given: " + setstat + "\n" + "Next dose due date: " + stdate;
        }
        if (status == "PARTIALLY VACCINATED") {
            return "Vaccine given: " + vacname + "\n" + "Number of doses given: " + setstat;
        }
        return "\n";
    }
}

class Slot{
    private int uid;
    private int day;
    private int quant;
    private String vac;

    public Slot(int id, int dai, int quantity, String vaccine) {
        uid = id;
        day = dai;
        quant = quantity;
        vac = vaccine;
    }

    public int getuid() {
        return uid;
    }

    public int getday() {
        return day;
    }

    public int getquant() {
        return quant;
    }

    public String getvac() {
        return vac;
    }

    public void setquant() {
        quant--;
    }
}




public class Assignment1 {
    private ArrayList<Vaccine> vaclist = new ArrayList<Vaccine>();
    private ArrayList<Hospital> hoslist = new ArrayList<Hospital>();
    private ArrayList<Citizen> janhit = new ArrayList<Citizen>();
    private ArrayList<Slot> slt = new ArrayList<Slot>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Assignment1 as = new Assignment1();
        Vaccine vc;
        Hospital ho;
        Citizen ct;
        Slot st;
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
                System.out.print("Unique ID: ");
                String uid = sc.next();
                sc.nextLine();
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
                    st = new Slot(uid, day, quant, as.vaclist.get(selection).getname());
                    as.slt.add(st);
                }
            }

            else if (n == 5) {
                System.out.print("Enter patient Unique ID: ");
                String uid = sc.next();
                int i = 0;
                while (as.janhit.get(i).getuid() != uid) {
                    if (i < as.janhit.size() - 1) {
                        i++;
                    }
                }
                if (as.janhit.get(i).getuid() != uid) {
                    System.out.println("ID incorrect or not present");
                    continue;
                }
                System.out.println("1. Search by area");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter option: ");
                int num = sc.nextInt();
                if (num == 1) {
                    System.out.print("Enter pincode: ");
                    int pin = sc.nextInt();
                    sc.nextLine();
                    for (int j = 0; j < as.hoslist.size(); j++) {
                        if (as.hoslist.get(j).getpincode() == pin)
                            System.out.println(as.hoslist.get(j).getuid() + " " + as.hoslist.get(j).getname());
                    }
                    System.out.print("Enter hospital Unique ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    int sno = 0;
                    HashMap<Integer, Integer> hmp = new HashMap<>();
                    for (int j = 0; j < as.slt.size(); j++) {
                        if (as.slt.get(j).getuid() == id) {
                            hmp.put(sno, j);
                            System.out.println(sno + " -> " + "Day: " + as.slt.get(j).getday() + " Available Qty: " + as.slt.get(j).getquant()
                                               + " Vaccine: " + as.slt.get(j).getvac());
                            sno++;
                        }
                    }
                    System.out.print("Choose slot: ");
                    int opt = sc.nextInt();
                    sc.nextLine();
                    System.out.println(as.janhit.get(i).getname() + " vaccinated with " + as.slt.get(hmp.get(opt)).getvac());   
                    for (int j = 0; j < as.vaclist.size(); j++) {
                        if (as.vaclist.get(j).getname() == as.slt.get(hmp.get(opt)).getvac()) {
                            as.janhit.get(i).addvac(as.slt.get(hmp.get(opt)).getvac(), as.vaclist.get(j).getdose(), as.vaclist.get(j).getgap(), as.slt.get(hmp.get(opt)).getday());
                            break;
                        }
                    }
                    as.janhit.get(i).setstatus();
                    as.slt.get(hmp.get(opt)).setquant();
                    
                }
                else if (num == 2) {
                    System.out.println("Enter vaccine name: ");
                    String name = sc.next();
                    sc.nextLine();
                    ArrayList<Integer> vactoUid = new ArrayList<>();
                    ArrayList<String> Uidtoname = new ArrayList<>();
                    for (int j = 0; j < as.slt.size(); j++) {
                        if (as.slt.get(j).getvac() == name && !vactoUid.contains(as.slt.get(j).getuid())) {
                            vactoUid.add(as.slt.get(j).getuid());
                        }
                    }
                    for (int j = 0; j < vactoUid.size(); j++) {
                        for (int k = 0; k < as.hoslist.size(); k++) {
                            if (vactoUid.get(j) == as.hoslist.get(k).getuid() && !Uidtoname.contains(as.hoslist.get(k).getname())) {
                                Uidtoname.add(as.hoslist.get(k).getname());
                            }
                        }  
                    }
                    for (int j = 0; j < vactoUid.size(); j++) {
                        System.out.println(vactoUid.get(j) + " " + Uidtoname.get(j));
                    }
                    System.out.print("Enter hospital ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (!vactoUid.contains(id)) {
                        System.out.println("Error: ID incorrect.");
                        continue;
                    }
                    int sno = 0;
                    HashMap<Integer, Integer> hmp = new HashMap<>();
                    for (int j = 0; j < as.slt.size(); j++) {
                        if (as.slt.get(j).getuid() == id) {
                            hmp.put(sno, j);
                            System.out.println(sno + " -> " + "Day: " + as.slt.get(j).getday() + " Available Qty: " + as.slt.get(j).getquant()
                                               + " Vaccine: " + as.slt.get(j).getvac());
                            sno++;
                        }
                    }
                    System.out.print("Choose slot: ");
                    int opt = sc.nextInt();
                    sc.nextLine();
                    System.out.println(as.janhit.get(i).getname() + " vaccinated with " + as.slt.get(hmp.get(opt)).getvac());
                    for (int j = 0; j < as.vaclist.size(); j++) {
                        if (as.vaclist.get(j).getname() == as.slt.get(hmp.get(opt)).getvac()) {
                            as.janhit.get(i).addvac(as.slt.get(hmp.get(opt)).getvac(), as.vaclist.get(j).getdose(), as.vaclist.get(j).getgap(), as.slt.get(hmp.get(opt)).getday());
                            break;
                        }
                    }
                    as.janhit.get(i).setstatus();
                    as.slt.get(hmp.get(opt)).setquant();    
                }
                else if (num == 3) {
                    continue;
                }
            }
            else if (n == 6) {
                System.out.print("Enter hospital ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < as.slt.size(); j++) {
                    if (as.slt.get(j).getuid() == id)
                        System.out.println("Day: " + as.slt.get(j).getday() + " Vaccine: " + as.slt.get(j).getvac() 
                                        + " Available Qty: " + as.slt.get(j).getquant());
                }
            }
            else if (n == 7) {
                System.out.print("Enter patient Unique ID: ");
                String uid = sc.next();
                int i = 0;
                while (as.janhit.get(i).getuid() != uid) {
                    if (i < as.janhit.size() - 1) {
                        i++;
                    }
                }
                if (as.janhit.get(i).getuid() != uid) {
                    System.out.println("ID incorrect or not present");
                    continue;
                }
                System.out.println(as.janhit.get(i).getstatus());
            }
            else if (n == 8) {
                sc.close();
                System.exit(0);
            }



            


        }


    }
}