package calculator.factory;

import calculator.controller.CalculatorController;
import calculator.parser.CustomDelimiterExtractor;
import calculator.parser.NumberExtractor;
import calculator.service.CalculatorService;
import calculator.view.input.ConsoleInputView;
import calculator.view.input.InputView;
import calculator.view.output.ConsoleOutputView;
import calculator.view.output.OutputView;

public class CalculatorFactory {

    private CalculatorFactory() {
    }

    public static CalculatorController createController() {
        InputView<String> inputView = new ConsoleInputView();
        OutputView<String> outputView = new ConsoleOutputView();
        CustomDelimiterExtractor customDelimiterExtractor = new CustomDelimiterExtractor();
        NumberExtractor numberExtractor = new NumberExtractor(customDelimiterExtractor);
        CalculatorService service = new CalculatorService(numberExtractor);
        return new CalculatorController(inputView, outputView, service);
    }
}