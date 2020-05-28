package en.via.SEP4.DAO.DatabaseDAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HumidityDao extends JpaRepository<HumidityEntity,Long> {
    List<HumidityEntity> findByArchiveEntityId(Long archiveId);
    List<HumidityEntity> findByArchiveEntityIdAndDateBetween(Long archiveId, Date startDate, Date endDate);
    HumidityEntity findFirstByArchiveEntityIdOrderByIdDesc(Long archiveId);

}
