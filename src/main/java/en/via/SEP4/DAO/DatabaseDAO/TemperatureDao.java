package en.via.SEP4.DAO.DatabaseDAO;



import en.via.SEP4.Model.DBModel.TemperatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TemperatureDao extends JpaRepository<TemperatureEntity, Long> {
    List<TemperatureEntity> findByArchiveEntityId(Long archiveId);
    List<TemperatureEntity> findByArchiveEntityIdAndDateBetween(Long archiveId, Date startDate, Date endDate);
    TemperatureEntity findFirstByArchiveEntityIdOrderByIdDesc(Long archiveId);

}
