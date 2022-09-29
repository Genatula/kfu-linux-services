import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the client . . .");
        Timeclient timeclient = new TimeclientImpl();
        try {
            timeclient.connect("127.0.0.1");
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP-address");
        }
    }
}