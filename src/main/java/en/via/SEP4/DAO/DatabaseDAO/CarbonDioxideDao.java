package en.via.SEP4.DAO.DatabaseDAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CarbonDioxideDao extends JpaRepository<CarbonDioxideEntity, Long> {
    CarbonDioxideEntity findFirstBySensorEntityArchiveEntityIdOrderByIdDesc(Long archiveId);
    List<CarbonDioxideEntity> findBySensorEntityArchiveEntityId(Long archiveId);
}
