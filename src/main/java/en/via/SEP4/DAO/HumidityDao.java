package en.via.SEP4.DAO;

import en.via.SEP4.Model.Humidity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface HumidityDao extends JpaRepository<Humidity,Long> {
    Page<Humidity> findByArchiveId(Long archiveId, Pageable pageable);
    Page<Humidity> findByArchiveIdAndCreatedAt(Long archiveId, Date date);
    Page<Humidity> findByArchiveIdAndCreatedAtBetween(Long archiveId, Date date1, Date date2);
}
