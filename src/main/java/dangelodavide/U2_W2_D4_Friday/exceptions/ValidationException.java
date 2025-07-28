package dangelodavide.U2_W2_D4_Friday.exceptions;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("Errore di validazione");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
