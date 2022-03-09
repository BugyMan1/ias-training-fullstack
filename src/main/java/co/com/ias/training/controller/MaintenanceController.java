package co.com.ias.training.controller;

import co.com.ias.training.controller.models.MaintenanceDTO;
import co.com.ias.training.controller.models.MaintenanceInput;
import co.com.ias.training.domain.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/services")
public class MaintenanceController {

    @GetMapping
    public List<MaintenanceDTO> listAllMaintenances(@RequestParam(name = "limit", defaultValue = "50") Integer limit,
                                                    @RequestParam(name ="skip", defaultValue = "0") Integer skip) {
        return List.of();
    }

    @GetMapping("{id}")
    public MaintenanceDTO getMaintenanceById(@PathVariable("id") String serviceId) {
        return new MaintenanceDTO(
                serviceId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                "fakeDescription"
        );
    }

    @PostMapping
    public MaintenanceDTO createMaintenance(@RequestBody MaintenanceInput maintenanceInput) throws ParseException {
        MaintenanceService maintenanceService = new MaintenanceService(
                new MaintenanceId(UUID.randomUUID().toString()),
                maintenanceInput.getStartDate(),
                maintenanceInput.getEndDate(),
                new MaintenanceDescription(maintenanceInput.getDescription())
        );
        return MaintenanceDTO.fromDomain(maintenanceService);
    }
}
