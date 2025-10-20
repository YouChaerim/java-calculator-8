package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.constants.Symbol.END_BRACKET;
import static calculator.constants.Symbol.START_BRACKET;

public class Terms {
    private final List<Term> terms;

    public Terms(String expression, Separator separator) {
        this.terms = parseTerms(expression, separator);
    }

    private List<Term> parseTerms(String expression, Separator separator) {
        String[] parts = expression.split(START_BRACKET + separator.getSeparator() + END_BRACKET);
        return Arrays.stream(parts)
                .map(Term::new)
                .collect(Collectors.toList());
    }

    public Integer addition() {
        return terms.stream()
                .mapToInt(Term::getValue)
                .sum();
    }
}