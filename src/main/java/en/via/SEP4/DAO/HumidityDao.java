package en.via.SEP4.DAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface HumidityDao extends JpaRepository<HumidityEntity,Long> {
    Page<HumidityEntity> findByArchiveEntityId(Long archiveId, Pageable pageable);
    Page<HumidityEntity> findByArchiveEntityIdAndDate(Long archiveId, Date date, Pageable pageable);
    Page<HumidityEntity> findByArchiveEntityIdAndDateBetween(Long archiveId, Date startDate, Date endDate, Pageable pageable);
    HumidityEntity findFirstByOrderByIdDesc();

}
