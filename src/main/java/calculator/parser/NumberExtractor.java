package calculator.parser;

import calculator.model.DelimiterGroup;
import calculator.model.Number;
import calculator.model.NumberGroup;
import java.util.Arrays;
import java.util.List;

public class NumberExtractor implements Extractor<String, NumberGroup> {
    private final CustomDelimiterExtractor customDelimiterExtractor;

    public NumberExtractor(CustomDelimiterExtractor customDelimiterExtractor) {
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    @Override
    public NumberGroup extract(String input) {
        DelimiterGroup delimiters = extractDelimiters(input);
        String numbersText = extractNumbersText(input);
        List<Number> numbers = parseNumbers(numbersText, delimiters);
        return new NumberGroup(numbers);
    }

    private DelimiterGroup extractDelimiters(String input) {
        DelimiterGroup defaultDelimiters = DelimiterGroup.withDefaultDelimiter();
        return customDelimiterExtractor.extract(input)
                .map(defaultDelimiters::addCustomDelimiter)
                .orElse(defaultDelimiters);
    }

    private String extractNumbersText(String input) {
        return customDelimiterExtractor.removeCustomDelimiter(input);
    }

    private List<Number> parseNumbers(String numbersText, DelimiterGroup delimiters) {
        String[] tokens = delimiters.split(numbersText);
        return Arrays.stream(tokens)
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .map(Number::of)
                .toList();
    }
}