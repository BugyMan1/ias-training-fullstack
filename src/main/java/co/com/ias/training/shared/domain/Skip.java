package co.com.ias.training.shared.domain;

import org.apache.commons.lang3.Validate;

public class Skip {
    private final Integer value;

    public Skip(Integer value) {
        Validate.notNull(value, "Skip cannot be null");
        Validate.isTrue(value >= 0, "Skip cannot be negative");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
