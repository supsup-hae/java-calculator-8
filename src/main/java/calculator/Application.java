package calculator;

import calculator.controller.Controller;
import calculator.factory.CalculatorFactory;

public class Application {
    public static void main(String[] args) {
        Controller controller = CalculatorFactory.createController();
        controller.run();
    }
}
