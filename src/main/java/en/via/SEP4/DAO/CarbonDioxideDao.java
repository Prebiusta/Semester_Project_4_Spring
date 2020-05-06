package en.via.SEP4.DAO;

import en.via.SEP4.Model.CarbonDioxide;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CarbonDioxideDao extends JpaRepository<CarbonDioxide,Long> {
    Page<CarbonDioxide> findByArchiveId(Long archiveId, Pageable pageable);
    Page<CarbonDioxide> findByArchiveIdAndCreatedAt(Long archiveId, Date date);
    Page<CarbonDioxide> findByArchiveIdAndCreatedAtBetween(Long archiveId, Date date1, Date date2);
}
