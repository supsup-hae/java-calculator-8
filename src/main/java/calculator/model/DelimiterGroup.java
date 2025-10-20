package calculator.model;

import calculator.enums.DefaultDelimiter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DelimiterGroup {
    private final List<Delimiter> delimiters;

    public DelimiterGroup(List<Delimiter> delimiters) {
        this.delimiters = new ArrayList<>(delimiters);
    }

    public static DelimiterGroup withDefaultDelimiter() {
        return new DelimiterGroup(DefaultDelimiter.getAllAsDelimiterGroup());
    }

    public DelimiterGroup addCustomDelimiter(String customDelimiter) {
        List<Delimiter> newDelimiters = new ArrayList<>(this.delimiters);
        newDelimiters.add(Delimiter.of(customDelimiter));
        return new DelimiterGroup(newDelimiters);
    }

    public String[] split(String input) {
        String pattern = delimiters.stream()
                .map(Delimiter::getValue)
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
        return input.split(pattern);
    }
}