import java.util.*;
import java.sql.Timestamp;

class assessment {
    private String q;
    private int num = 1;
    private String istatus = "OPEN";
    private String sstatus = "PENDING";
    private String gradestat = "UNGRADED";
    private String answ;
    private float marks = 0;
    private String instruct;

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

    public int maxmarks() {
        return num;
    }

    public void setmarks(float mark) {
        marks = mark;
    }

    public float getmarks() {
        return marks;
    }

    public void setansw(String answer) {
        answ = answer;
    }

    public String getansw() {
        return answ;
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

    public void setgradstat() {
        gradestat = "GRADED";
    }

    public String getgradstat() {
        return gradestat;
    }

    public void setinstruct(String name) {
        instruct = name;
    }

    public String getinstruct() {
        return instruct;
    }
}

class Instructors implements Same {
    private assessment as;

    public void setstatus(assessment giv) {
        as = giv;
        as.setistatus();
    }

}

class Student implements Same {
    private String name;
    private ArrayList<assessment> q;
    private ArrayList<assessment> a;

    public Student(ArrayList<assessment> quiz, ArrayList<assessment> assess, String naam) {
        name = naam;
        a = assess;
        q = quiz;
    }

    public void updatequiz(ArrayList<assessment> quiz) {
        if (q.size() < quiz.size()) {
            for (int i = q.size(); i < quiz.size(); i++) {
                q.add(quiz.get(i));
            }
        }
    }

    public void updateassess(ArrayList<assessment> assess) {
        if (a.size() < assess.size()) {
            for (int i = a.size(); i < assess.size(); i++) {
                a.add(assess.get(i));
            }
        }
    }

    public ArrayList<assessment> getquiz() {
        return q;
    }

    public ArrayList<assessment> getassess() {
        return a;
    }

    public void closequiz(int m) {
        q.get(m).setistatus();
    }

    public void closeassess(int m) {
        a.get(m).setistatus();
    }

