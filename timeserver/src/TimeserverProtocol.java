import java.time.LocalDateTime;

public class TimeserverProtocol {
    public static String getMessage() {
        return LocalDateTime.now().toString();
    }
}
