import java.util.ArrayList;

public interface Same {

    default void vwlecmat() {
        Backpack bkp = new Backpack();
        ArrayList<String> arr = new ArrayList<>();
        arr = bkp.getmat();
        for (int i = 0; i < arr.size(); ++i) {
            System.out.println(arr.get(i));
        }

    }
    default void vwassess() {

    }
    default void vwcomments() {

    }
    default void addcomments() {

    }
    default void logout() {

    }
}
