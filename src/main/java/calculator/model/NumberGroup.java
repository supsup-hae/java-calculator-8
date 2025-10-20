package calculator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberGroup {
    private final List<Number> values;

    public NumberGroup(List<Number> values) {
        this.values = new ArrayList<>(values);
    }

    public NumberGroup add(Number number) {
        List<Number> newValues = new ArrayList<>(this.values);
        newValues.add(number);
        return new NumberGroup(newValues);
    }

    public BigDecimal sum() {
        return values.stream()
                .map(Number::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}