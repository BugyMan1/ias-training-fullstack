package co.com.ias.training.controller.models;

import java.util.Date;

public class MaintenanceInput {
    private Date startDate;
    private Date endDate;
    private String description;

    public MaintenanceInput(Date startDate, Date endDate, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
