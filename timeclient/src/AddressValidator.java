import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator implements Validator<String> {
    private final Pattern addressPattern;

    public AddressValidator() {
        addressPattern = Pattern.compile("^((25[0-5]|(2[0-4]|1\\d|[1-9]|)\\d)\\.?\\b){4}$");
    }

    @Override
    public boolean isValid(String object) {
        Matcher matcher = addressPattern.matcher(object);
        return matcher.matches();
    }
}
