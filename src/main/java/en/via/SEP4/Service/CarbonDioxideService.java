package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.CarbonDioxideEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CarbonDioxideService {
    CarbonDioxideEntity addCarbonDioxideMeasurementToArchive(Long archiveId, CarbonDioxideEntity carbonDioxideMeasurement);
    List<CarbonDioxideEntity> getAllCarbonDioxideMeasurementsFromArchiveId(Long archiveId);
    List<StatisticsValues> getCarbonDioxideMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate);
    float getAverageCarbonDioxideMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate);
}
