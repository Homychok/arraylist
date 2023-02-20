package homework.exception;
import java.util.NoSuchElementException;
public class ElementNotFoundException extends NoSuchElementException {
    public ElementNotFoundException(String e) {
        super(e);
    }
}
