package co.com.ias.training.core.gateways;

import co.com.ias.training.core.domain.MaintenanceId;
import co.com.ias.training.core.domain.MaintenanceService;
import co.com.ias.training.shared.domain.PageQuery;

import java.util.List;
import java.util.Optional;

public interface MaintenanceRepository {
    List<MaintenanceService> findAll(PageQuery pageQuery);

    Optional<MaintenanceService> findById(MaintenanceId maintenanceId);

    void save(MaintenanceService maintenanceService);
}
