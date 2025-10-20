package calculator.enums;

import calculator.model.Delimiter;
import java.util.Arrays;
import java.util.List;

public enum DefaultDelimiter {
    COMMA(","),
    COLON(":");

    private final String value;

    DefaultDelimiter(String value) {
        this.value = value;
    }

    public Delimiter toDelimiter() {
        return Delimiter.of(value);
    }

    public static List<Delimiter> getAllAsDelimiterGroup() {
        return Arrays.stream(values())
                .map(DefaultDelimiter::toDelimiter)
                .toList();
    }
}