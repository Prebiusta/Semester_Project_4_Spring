package en.via.SEP4.DAO.DatabaseDAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HumidityDao extends JpaRepository<HumidityEntity,Long> {
    HumidityEntity findFirstBySensorEntityArchiveEntity_IdOrderByIdDesc(Long archiveId);
    List<HumidityEntity> findBySensorEntityArchiveEntity_Id(Long archiveId);
}
