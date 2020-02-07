import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws FileNotFoundException {
        ArrayList<Login> test1 = new ArrayList<>();
        Login test = new Login("Arne", "1234", test1);
        Login test2 = new Login("BNent", "2222", test1);
        test1.add(test);
        test1.add(test2);

       test.Register(test1);
    }
}
