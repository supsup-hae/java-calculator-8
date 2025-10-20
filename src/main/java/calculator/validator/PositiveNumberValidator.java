package calculator.validator;

import calculator.enums.Message;
import java.math.BigDecimal;

public class PositiveNumberValidator implements Validator<BigDecimal> {

    private static final PositiveNumberValidator INSTANCE = new PositiveNumberValidator();

    private PositiveNumberValidator() {
    }

    public static PositiveNumberValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(Message.NOT_POSITIVE.getMessage());
        }
    }
}