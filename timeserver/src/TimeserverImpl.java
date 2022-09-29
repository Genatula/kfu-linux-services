import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeserverImpl implements Timeserver {
    private ServerSocket serverSocket;
    private InetSocketAddress socketAddress;

    private static final int PORT = 1303;

    public TimeserverImpl() {
        try {
            this.socketAddress = new InetSocketAddress(InetAddress.getLocalHost(), PORT);
            this.serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Couldn't create the server");
            System.exit(-1);
        }
    }

    @Override
    public void start() {
        if (serverSocket != null && socketAddress != null) {
            try {
                this.serverSocket.bind(socketAddress);
                System.out.println("The server has started successfully!");
                while (true) {
                    Socket socket = serverSocket.accept();
                    TimeserverThread timeserverThread = new TimeserverThread(socket);
                    timeserverThread.start();
                }
            } catch (IOException e) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.err.println("Couldn't close the server");
                    System.exit(-1);
                }
                System.err.println("Couldn't bind the server to an address");
                System.exit(-1);
            }
        }
    }
}
