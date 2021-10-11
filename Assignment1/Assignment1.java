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
    private String vacname = "HELLO";
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

    public String getvacn() {
        return vacname;
    }

    public int getdate() {
        return stdate;
    }

    public String setstatus() {
        stdate = vacgap + stdate;
        if (setstat < doze) {
            status = "PARTIALLY VACCINATED";
            setstat++;
        }
        if (setstat == doze) {
            status = "FULLY VACCINATED";
        }
        return status;
    }

    public int getdoze() {
        return doze;
    }

    public int getstat() {
        return setstat;
    }

    public String getstatus() {
        if (status == "REGISTERED") {
            return "Citizen REGISTERED";
        }
        if (status == "PARTIALLY VACCINATED") {
            return "PARTIALLY VACCINATED\nVaccine given: " + vacname + "\n" + "Number of doses given: " + setstat + "\n" + "Next dose due date: " + stdate;
        }
        if (status == "FULLY VACCINATED") {
            return "FULLY VACCINATED\nVaccine given: " + vacname + "\n" + "Number of doses given: " + setstat;
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
    private final ArrayList<Vaccine> vaclist = new ArrayList<Vaccine>();
    private final ArrayList<Hospital> hoslist = new ArrayList<Hospital>();
    private final ArrayList<Citizen> janhit = new ArrayList<Citizen>();
    private final ArrayList<Slot> slt = new ArrayList<Slot>();
    private final ArrayList<String> checkid = new ArrayList<>();
    private final ArrayList<Integer> hosid = new ArrayList<>();
    private Vaccine vc;
    private Hospital ho;
    private Citizen ct;
    private Slot st;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Assignment1 as = new Assignment1();
        int counth = 100000;
        while(true) {
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
            System.out.print("Enter your option: ");
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 1) {
                System.out.print("Vaccine Name: ");
                String name = sc.next();
                System.out.print("Number of doses: ");
                int num = sc.nextInt();
                int gap = 0;
                if (num != 1) {
                    System.out.print("Gap between doses: ");
                    gap = sc.nextInt();
                }
                sc.nextLine();
                as.vc = new Vaccine(name, num, gap);
                as.vaclist.add(as.vc);
                System.out.println("Vaccine Name: "+ name + " , Number of doses: " + num + " , Gap between doses: " + gap);
            }
            else if (n == 2) {
                System.out.print("Hospital Name: ");
                String name = sc.next();
                System.out.print("Pincode: ");
                int num = sc.nextInt();
                if (num < 100000 || num > 999999) {
                    System.out.println("Error: Pincode is not of valid format");
                    continue;
                }
                sc.nextLine();
                int uid = ++counth;
                as.ho = new Hospital(name, num, uid);
                as.hoslist.add(as.ho);
                as.hosid.add(uid);
                System.out.println("Hospital Name: "+ name + " , Pincode: " + num + " , Unique ID: " + uid);
            }
            else if (n == 3) {
                System.out.print("Citizen Name: ");
                String name = sc.next();
                System.out.print("Age: ");
                int num = sc.nextInt();
                sc.nextLine();
                System.out.print("Unique ID: ");
                String uid = sc.next();
                if (uid.length() == 12) {
                    if (as.checkid.contains(uid)) {
                        System.out.println("ID already exists in database.");
                        continue;
                    }
                    sc.nextLine();
                    if (num <= 18) {
                        System.out.println("Only above 18 are allowed.");
                        continue;
                    }
                    else {
                        System.out.println("Citizen Name: "+ name + " , Age: " + num + " , Unique ID: " + uid);
                        as.ct = new Citizen(name, num, uid);
                        as.janhit.add(as.ct);
                        as.checkid.add(uid);
                    }
                }
                else {
                    System.out.println("Incorrect format");
                    continue;
                }
            }
            else if (n == 4) {
                System.out.print("Enter Hospital ID: ");
                int uid = sc.nextInt();
                if (!as.hosid.contains(uid)) {
                    System.out.println("Wrong ID entered. Please try again.");
                    continue;
                }
                System.out.print("Enter Number of slots: ");
                int num = sc.nextInt();
                for (int i = 0; i < num; ++i) {
                    System.out.print("Enter Day Number: ");
                    int day = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int quant = sc.nextInt();
                    System.out.println("Select Vaccine: "); 
                    for (int j = 0; j < as.vaclist.size(); ++j) {
                        if (as.vaclist.size() == 0)
                            System.out.println("No Vaccines added");
                        else
                            System.out.println(j + " " + as.vaclist.get(j).getname());
                    }
                    int selection = sc.nextInt();
                    System.out.println("Slot added by Hospital "+ uid + " for Day: " + day + " ,Available Quantity: " + quant + " of Vaccine " + 
                                        as.vaclist.get(selection).getname());
                    as.st = new Slot(uid, day, quant, as.vaclist.get(selection).getname());
                    as.slt.add(as.st);
                }
            }

            else if (n == 5) {
                System.out.print("Enter patient Unique ID: ");
                String uid = sc.next();
                sc.nextLine();
                int i = 0;
                for (i = 0; i < as.janhit.size(); i++) {
                    if (as.janhit.get(i).getuid().equals(uid)) {
                        break;
                    }
                }
                if (i == as.janhit.size()) {
                    System.out.println("Patient Unique ID does not exist in system.");
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
                        if (as.slt.get(j).getuid() == id ) {
                            if (as.janhit.get(i).getdate() <= as.slt.get(j).getday() && as.slt.get(j).getquant() != 0) {
                                hmp.put(sno, j);
                                System.out.println(sno + " -> " + "Day: " + as.slt.get(j).getday() + " Available Qty: " + as.slt.get(j).getquant()
                                                + " Vaccine: " + as.slt.get(j).getvac());
                                sno++;
                            }
                            else {
                                continue;
                            }
                        }
                    }
                    if (sno != 0) {
                        System.out.print("Choose slot: ");
                        int opt = sc.nextInt();
                        sc.nextLine();
                        if (as.janhit.get(i).getvacn().equals("HELLO")) {
                            System.out.println(as.janhit.get(i).getname() + " vaccinated with " + as.slt.get(hmp.get(opt)).getvac());   
                            for (int j = 0; j < as.vaclist.size(); j++) {
                                if (as.vaclist.get(j).getname().equals(as.slt.get(hmp.get(opt)).getvac())) {
                                    as.janhit.get(i).addvac(as.slt.get(hmp.get(opt)).getvac(), as.vaclist.get(j).getdose(), as.vaclist.get(j).getgap(), as.slt.get(hmp.get(opt)).getday());
                                    break;
                                }
                            }
                            as.janhit.get(i).setstatus();
                            if (as.janhit.get(i).getstat() <= as.janhit.get(i).getdoze()) {
                                as.slt.get(hmp.get(opt)).setquant();
                            }
                        }
                        else if (as.janhit.get(i).getvacn().equals(as.slt.get(hmp.get(opt)).getvac())) {
                            System.out.println(as.janhit.get(i).getname() + " vaccinated with " + as.slt.get(hmp.get(opt)).getvac());   
                            for (int j = 0; j < as.vaclist.size(); j++) {
                                if (as.vaclist.get(j).getname().equals(as.slt.get(hmp.get(opt)).getvac())) {
                                    as.janhit.get(i).addvac(as.slt.get(hmp.get(opt)).getvac(), as.vaclist.get(j).getdose(), as.vaclist.get(j).getgap(), as.slt.get(hmp.get(opt)).getday());
                                    break;
                                }
                            }
                            as.janhit.get(i).setstatus();
                            if (as.janhit.get(i).getstat() <= as.janhit.get(i).getdoze()) {
                                as.slt.get(hmp.get(opt)).setquant();
                            }
                        }
                        else {
                            System.out.println("Mixing of vaccines is dangerous for health");
                        }
                        
                    }
                    else {
                        System.out.println("No slot available");
                    }
                    
                }
                else if (num == 2) {
                    System.out.print("Enter vaccine name: ");
                    String name = sc.next();
                    System.out.println();
                    ArrayList<Integer> vactoUid = new ArrayList<>();
                    ArrayList<String> Uidtoname = new ArrayList<>();
                    for (int j = 0; j < as.slt.size(); j++) {
                        if ((name.equals(as.slt.get(j).getvac()) && (vactoUid.contains(as.slt.get(j).getuid()) == false))) {
                            vactoUid.add(as.slt.get(j).getuid());
                        }
                    }
                    for (int j = 0; j < vactoUid.size(); j++) {
                        for (int k = 0; k < as.hoslist.size(); k++) {
                            if (vactoUid.get(j).equals(as.hoslist.get(k).getuid()) && (Uidtoname.contains(as.hoslist.get(k).getname()) == false)) {
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
                        if (as.slt.get(j).getuid() == id && as.slt.get(j).getvac().equals(name)) {
                            if (as.janhit.get(i).getdate() <= as.slt.get(j).getday()) {
                                hmp.put(sno, j);
                                System.out.println(sno + " -> " + "Day: " + as.slt.get(j).getday() + " Available Qty: " + as.slt.get(j).getquant()
                                                + " Vaccine: " + as.slt.get(j).getvac());
                                sno++;
                            }
                            else {
                                continue;
                            }
                        }
                    }
                    if (sno != 0) {
                        System.out.print("Choose slot: ");
                        int opt = sc.nextInt();
                        sc.nextLine();
                        if (as.janhit.get(i).getvacn().equals("HELLO")) {
                            System.out.println(as.janhit.get(i).getname() + " vaccinated with " + as.slt.get(hmp.get(opt)).getvac());   
                            for (int j = 0; j < as.vaclist.size(); j++) {
                                if (as.vaclist.get(j).getname().equals(as.slt.get(hmp.get(opt)).getvac())) {
                                    as.janhit.get(i).addvac(as.slt.get(hmp.get(opt)).getvac(), as.vaclist.get(j).getdose(), as.vaclist.get(j).getgap(), as.slt.get(hmp.get(opt)).getday());
                                    break;
                                }
                            }
                            as.janhit.get(i).setstatus();
                            if (as.janhit.get(i).getstat() <= as.janhit.get(i).getdoze()) {
                                as.slt.get(hmp.get(opt)).setquant();
                            }
                        }
                        else if (as.janhit.get(i).getvacn().equals(as.slt.get(hmp.get(opt)).getvac())) {
                            System.out.println(as.janhit.get(i).getname() + " vaccinated with " + as.slt.get(hmp.get(opt)).getvac());   
                            for (int j = 0; j < as.vaclist.size(); j++) {
                                if (as.vaclist.get(j).getname().equals(as.slt.get(hmp.get(opt)).getvac())) {
                                    as.janhit.get(i).addvac(as.slt.get(hmp.get(opt)).getvac(), as.vaclist.get(j).getdose(), as.vaclist.get(j).getgap(), as.slt.get(hmp.get(opt)).getday());
                                    break;
                                }
                            }
                            as.janhit.get(i).setstatus();
                            if (as.janhit.get(i).getstat() <= as.janhit.get(i).getdoze()) {
                                as.slt.get(hmp.get(opt)).setquant();
                            }
                        }
                        else {
                            System.out.println("Mixing of vaccines is dangerous for health");
                        }
                        
                    }
                    else {
                        System.out.println("No slot available");
                    }
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
                String uidi = sc.next();
                sc.nextLine();
                int j = 0;
                for (j = 0; j < as.janhit.size(); j++) {
                    if (as.janhit.get(j).getuid().equals(uidi)) {
                        break;
                    }
                }

                if (j == as.janhit.size()) {
                    System.out.println("Patient Unique ID does not exist in system.");
                    continue;
                }
                
                System.out.println(as.janhit.get(j).getstatus());
            }
            else if (n == 8) {
                sc.close();
                System.exit(0);
            }



            


        }


    }
}