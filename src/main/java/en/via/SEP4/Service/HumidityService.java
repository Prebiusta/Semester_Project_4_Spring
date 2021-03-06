package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.HumidityEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface HumidityService {
    List<HumidityEntity> getAllHumidityMeasurementsFromArchiveId(Long archiveId);
    List<StatisticsValues> getHumidityMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate);
    float getAverageHumidityMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate);

}
