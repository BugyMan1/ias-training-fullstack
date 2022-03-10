package co.com.ias.training.infrastructure.gateways.models;

import co.com.ias.training.core.domain.MaintenanceDescription;
import co.com.ias.training.core.domain.MaintenanceId;
import co.com.ias.training.core.domain.MaintenanceService;

import java.time.LocalDateTime;

public class MaintenanceDBO {
    private String serviceId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;

    public MaintenanceDBO(String serviceId, LocalDateTime startDate, LocalDateTime endDate, String description) {
        this.serviceId = serviceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public MaintenanceDBO() {
    }

    public MaintenanceService toDomain() {
        return new MaintenanceService(
                new MaintenanceId(serviceId),
                startDate,
                endDate,
                new MaintenanceDescription(description)
        );
    }

    public static MaintenanceDBO fromDomain(MaintenanceService maintenanceService) {
        return new MaintenanceDBO(
                maintenanceService.getServiceId().toString(),
                maintenanceService.getStartDate(),
                maintenanceService.getEndDate(),
                maintenanceService.getDescription().toString()
        );
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
