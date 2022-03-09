package co.com.ias.training.domain;

import org.apache.commons.lang3.Validate;

import java.util.Date;

public class MaintenanceEndDate {
    private final Date value;

    public MaintenanceEndDate(Date value) {
        Validate.notNull(value, "End datetime cannot be null");
//        Validate.isTrue(value.after());
        this.value = value;
    }
}
