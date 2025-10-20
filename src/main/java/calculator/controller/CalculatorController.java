package calculator.controller;

import calculator.enums.Message;
import calculator.service.CalculatorService;
import calculator.view.input.InputView;
import calculator.view.output.OutputView;
import java.math.BigDecimal;

public class CalculatorController implements Controller {

    private final InputView<String> inputView;
    private final OutputView<String> outputView;
    private final CalculatorService service;

    public CalculatorController(InputView<String> inputView, OutputView<String> outputView, CalculatorService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    @Override
    public void run() {
        outputView.print(Message.INIT.getMessage());
        String input = inputView.readLine();
        BigDecimal output = input.isEmpty() ? BigDecimal.ZERO : service.calculate(input);
        outputView.print(Message.RESULT.getMessage() + output.toString());
    }
}