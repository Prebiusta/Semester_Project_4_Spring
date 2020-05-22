package en.via.SEP4.DAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.TemperatureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TemperatureDao extends JpaRepository<TemperatureEntity, Long> {
    Page<TemperatureEntity> findByArchiveEntityId(Long archiveId, Pageable pageable);
    Page<TemperatureEntity> findByArchiveEntityIdAndDate(Long archiveId, Date date, Pageable pageable);
    Page<TemperatureEntity> findByArchiveEntityIdAndDateBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
    TemperatureEntity findFirstByArchiveEntityIdOrderByIdDesc(Long archiveId);

}
