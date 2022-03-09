package co.com.ias.training.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceDescription {
    private final String value;

    public MaintenanceDescription(String value) {
        Validate.notNull(value, "Description cannot be null");
        Validate.notBlank(value, "Description cannot be empty");
        Validate.isTrue(value.trim().length() < 512, "Description cannot be longer than 512 characters");
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
