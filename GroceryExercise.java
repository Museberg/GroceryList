import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class GroceryExercise {
    public static void main(String [] args) throws FileNotFoundException {
        ArrayList<ItemOrder> listt = new ArrayList<>();
        GroceryList a = new GroceryList();
        //String pattern = "dd-MM-yyyy HH:mm:ss";
        //SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM/yyyy HH:mm:ss");
        Date date = new Date();
        ItemOrder o = new ItemOrder("Milk", 1, 3);
        GroceryList2 listG = new GroceryList2();
        menuSelectionAL(listt, listG);
        //menuSelectionA(a, date, o);



        //System.out.println(list);

       /* new ItemOrder("milk", 2, 10,a);
        new ItemOrder("l", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
        new ItemOrder("milk", 2, 10,a);
       new ItemOrder("milk", 2, 10,a);
        System.out.println(a);
        a.readFromFile();*/
    }

    public static void menuSelectionA(GroceryList list,  Date Time, ItemOrder o) {
        SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM/yyyy HH:mm");
        System.out.println("\nCurrent LocalTime: " + sdf.format(Time));
        Scanner console = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Welcome to GroceryList \n");
            System.out.println("Enter 1 - Add item \n" +
                    "Enter 2 - Show list \n" +
                    "Enter 3 - Calculate total cost \n" +
                    "Enter 4 - Exit");
            int chose = console.nextInt();
                switch(chose) {
                    case 1:
                        list.addItem(o);
                        break;
                    case 2:
                        list.printList();
                        break;
                    case 3:
                        list.getTotalCost();
                        break;
                    case 4:
                        System.out.println("Exiting program");
                        flag = false;
                        break;
                    default:
                        System.out.println("Input format is incorrect \nPick a number between 1 and 4.");
                        break;
                }
        }
    }

    public static void menuSelectionAL(ArrayList<ItemOrder> listA, GroceryList2 listG) {
        Scanner console = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Welcome to GroceryList");
            System.out.println("Enter 1 - Add item \n" +
                    "Enter 2 - Remove Item \n" +
                    "Enter 3 - Calculate total cost \n" +
                    "Enter 4 - Print list \n" +
                    "Enter 5 - Exit program");
            int chose = console.nextInt();
                switch(chose) {
                    case 1:
                        listG.addItem(listA);
                        break;
                    case 2:
                        listG.removeItem(listA);
                        break;
                    case 3:
                        listG.getTotalCost(listA);
                        break;
                    case 4:
                        listG.printList(listA);
                        break;
                    case 5:
                        System.out.println("Exiting program ...");
                        flag = false;
                        break;
                }

        }
    }
}
