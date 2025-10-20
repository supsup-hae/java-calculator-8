package calculator.validator;

import calculator.enums.Message;

public class DelimiterValidator implements Validator<String>{
    private static final DelimiterValidator INSTANCE = new DelimiterValidator();

    private DelimiterValidator() {
    }

    public static DelimiterValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_DELIMITER.getMessage());
        }
    }
}