package en.via.SEP4.DAO.WarehouseDAO;


import en.via.SEP4.Model.DWModel.FactTemperatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FactTemperatureDao extends JpaRepository<FactTemperatureEntity,Long> {
    List<FactTemperatureEntity> findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(Long archiveId, Date startDate, Date endDate);
}
