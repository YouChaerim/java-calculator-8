package calculator.model;

public class Term {
    private final String errorMessage = "유효하지 않은 숫자 항입니다: ";
    private final String validNumberRegex = "\\d+";
    private final int value;

    public Term(String value) {
        this.value = validate(value);
    }

    private int validate(String value) {
        if (value.isBlank()) {
            return 0;
        }
        validateNumberFormat(value);
        return Integer.parseInt(value);
    }

    private void validateNumberFormat(String value) {
        if (isInvalidNumberFormat(value)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isInvalidNumberFormat(String value) {
        return !value.matches(validNumberRegex);
    }

    public int getValue() {
        return value;
    }
}