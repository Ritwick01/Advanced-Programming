import java.util.*;
class healthcare {

}





public class Assignment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
                System.out.println("Vaccine Name: "+ name + " ,Number of doses: " + num + " ,Gap between doses: " + gap);
            }
            else if (n == 2) {
                System.out.print("Hospital Name: ");
                String name = sc.next();
                System.out.print("Pincode: ");
                int num = sc.nextInt();
                sc.nextLine();
                int uid = ++counth;
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
                    int selection = sc.nextInt();
                    System.out.println("Slot added by Hospital "+ uid + " for Day " + day + " ,Available Quantity: " + quant + " Vaccine ");
                }
            }

            else if (n == 5) {
                System.out.print("Enter patient Unique ID: ");
                int uid = sc.nextInt();
                System.out.println("1. Search by Pincode");
                System.out.println("2. Search by Vaccine");
                System.out.println("3. Exit");
                System.out.print("Enter opti: ");
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