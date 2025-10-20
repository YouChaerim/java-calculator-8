package calculator.model;

import java.util.regex.Pattern;

import static calculator.constants.Symbol.*;

public class Expression {
    private final String numberRegex = "0-9";
    private final String errorMessage = "유효하지 않은 문자가 포함되어 있습니다.";
    private final Separator separator;
    private final Terms terms;

    public Expression(String expression) {
        this.separator = new Separator(expression);
        validateExpression(expression);
        this.terms = new Terms(extractFormulaPart(expression), separator);
    }

    private void validateExpression(String expression) {
        expression = extractFormulaPart(expression);
        if (hasInvalidinput(expression)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean hasInvalidinput(String expression) {
        String totalSeparator = separator.getSeparator();
        String regex = START_BRACKET + numberRegex + Pattern.quote(totalSeparator) + END_BRACKET + ASTERISK;
        return !expression.matches(regex);
    }

    private boolean hasCustomSeparator(String expression) {
        return expression.startsWith(CUSTOM_DELIMITER_PREFIX) && expression.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private String extractFormulaPart(String expression) {
        if (hasCustomSeparator(expression)) {
            return extractCustomExpression(expression);
        }
        return expression;
    }

    private String extractCustomExpression(String expression) {
        int start = expression.indexOf(CUSTOM_DELIMITER_SUFFIX) + PREFIX_OFFSET;
        return expression.substring(start);
    }

    public Terms getTerms() {
        return terms;
    }
}