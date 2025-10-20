package calculator.model;

import calculator.validator.NumberValidator;
import calculator.validator.PositiveNumberValidator;
import java.math.BigDecimal;

public class Number {
    private final BigDecimal value;

    private Number(String value) {
        NumberValidator validator = NumberValidator.getInstance();
        PositiveNumberValidator positiveValidator = PositiveNumberValidator.getInstance();

        validator.validate(value);
        BigDecimal bigDecimal = mapToBigDecimal(value);
        positiveValidator.validate(bigDecimal);

        this.value = bigDecimal;
    }

    public static Number of(String value) {
        return new Number(value);
    }

    private BigDecimal mapToBigDecimal(String number) {
        return new BigDecimal(number);
    }

    public BigDecimal getValue() {
        return value;
    }
}