package calculator.validator;

import calculator.enums.Message;
import java.util.regex.Pattern;

public class NumberValidator implements Validator<String> {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static final NumberValidator INSTANCE = new NumberValidator();

    private NumberValidator() {
    }

    public static NumberValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(String input) {
        if (!NUMBER_PATTERN.matcher(input.trim()).matches()) {
            throw new IllegalArgumentException(Message.ILLEGAL_NUMBER_FORMAT.getMessage() + input);
        }
    }
}