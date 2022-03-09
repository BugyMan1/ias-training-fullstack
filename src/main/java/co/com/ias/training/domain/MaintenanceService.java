package co.com.ias.training.domain;

import org.apache.commons.lang3.Validate;

import java.time.LocalDateTime;

public class MaintenanceService {
    private final MaintenanceId serviceId;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final MaintenanceDescription description;

    public MaintenanceService(MaintenanceId serviceId,
                              LocalDateTime startDate,
                              LocalDateTime endDate,
                              MaintenanceDescription description) {

        this.serviceId = Validate.notNull(serviceId);
        this.startDate = Validate.notNull(startDate);
        Validate.isTrue(startDate.isBefore(LocalDateTime.now()), "Start date cannot be a future date");
        this.endDate = Validate.notNull(endDate);
        Validate.isTrue(endDate.isAfter(startDate) && endDate.isBefore(LocalDateTime.now()),
                "End date cannot be earlier than the start date or a future date");
        this.description = Validate.notNull(description);
    }

    public MaintenanceId getServiceId() {
        return serviceId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public MaintenanceDescription getDescription() {
        return description;
    }
}
