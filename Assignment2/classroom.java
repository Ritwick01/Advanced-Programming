import java.util.ArrayList;

import java.util.*;
class Backpack {
    private int intuct;
    private int stu;
    private ArrayList<String> instructor = new ArrayList<>();
    private ArrayList<String> student = new ArrayList<>();

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
