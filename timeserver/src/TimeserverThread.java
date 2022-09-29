import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class TimeserverThread extends Thread {
    private final Socket socket;

    public TimeserverThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Writer writer = new OutputStreamWriter(socket.getOutputStream())) {
            writer.write(TimeserverProtocol.getMessage());
            writer.flush();
            socket.close();
        } catch (IOException e) {
            System.err.println("Couldn't connect to the socket");
            System.exit(-1);
        }
    }
}
