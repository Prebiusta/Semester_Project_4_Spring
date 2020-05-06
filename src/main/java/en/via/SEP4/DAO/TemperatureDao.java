package en.via.SEP4.DAO;

import en.via.SEP4.Model.Temperature;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TemperatureDao extends JpaRepository<Temperature, Long> {
    Page<Temperature> findByArchiveId(Long archiveId, Pageable pageable);
    Page<Temperature> findByArchiveIdAndCreatedAt(Long archiveId, Date date);
    Page<Temperature> findByArchiveIdAndCreatedAtBetween(Long archiveId, Date date1, Date date2);
}
