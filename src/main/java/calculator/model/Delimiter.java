package calculator.model;

import calculator.validator.DelimiterValidator;

public class Delimiter {
    private final String value;

    private Delimiter(String value) {
        DelimiterValidator validator = DelimiterValidator.getInstance();
        validator.validate(value);
        this.value = value;
    }

    public static Delimiter of(String value) {
        return new Delimiter(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Delimiter delimiter)) {
            return false;
        }
        return value.equals(delimiter.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}