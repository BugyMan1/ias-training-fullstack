package co.com.ias.training.domain;

public class Maintenance {
    private final MaintenanceId serviceId;
    private final MaintenanceStartDate startDate;
    private final MaintenanceEndDate endDate;
    private final MaintenanceDescription description;

    public Maintenance(MaintenanceId serviceId,
                       MaintenanceStartDate startDate,
                       MaintenanceEndDate endDate,
                       MaintenanceDescription description) {

        this.serviceId = serviceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public MaintenanceId getServiceId() {
        return serviceId;
    }

    public MaintenanceStartDate getStartDate() {
        return startDate;
    }

    public MaintenanceEndDate getEndDate() {
        return endDate;
    }

    public MaintenanceDescription getDescription() {
        return description;
    }
}
