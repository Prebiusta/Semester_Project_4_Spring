package en.via.SEP4.DAO.DatabaseDAO;

import en.via.SEP4.Model.DBModel.HumidityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HumidityDao extends JpaRepository<HumidityEntity,Long> {
    HumidityEntity findFirstBySensorEntityArchiveEntityIdOrderByIdDesc(Long archiveId);
    List<HumidityEntity> findBySensorEntityArchiveEntityId(Long archiveId);
}
