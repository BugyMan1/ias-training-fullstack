package co.com.ias.training.infrastructure.controllers;

import co.com.ias.training.core.gateways.MaintenanceRepository;
import co.com.ias.training.infrastructure.controllers.models.MaintenanceDTO;
import co.com.ias.training.infrastructure.controllers.models.MaintenanceInput;
import co.com.ias.training.core.domain.MaintenanceDescription;
import co.com.ias.training.core.domain.MaintenanceId;
import co.com.ias.training.core.domain.MaintenanceService;
import co.com.ias.training.shared.domain.Limit;
import co.com.ias.training.shared.domain.PageQuery;
import co.com.ias.training.shared.domain.Skip;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/services")
public class MaintenanceController {
    private final MaintenanceRepository repository;

    public MaintenanceController(MaintenanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MaintenanceDTO> listAllMaintenances(@RequestParam(name = "limit", defaultValue = "50") Integer limit,
                                                    @RequestParam(name ="skip", defaultValue = "0") Integer skip) {

        PageQuery pageQuery = new PageQuery(new Skip(skip), new Limit(limit));
        List<MaintenanceService> maintenances = repository.findAll(pageQuery);

        List<MaintenanceDTO> result = new ArrayList<>();
        for (MaintenanceService maintenance: maintenances) {
            MaintenanceDTO dto = MaintenanceDTO.fromDomain(maintenance);
            result.add(dto);
        }
        return result;
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
    public MaintenanceDTO createMaintenance(@RequestBody MaintenanceInput maintenanceInput) {
        MaintenanceService maintenanceService = new MaintenanceService(
                new MaintenanceId(UUID.randomUUID().toString()),
                maintenanceInput.getStartDate(),
                maintenanceInput.getEndDate(),
                new MaintenanceDescription(maintenanceInput.getDescription())
        );
        return MaintenanceDTO.fromDomain(maintenanceService);
    }
}
