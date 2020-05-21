package en.via.SEP4.Repository;

import en.via.SEP4.Model.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface HumidityDao extends JpaRepository<HumidityEntity,Long> {
    Page<HumidityEntity> findByArchiveId(Long archiveId, Pageable pageable);
    Page<HumidityEntity> findByArchiveIdAndCreatedAt(Long archiveId, Date date, Pageable pageable);
    Page<HumidityEntity> findByArchiveIdAndCreatedAtBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
