package en.via.SEP4.DAO.DatabaseDAO;

import en.via.SEP4.Model.DBModel.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorDao extends JpaRepository<SensorEntity, Long> {
    Optional<SensorEntity> findByArchiveEntity_Id(Long archiveId);
}
