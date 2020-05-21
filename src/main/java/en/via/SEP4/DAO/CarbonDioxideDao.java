package en.via.SEP4.DAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface CarbonDioxideDao extends JpaRepository<CarbonDioxideEntity,Long> {
    Page<CarbonDioxideEntity> findByArchiveEntityId(Long archiveId, Pageable pageable);
    Page<CarbonDioxideEntity> findByArchiveEntityIdAndDate(Long archiveId, Date date, Pageable pageable);
    Page<CarbonDioxideEntity> findByArchiveEntityIdAndDateBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
    CarbonDioxideEntity findFirstByOrderByIdDesc();
}
