import java.util.ArrayList;
import java.util.Scanner;

public class Authenticate<T> {
    private static Authenticate instance;

    private Authenticate() {
    }

    public static Authenticate getInstance() {
        if (instance == null) {
            instance = new Authenticate();
        }
        return instance;
    }

    public Person auth(ArrayList<T> persons) {
        Scanner sc = new Scanner(System.in);
        Boolean auth = false;

        System.out.print("Enter your email");
        String emailAuth = sc.nextLine();
        System.out.print("Enter your password");
        String passwordAuth = sc.nextLine();

        for (T x : persons) {
            if ((((Person) x).email.equals(emailAuth)) && ((Person) x).verifypassword(passwordAuth)) {
                return (Person) x;
            }
        }

        return null;
    }
}