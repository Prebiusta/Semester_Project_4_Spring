package en.via.SEP4.DAO;

import en.via.SEP4.Model.TemperatureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TemperatureDao extends JpaRepository<TemperatureEntity, Long> {
    Page<TemperatureEntity> findByArchiveEntityId(Long archiveId, Pageable pageable);
    Page<TemperatureEntity> findByArchiveEntityIdAndCreatedAt(Long archiveId, Date date, Pageable pageable);
    Page<TemperatureEntity> findByArchiveEntityIdAndCreatedAtBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
