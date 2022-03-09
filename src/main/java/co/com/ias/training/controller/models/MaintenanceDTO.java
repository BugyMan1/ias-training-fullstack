package co.com.ias.training.controller.models;

import co.com.ias.training.domain.Maintenance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MaintenanceDTO {
    private String serviceId;
    private Date startDate;
    private Date endDate;
    private String description;

    public MaintenanceDTO(String serviceId, Date startDate, Date endDate, String description) {
        this.serviceId = serviceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public static MaintenanceDTO fromDomain(Maintenance maintenance) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = formatter.parse(maintenance.getStartDate().toString());
        Date endDate = formatter.parse(maintenance.getEndDate().toString());
        return new MaintenanceDTO(
                maintenance.getServiceId().toString(),
                startDate,
                endDate,
                maintenance.getDescription().toString()
        );
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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
