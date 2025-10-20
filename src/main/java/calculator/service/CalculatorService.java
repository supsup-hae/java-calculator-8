package calculator.service;

import calculator.model.NumberGroup;
import calculator.parser.NumberExtractor;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorService {
    public static final int SCALE = 2;
    private final NumberExtractor numberExtractor;

    public CalculatorService(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }

    public BigDecimal calculate(String input) {
        NumberGroup numberGroup = numberExtractor.extract(input);
        BigDecimal sum = numberGroup.sum();
        return isRealNumber(sum) ? sum.setScale(SCALE, RoundingMode.HALF_UP) : sum;
    }

    private boolean isRealNumber(BigDecimal value) {
        return value.stripTrailingZeros().scale() > 0;
    }
}
