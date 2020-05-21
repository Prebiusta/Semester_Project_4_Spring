package en.via.SEP4.DAO;

import en.via.SEP4.Model.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface HumidityDao extends JpaRepository<HumidityEntity,Long> {
    Page<HumidityEntity> findByArchiveEntityId(Long archiveId, Pageable pageable);
    Page<HumidityEntity> findByArchiveEntityIdAndCreatedAt(Long archiveId, Date date, Pageable pageable);
    Page<HumidityEntity> findByArchiveEntityIdAndCreatedAtBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
