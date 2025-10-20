package calculator.model;

import static calculator.constants.Symbol.*;

public class Separator {
    private final String defaultSeparator = ",:";
    private final String separator;

    public Separator(String expression) {
        this.separator = extractSeparator(expression);
    }

    private String extractSeparator(String expression) {
        String defaultSeparator = this.defaultSeparator;
        if (expression.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int start = expression.indexOf(CUSTOM_DELIMITER_PREFIX) + PREFIX_OFFSET;
            int end = expression.indexOf(CUSTOM_DELIMITER_SUFFIX);
            String customSeparator = expression.substring(start, end);
            if (customSeparator.contains(BACKSLASH)) {
                customSeparator = customSeparator.replace(BACKSLASH, BACKSLASH + BACKSLASH);
            }
            return customSeparator;
        }
        return defaultSeparator;
    }

    public String getSeparator() {
        return separator;
    }
}