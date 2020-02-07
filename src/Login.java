import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    //Fields
    private String userName;
    private String passWord;

    public Login(String userName, String passWord, ArrayList<Login> list) {
        this.userName = userName;
        this.passWord = passWord;

        list.add(this);
    }

    public Login(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPassWord() {

        return passWord;
    }

    public void setPassWord(String passWord) {

        this.passWord = passWord;
    }

    public static void loginAccess() {
        Scanner console = new Scanner(System.in);
        System.out.println("Do you have a login for GroceryList?");
        System.out.println("1 - I do have a login \n +" +
                "2 - I would like to register");
        int loginInput = console.nextInt();
        switch (loginInput) {
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("You can not access the list, if you don't have a login?");
                break;

        }

    }

    public void toFile() throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Login.txt"));
        output.println(userName + " " + passWord);
    }

    public void registerLogin(ArrayList<Login> test) {

        System.out.println("Enter new username:");
    }


    public static void loginCheck(ArrayList<Login> list, ArrayList<ItemOrder> listO, GroceryList2 listG) {
        boolean flag = true;
        while (flag) {
            System.out.println("Welcome to GroceryList");
            Scanner console = new Scanner(System.in);
            System.out.println("Enter Username");
            String userNameC = console.next();
            System.out.println("Enter Password");
            String passWordC = console.next();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUserName().equals(userNameC) && list.get(i).getPassWord().equals(passWordC)) {
                    System.out.println("Login approved");
                    GroceryExercise.menuSelectionAL(listO, listG);
                }

            }
            System.out.println("Username or password incorrect \nPleease try again! \n");

        }

    }

    public static ArrayList<Login> Register(ArrayList<Login> list) {
        System.out.println("Register Login for GroceryList");
        System.out.println("Username can take all symbols except for space");
        System.out.println("Enter the username:");
        String newUserName = InputHelper.getUsernameFromUser();
        System.out.println("Enter the password: \n" +
                "Password can take all symbols except for space");
        String newPassWord = InputHelper.getUsernameFromUser();


        Login temp = new Login(newUserName, newPassWord);
        list.add(temp);

        return list;
    }
}



