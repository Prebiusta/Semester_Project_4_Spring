package en.via.SEP4.DAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface CarbonDioxideDao extends JpaRepository<CarbonDioxideEntity, Long> {
    CarbonDioxideEntity findFirstByArchiveEntityIdOrderByIdDesc(Long archiveId);

    List<CarbonDioxideEntity> findByArchiveEntityId(Long archiveId);

    List<CarbonDioxideEntity> findByArchiveEntityIdAndDateBetween(Long archiveId, Date startDate, Date endDate);
}
