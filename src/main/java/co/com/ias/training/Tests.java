package co.com.ias.training;

import co.com.ias.training.domain.*;

import java.util.Date;
import java.util.UUID;

public class Tests {
    public static void main(String[] args) {
        MaintenanceId maintenanceId = new MaintenanceId(UUID.randomUUID().toString());

        new Maintenance(
                maintenanceId,
                new MaintenanceStartDate(new Date()),
                new MaintenanceEndDate(new Date()),
                new MaintenanceDescription("Any description"));
    }
}
