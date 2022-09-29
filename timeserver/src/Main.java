public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the server . . .");
        Timeserver timeserver = new TimeserverImpl();
        timeserver.start();
    }
}