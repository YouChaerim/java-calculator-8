package calculator.view;

public class OutputView {
    private final String resultMessage = "결과 : ";

    public void printResult(Integer result) {
        System.out.println(resultMessage + result);
    }
}