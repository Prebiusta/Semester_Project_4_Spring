package en.via.SEP4.Service;

import en.via.SEP4.Model.DBModel.TemperatureEntity;
import en.via.SEP4.Model.Utility.StatisticsValues;

import java.util.Date;
import java.util.List;

public interface TemperatureService {
    List<TemperatureEntity> getAllTemperatureMeasurementsFromArchiveId(Long archiveId);
    List<StatisticsValues> getTemperatureMeasurementsByDateInterval(Long archiveId, Date startDate, Date endDate);
    float getAverageTemperatureMeasurementForArchiveByDateInterval(Long archiveId, Date startDate, Date endDate);
}
