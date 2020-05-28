package en.via.SEP4.DAO.WarehouseDAO;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.DWModel.FactCarbonDioxideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FactCarbonDioxideDao extends JpaRepository<FactCarbonDioxideEntity,Long> {
    List<CarbonDioxideEntity> findAllByArchiveArchiveIdAndDate_RepresentedDateBetween(Long archiveId, Date startDate, Date endDate);
}
