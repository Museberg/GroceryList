import java.util.ArrayList;
import java.util.Scanner;

public class loginList {
    //Fields
    //ArrayList<Login> loginList = new ArrayList<>();

    public static void loginCheck(ArrayList<Login> list, ArrayList<ItemOrder> listO, GroceryList2 listG) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Username");
        String userNameC = console.next();
        System.out.println("Enter Password");
        String passWordC = console.next();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getUserName().equals(userNameC) && list.get(i).getPassWord().equals(passWordC)) {
                GroceryExercise.menuSelectionAL(listO, listG);
            }

        }
        System.out.println("Sign in! \n");
        loginCheck(list,listO,listG);
    }

}


