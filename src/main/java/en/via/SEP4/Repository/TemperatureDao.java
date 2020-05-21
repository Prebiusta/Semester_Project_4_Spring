package en.via.SEP4.Repository;

import en.via.SEP4.Model.TemperatureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TemperatureDao extends JpaRepository<TemperatureEntity, Long> {
    Page<TemperatureEntity> findByArchiveId(Long archiveId, Pageable pageable);
    Page<TemperatureEntity> findByArchiveIdAndCreatedAt(Long archiveId, Date date, Pageable pageable);
    Page<TemperatureEntity> findByArchiveIdAndCreatedAtBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
