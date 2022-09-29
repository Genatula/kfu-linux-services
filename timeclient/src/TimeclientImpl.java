import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.nio.CharBuffer;

public class TimeclientImpl implements Timeclient {
    private static final int PORT = 1303;

    private final Validator<String> addressValidator;

    private Socket socket;

    public TimeclientImpl() {
        this.socket = new Socket();
        this.addressValidator = new AddressValidator();
    }

    @Override
    public void connect(String address) throws UnknownHostException {
        if (!addressValidator.isValid(address)) {
            System.err.println("Provided IP-address is not valid");
        }
        else {
            InetSocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName(address), PORT);
            try {
                socket.connect(socketAddress, PORT);
                System.out.println("The client has started successfully!");
                try (Reader reader = new InputStreamReader(socket.getInputStream())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    int character = reader.read();
                    while (character != -1) {
                        stringBuilder.append((char) character);
                        character = reader.read();
                    }
                    System.out.println(stringBuilder);
                }
            } catch (IOException e) {
                System.err.println("Couldn't connect to the server");
                System.exit(-1);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println("Couldn't close the socket");
                    System.exit(-1);
                }
            }
        }
    }
}
