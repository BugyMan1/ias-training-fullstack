package co.com.ias.training.repository.models;

import co.com.ias.training.domain.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class MaintenanceDBO {
    private String serviceId;
    private Date startDate;
    private Date endDate;
    private String description;

    public MaintenanceDBO(String serviceId, Date startDate, Date endDate, String description) {
        this.serviceId = serviceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public MaintenanceDBO() {
    }

    public Maintenance toDomain() {
        return new Maintenance(
                new MaintenanceId(serviceId),
                new MaintenanceStartDate(startDate),
                new MaintenanceEndDate(endDate),
                new MaintenanceDescription(description)
        );
    }

    public static MaintenanceDBO fromDomain(Maintenance maintenance) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = formatter.parse(maintenance.getStartDate().toString());
        Date endDate = formatter.parse(maintenance.getEndDate().toString());
        return new MaintenanceDBO(
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
