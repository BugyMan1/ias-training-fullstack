package co.com.ias.training.domain;

import org.apache.commons.lang3.Validate;

public class MaintenanceId {
    private final String value;

    public MaintenanceId(String value) {
        Validate.notNull(value, "ID cannot be null");
        Validate.isTrue(value.trim().length() == 36, "ID must be exactly 36 characters long");
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
