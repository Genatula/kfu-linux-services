import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the client . . .");
        Timeclient timeclient = new TimeclientImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP-address: ");
        String userInput = scanner.next();
        try {
            timeclient.connect(userInput);
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP-address");
        }
    }
}