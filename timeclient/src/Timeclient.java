import java.net.UnknownHostException;

public interface Timeclient {
    void connect(String address) throws UnknownHostException;
}
