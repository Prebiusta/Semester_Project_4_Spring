package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface CarbonDioxideService {
    CarbonDioxideEntity addCarbonDioxideMeasurementToArchive(Long archiveId, CarbonDioxideEntity carbonDioxideMeasurement);
    Page<CarbonDioxideEntity> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId, Pageable pageable);
    Page<CarbonDioxideEntity> getCarbonDioxideMeasurementsByDate(Long archiveId, Date date, Pageable pageable);
    Page<CarbonDioxideEntity> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate, Pageable pageable);
}
