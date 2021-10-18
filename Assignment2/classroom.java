import java.util.*;
import java.sql.Timestamp;
import java.util.Date;

class Instructors implements Same {

}

class Backpack {
    private int intuct;
    private int stu;
    private ArrayList<String> instructor = new ArrayList<>();
    private ArrayList<String> student = new ArrayList<>();
    private ArrayList<String> matrial = new ArrayList<>();

    public ArrayList<String> getmat() {
        return matrial;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initialising Backpack..........");
        System.out.print("Enter number of instructors: ");
        intuct = sc.nextInt();
        System.out.print("Enter number of students: ");
        stu = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < intuct; ++i) {
            System.out.print("Instructor name: ");
            String name = sc.nextLine();
            instructor.add(name);
        }
        System.out.println();
        for (int i = 0; i < stu; ++i) {
            System.out.print("Student name: ");
            String name = sc.nextLine();
            student.add(name);
        }
        System.out.println();
        int n;
        while(true) {
            System.out.println("-------------------Welcome to Backpack------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Enter as Instructor");
            System.out.println("2. Enter as student");
            System.out.println("3. Exit");
            System.out.println("--------------------------------------------------------");
            n = sc.nextInt();
            if (n == 1) {
                for (int i = 0; i < intuct; ++i) {
                    System.out.println(i + " - " + instructor.get(i));
                }
                System.out.println("Choose ID: ");
                int m = sc.nextInt();
                System.out.println();
                while (true) {
                    System.out.println("Welcome " + instructor.get(m));
                    System.out.println("------------------Instructor's Menu---------------------");
                    System.out.println("1. Add class material");
                    System.out.println("2. Add assessments");
                    System.out.println("3. View lecture materials");
                    System.out.println("4. View assessments");
                    System.out.println("5. Grade assessments");
                    System.out.println("6. Close assessment");
                    System.out.println("7. View comments");
                    System.out.println("8. Add comments");
                    System.out.println("9. Logout");
                    System.out.println("--------------------------------------------------------");
                    int z = sc.nextInt();
                    if (z == 1) {
                        Timestamp timest = new Timestamp(System.currentTimeMillis());  
                        Date date = new Date(timest.getTime()); 
                        String time = String.format("%tc", date );
                        System.out.println("1. Add Lecture Slide.");
                        System.out.println("2. Add Lecture Video.");
                        int opt = sc.nextInt();
                        if (opt == 1) {
                            System.out.println("Enter topic of slides: ");
                            String name = sc.nextLine();
                            System.out.println("Enter number of slides: ");
                            int num = sc.nextInt();
                            matrial.add("Title" + name);
                            matrial.add("Number of slides" + Integer.toString(num));
                            System.out.println("Enter content of slides: ");
                            for (int i = 0; i < num; i++) {
                                System.out.print("Content of slide " + (i+1) + ":");
                                matrial.add("Slide " + (i+1) + " " + sc.nextLine());
                            }
                            matrial.add("Date of upload " + time);
                            matrial.add("Uploaded by: " + instructor.get(m));
                        }
                        else if (opt == 2) {
                            System.out.println("Enter topic of video: ");
                            String topic = sc.nextLine();
                            System.out.println("Enter filename of video: ");
                            String name = sc.nextLine();
                            if (name.length() > 4) {
                                if (name.substring(name.length() - 4, name.length()).equals(".mp4")) {
                                    matrial.add("Title of video " + topic);
                                    matrial.add("Video file " + name);
                                    matrial.add("Date of upload " + time);
                                    matrial.add("Uploaded by " + instructor.get(m));
                                }
                            }
                            else {
                                System.out.println("Incorrect file format.");
                                continue;
                            }
                        }
                    }
                }
            }
        }
    }
}

public class classroom {
    public static void main(String[] args) {
        Backpack bk = new Backpack();
        bk.start();
    }
}
