package co.com.ias.training.domain;

import org.apache.commons.lang3.Validate;

import java.util.Date;

public class MaintenanceStartDate {
    private final Date value;

    public MaintenanceStartDate(Date value) {
        Validate.notNull(value, "Start datetime cannot be null");
//        Validate.isTrue(value.after());
        this.value = value;
    }
}
