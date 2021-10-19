import java.util.ArrayList;

public interface Same {
    Backpack bkp = new Backpack();
    
    default void vwlecmat(ArrayList<String> arr) {
        
        for (int i = 0; i < arr.size(); ++i) {
            System.out.println(arr.get(i));
        }

    }
    default void vwassess(ArrayList<assessment> quiz, ArrayList<assessment> assess) {
        System.out.println("Quizzes");
        for (int i = 0; i < quiz.size(); ++i) {
            System.out.println("ID: " + i + " " + quiz.get(i).getquiz()); 
            System.out.println("--------------------------------------");    
        }
        System.out.println("Assignments");
        for (int i = 0; i < assess.size(); ++i) {
            System.out.println("ID: " + (i + quiz.size()) + " " + assess.get(i).getassess());     
            System.out.println("--------------------------------------");    
        }
    }
    default void vwcomments() {

    }
    default void addcomments() {

    }
    default void logout() {

    }
}
