package co.com.ias.training;

import co.com.ias.training.core.domain.MaintenanceDescription;
import co.com.ias.training.core.domain.MaintenanceId;
import co.com.ias.training.core.domain.MaintenanceService;

import java.time.LocalDateTime;
import java.util.UUID;

public class Tests {
    public static void main(String[] args) {
        MaintenanceId maintenanceId = new MaintenanceId(UUID.randomUUID().toString());

        new MaintenanceService(
                maintenanceId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new MaintenanceDescription("Any description"));
    }
}
