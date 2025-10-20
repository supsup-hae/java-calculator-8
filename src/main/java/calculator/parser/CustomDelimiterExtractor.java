package calculator.parser;

import java.util.Optional;

public class CustomDelimiterExtractor implements Extractor<String, Optional<String>> {
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
    private static final int DELIMITER_SUFFIX_LENGTH = 2;
    private static final int NOT_FOUND_INDEX = -1;

    public Optional<String> extract(String input) {
        if (!hasCustomDelimiterPrefix(input)) {
            return Optional.empty();
        }

        int separatorIndex = findSeparatorIndex(input);

        if (isInvalidSeparatorIndex(separatorIndex)) {
            return Optional.empty();
        }

        String delimiter = extractDelimiterValue(input, separatorIndex);
        return delimiter.isEmpty() ? Optional.empty() : Optional.of(delimiter);
    }

    public String removeCustomDelimiter(String input) {
        if (!hasCustomDelimiterPrefix(input)) {
            return input;
        }

        int index = findSeparatorIndex(input);
        return isInvalidSeparatorIndex(index) ? input : input.substring(index + DELIMITER_SUFFIX_LENGTH);
    }

    private boolean hasCustomDelimiterPrefix(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private int findSeparatorIndex(String input) {
        return input.indexOf(CUSTOM_DELIMITER_SUFFIX);
    }

    private boolean isInvalidSeparatorIndex(int index) {
        return index == NOT_FOUND_INDEX;
    }

    private String extractDelimiterValue(String input, int separatorIndex) {
        return input.substring(CUSTOM_DELIMITER_PREFIX.length(), separatorIndex);
    }
}