    public String getname() {
        return name;
    }
    
}

class Backpack {
    private int intuct;
    private int stu;
    private Instructors inst = new Instructors();
    private ArrayList<String> instructor = new ArrayList<>();
    private ArrayList<String> student = new ArrayList<>();
    private ArrayList<Student> stlist = new ArrayList<Student>();
    private ArrayList<String> matrial = new ArrayList<String>();
    private ArrayList<assessment> quiz = new ArrayList<>();
    private ArrayList<assessment> assess = new ArrayList<>();
    private ArrayList<String> comments = new ArrayList<>();
    private Student st;

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
            st = new Student(quiz, assess, name);
            stlist.add(st);
        }
        System.out.println();
        Timestamp timest = new Timestamp(System.currentTimeMillis());  
        Date date = new Date(timest.getTime()); 
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
                        sc.nextLine();
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
                        inst.vwassess(quiz, assess);
                        HashMap<Integer, Integer> record = new HashMap<>();
                        int count = 0;
                        System.out.println("Enter ID of assessment to view submission: ");
                        int id = sc.nextInt();
                        if (id < quiz.size()) {
                            for (int i = 0; i < stu; i++) {
                                if (stlist.get(i).getquiz().get(id).getsstatus().equals("SUBMITTED")) {
                                    System.out.println(count + ". " + stlist.get(i).getname());
                                    record.put(count, i);
                                    count++;
                                }
                            }
                        }
                        else if (id >= quiz.size() && id < (quiz.size()+ assess.size())) {
                            for (int i = 0; i < stu; i++) {
                                if (stlist.get(i).getassess().get(id).getsstatus().equals("SUBMITTED")) {
                                    System.out.println(count + ". " + stlist.get(i).getname());
                                    record.put(count, i);
                                    count++;
                                }
                            }
                        }
                        System.out.println("Enter number: ");
                        int idx = sc.nextInt();
                        if (record.get(id) < quiz.size()) {
                            System.out.println("Submission: " + stlist.get(record.get(idx)).getquiz().get(id).getansw());
                            System.out.println("-------------------------------");
                            System.out.println("Max marks: " + quiz.get(id).maxmarks());
                            System.out.println("Marks scored: ");
                            float marks = sc.nextFloat();
                            stlist.get(record.get(idx)).getquiz().get(id).setmarks(marks);
                            stlist.get(record.get(idx)).getquiz().get(id).setgradstat();
                            stlist.get(record.get(idx)).getquiz().get(id).setinstruct(instructor.get(m));
                        }
                        else if (record.get(id) >= quiz.size() && record.get(id) < (quiz.size()+ assess.size())) {
                            System.out.println("Submission: " + stlist.get(record.get(idx)).getassess().get(id).getansw());
                            System.out.println("-------------------------------");
                            System.out.println("Max marks: " + assess.get(id).maxmarks());
                            System.out.println("Marks scored: ");
                            float marks = sc.nextFloat();
                            stlist.get(record.get(idx)).getassess().get(id).setmarks(marks);
                            stlist.get(record.get(idx)).getassess().get(id).setgradstat();
                            stlist.get(record.get(idx)).getassess().get(id).setinstruct(instructor.get(m));
                        }
                        


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
                        if (record.get(id) < quiz.size()) {
                            inst.setstatus(quiz.get(record.get(id)));
                            for (int i = 0; i < stu; i++) {
                                stlist.get(i).closequiz(record.get(id));
                            }
                        }
                        else if (record.get(id) >= quiz.size() && record.get(id) < (quiz.size()+ assess.size())) {
                            inst.setstatus(assess.get(record.get(id)));
                            for (int i = 0; i < stu; i++) {
                                stlist.get(i).closeassess(record.get(id));
                            }
                        }
                    }
                    else if (z == 7) {
                        inst.vwcomments(comments);
                    }

                    else if (z == 8) {
                        sc.nextLine();
                        System.out.print("Enter comment:");
                        String com = sc.nextLine();
                        comments.add(com + " - " + instructor.get(m));
                        String time = String.format("%tc", date );
                        comments.add(time);
                    }
                    else if (z == 9) {
                        break;
                    }
                }
            }
            else if (n == 2) {
                for (int i = 0; i < stu; ++i) {
                    System.out.println(i + " - " + student.get(i));
                }
                System.out.println("Choose ID: ");
                int m = sc.nextInt();
                System.out.println();
                while(true) {
                    System.out.println("Welcome " + student.get(m));
                    System.out.println("------------------Student's Menu---------------------");
                    System.out.println("1. View lecture materials");
                    System.out.println("2. View assessments");
                    System.out.println("3. Submit assessments");
                    System.out.println("4. View Grades");
                    System.out.println("5. View comments");
                    System.out.println("6. Add comments");
                    System.out.println("7. Logout");
                    System.out.println("--------------------------------------------------------");
                    int z = sc.nextInt();
                    if (z == 1) {
                        st.vwlecmat(matrial);
                    }
                    else if (z == 2) {
                        st.vwassess(quiz, assess);
                    }
                    else if (z == 3) {
                        System.out.println("Pending assessments: ");
                        int count = 0;
                        HashMap<Integer, Integer> record = new HashMap<>();
                        System.out.println("Quizzes");
                        for (int i = 0; i < quiz.size(); i++) {
                            if (stlist.get(m).getquiz().get(i).getistatus().equals("OPEN") && stlist.get(m).getquiz().get(i).getsstatus().equals("PENDING")) {
                                System.out.println("ID: " + count + " " + quiz.get(i).getquiz()); 
                                System.out.println("--------------------------------------");
                                record.put(count, i);
                                count++;
                            }    
                        }
                        System.out.println("Assignments");
                        for (int i = 0; i < assess.size(); i++) {
                            if (stlist.get(m).getassess().get(i).getistatus().equals("OPEN") && stlist.get(m).getassess().get(i).getsstatus().equals("PENDING")) {
                                System.out.println("ID: " + (count) + " " + assess.get(i).getassess());     
                                System.out.println("--------------------------------------"); 
                                record.put(count, i);
                                count++; 
                            }
                        }
                        System.out.println("Enter ID of assessment: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        if (id < quiz.size()) {
                            System.out.println(record.get(id));
                            System.out.println(quiz.get(record.get(id)).getquiz());
                            String ans = sc.nextLine();
                            stlist.get(m).getquiz().get(record.get(id)).setansw(ans);
                            stlist.get(m).getquiz().get(record.get(id)).setsstatus();
                        }
                        else if (id >= quiz.size() && id < (quiz.size()+ assess.size())) {
                            System.out.println("Enter filename of assignment: ");
                            String ans = sc.nextLine();
                            if (ans.length() > 4) {
                                if (ans.substring(ans.length() - 4, ans.length()).equals(".zip")) {
                                    stlist.get(m).getassess().get(record.get(id)).setansw(ans);
                                    stlist.get(m).getassess().get(record.get(id)).setsstatus();
                                }
                                else {
                                    System.out.println("Wrong file format.");
                                    continue;
                                }
                            }
                        }

                    }
                    else if (z == 4) {
                        System.out.println("Graded submissions: ");
                        for (int i = 0; i < quiz.size(); i++) {
                            if (stlist.get(m).getquiz().get(i).getgradstat().equals("GRADED")) {
                                System.out.println("Submission: " + stlist.get(m).getquiz().get(i).getansw());
                                System.out.println("Marks scored: " + stlist.get(m).getquiz().get(i).getmarks());
                                System.out.println("Graded by: " + stlist.get(m).getquiz().get(i).getinstruct());
                            }
                        }

                        for (int i = 0; i < assess.size(); i++) {
                            if (stlist.get(m).getassess().get(i).getgradstat().equals("GRADED")) {
                                System.out.println("Submission: " + stlist.get(m).getassess().get(i).getansw());
                                System.out.println("Marks scored: " + stlist.get(m).getassess().get(i).getmarks());
                                System.out.println("Graded by: " + stlist.get(m).getassess().get(i).getinstruct());
                            }
                        }

                        System.out.println("Ungraded submissions: ");
                        for (int i = 0; i < quiz.size(); i++) {
                            if (stlist.get(m).getquiz().get(i).getgradstat().equals("UNGRADED") && stlist.get(m).getquiz().get(i).getsstatus().equals("SUBMITTED")) {
                                System.out.println("Submission: " + stlist.get(m).getquiz().get(i).getansw());
                            }
                        }

                        for (int i = 0; i < assess.size(); i++) {
                            if (stlist.get(m).getassess().get(i).getgradstat().equals("UNGRADED") && stlist.get(m).getassess().get(i).getsstatus().equals("SUBMITTED")) {
                                System.out.println("Submission: " + stlist.get(m).getassess().get(i).getansw());
                            }
                        }
                    }
                    else if (z == 5) {
                        st.vwcomments(comments);
                    }
                    else if (z == 6) {
                        sc.nextLine();
                        System.out.print("Enter comment:");
                        String com = sc.nextLine();
                        comments.add(com + " - " + student.get(m));
                        String time = String.format("%tc", date );
                        comments.add(time);
                    }

                    else if (z == 7) {
                        break;
                    }
                }
            }
            else if (n == 3) {
                break;
            }
        }
        sc.close();
    }
}

public class classroom {
    public static void main(String[] args) {
        Backpack bk = new Backpack();
        bk.start();
    }
}
