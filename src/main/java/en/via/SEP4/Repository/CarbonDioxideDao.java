package en.via.SEP4.Repository;

import en.via.SEP4.Model.CarbonDioxideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CarbonDioxideDao extends JpaRepository<CarbonDioxideEntity,Long> {
    Page<CarbonDioxideEntity> findByArchiveId(Long archiveId, Pageable pageable);
    Page<CarbonDioxideEntity> findByArchiveIdAndCreatedAt(Long archiveId, Date date, Pageable pageable);
    Page<CarbonDioxideEntity> findByArchiveIdAndCreatedAtBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
