package co.com.ias.training;

import co.com.ias.training.domain.*;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.util.Date;
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
