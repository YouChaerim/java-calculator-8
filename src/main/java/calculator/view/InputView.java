package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String inputExpressionMessage = "덧셈할 문자열을 입력해 주세요.";

    public String inputAdditionString() {
        System.out.println(inputExpressionMessage);
        return Console.readLine();
    }
}