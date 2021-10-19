import java.util.*;
import java.sql.Timestamp;
import java.util.Date;

class assessment {
    private String q;
    private int num = 1;
    private String istatus = "OPEN";
    private String sstatus = "PENDING";

    public assessment(String ques) {
        q = ques;
    }

    public assessment(String ques, int marks) {
        q = ques;
        num = marks;
    }

    public String getquiz() {
        return "Question: " + q;
    }

    public String getassess() {
        return "Assignment: " + q + " Max Marks: " + Integer.toString(num);
    }

    public void setistatus() {
        istatus = "CLOSED";
    }

    public String getistatus() {
        return istatus;
    }

    public void setsstatus() {
        sstatus = "SUBMITTED";
    }

    public String getsstatus() {
        return sstatus;
    }
}

class Instructors implements Same {
    private assessment as;

    public void setstatus(assessment giv) {
        as = giv;
        as.setistatus();
    }

}

class Backpack {
    private int intuct;
    private int stu;
    private Instructors inst = new Instructors();
    private ArrayList<String> instructor = new ArrayList<>();
    private ArrayList<String> student = new ArrayList<>();
    private ArrayList<String> matrial = new ArrayList<String>();
    private ArrayList<assessment> quiz = new ArrayList<>();
    private ArrayList<assessment> assess = new ArrayList<>();

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
                        sc.nextLine();
                        if (opt == 1) {
                            System.out.println("Enter topic of slides: ");
                            String name = sc.nextLine();
                            System.out.println("Enter number of slides: ");
                            int num = sc.nextInt();
                            matrial.add(name);
                            matrial.add("Number of slides" + Integer.toString(num));
                            System.out.println("Enter content of slides: ");
                            sc.nextLine();
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
                    else if (z == 2) {
                        System.out.println("1. Add Assignment.");
                        System.out.println("2. Add Quiz.");
                        int opt = sc.nextInt();
                        if (opt == 1) {
                            System.out.println("Enter problem statement: ");
                            String prob = sc.nextLine();
                            System.out.println("Enter max marks: ");
                            int marks = sc.nextInt();
                            assessment as = new assessment(prob, marks);
                            assess.add(as);
                        }
                        else if (opt == 2) {
                            System.out.println("Enter quiz question: ");
                            String prob = sc.nextLine();
                            assessment as = new assessment(prob);
                            quiz.add(as);
                        }

                    }
                    else if (z == 3) {
                        inst.vwlecmat(matrial);
                    }
                    else if (z == 4) {
                        inst.vwassess(quiz, assess);
                    }
                    else if (z == 5) {

                    }
                    else if (z == 6) {
                        System.out.println("List of open assessments: ");
                        int count = 0;
                        HashMap<Integer, Integer> record = new HashMap<>();
                        System.out.println("Quizzes");
                        for (int i = 0; i < quiz.size(); ++i) {
                            if (quiz.get(i).getistatus().equals("OPEN")) {
                                System.out.println("ID: " + count + " " + quiz.get(i).getquiz()); 
                                System.out.println("--------------------------------------");
                                record.put(count, i);
                                count++;
                            }    
                        }
                        System.out.println("Assignments");
                        for (int i = 0; i < assess.size(); ++i) {
                            if (assess.get(i).getistatus().equals("OPEN")) {
                                System.out.println("ID: " + (count) + " " + assess.get(i).getassess());     
                                System.out.println("--------------------------------------"); 
                                record.put(count, i);
                                count++; 
                            }
                        }
                        System.out.println("Enter ID of assessment to close: ");
                        int id = sc.nextInt();
                        if (id < quiz.size()) {
                            inst.setstatus(quiz.get(record.get(id)));
                        }
                        else if (id >= quiz.size() && id < (quiz.size()+ assess.size())) {
                            inst.setstatus(assess.get(record.get(id)));
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
