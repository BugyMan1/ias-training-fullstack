package co.com.ias.training.infrastructure.controllers.models;

import java.time.LocalDateTime;

public class MaintenanceInput {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;

    public MaintenanceInput(LocalDateTime startDate, LocalDateTime endDate, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
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
