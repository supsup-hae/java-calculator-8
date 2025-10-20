package calculator.view.output;

public class ConsoleOutputView implements OutputView<String>{

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}