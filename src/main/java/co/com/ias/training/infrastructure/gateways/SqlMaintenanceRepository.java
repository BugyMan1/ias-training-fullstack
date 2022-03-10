package co.com.ias.training.infrastructure.gateways;

import co.com.ias.training.core.domain.MaintenanceId;
import co.com.ias.training.core.domain.MaintenanceService;
import co.com.ias.training.core.gateways.MaintenanceRepository;
import co.com.ias.training.infrastructure.controllers.models.MaintenanceDTO;
import co.com.ias.training.infrastructure.gateways.models.MaintenanceDBO;
import co.com.ias.training.shared.domain.PageQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SqlMaintenanceRepository implements MaintenanceRepository {
    private final DataSource dataSource;

    public SqlMaintenanceRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<MaintenanceService> findAll(PageQuery pageQuery) {
        String query = "SELECT * FROM maintenances LIMIT ? OFFSET ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, pageQuery.getLimit().getValue());
            preparedStatement.setInt(2, pageQuery.getSkip().getValue());

            ResultSet resultSet = preparedStatement.executeQuery();
            List<MaintenanceService> result = new ArrayList<>();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            while (resultSet.next()) {
                MaintenanceDBO dbo = new MaintenanceDBO();
                dbo.setServiceId(resultSet.getString("service_id"));
                dbo.setStartDate(LocalDateTime.parse(resultSet.getString("start_date"), formatter));
                dbo.setEndDate(LocalDateTime.parse(resultSet.getString("end_date"), formatter));
                dbo.setDescription(resultSet.getString("description"));
                MaintenanceService domainMaintenanceService = dbo.toDomain();
                result.add(domainMaintenanceService);
            }

            resultSet.close();
            return result;

        } catch (SQLException ex) {
           throw new RuntimeException("Error querying database", ex);
        }
    }

    @Override
    public Optional<MaintenanceService> findById(MaintenanceId maintenanceId) {
        return Optional.empty();
    }

    @Override
    public void save(MaintenanceService maintenanceService) {

    }
}
